package org.iesbelen.servlet;

import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.dao.CategoriaDAOImpl;
import org.iesbelen.model.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoriaServlet", value = "/categorias/*")
public class CategoriaServlet extends HttpServlet {
    private CategoriaDAO categoriaDAO;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/TiendaDigital", "root", "12345678"
            );
            categoriaDAO = new CategoriaDAOImpl();
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Error al inicializar el servlet", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // Obtiene la ruta después de /categorias
        response.setContentType("text/html;charset=UTF-8");

        try {
            if (pathInfo == null || "/".equals(pathInfo)) {
                // Lista de categorías
                List<Categoria> categorias = categoriaDAO.obtenerTodas();
                request.setAttribute("categorias", categorias);
                request.getRequestDispatcher("/WEB-INF/jsp/categoria/lista.jsp").forward(request, response);
            } else if ("/crear".equals(pathInfo)) {
                // Mostrar formulario para crear una categoría
                request.getRequestDispatcher("/WEB-INF/jsp/categoria/nuevaCategoria.jsp").forward(request, response);
            } else if (pathInfo.startsWith("/editar/")) {
                // Mostrar formulario para editar una categoría
                try {
                    String[] pathParts = pathInfo.split("/");
                    int id = Integer.parseInt(pathParts[2]); // Extrae el ID de la ruta
                    Categoria categoria = categoriaDAO.obtenerPorId(id);
                    if (categoria != null) {
                        request.setAttribute("categoria", categoria);
                        request.getRequestDispatcher("/WEB-INF/jsp/categoria/editarCategoria.jsp").forward(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Categoría no encontrada");
                    }
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
                }
            } else if (pathInfo.matches("^/\\d+$")) {
                // Detalles de una categoría
                try {
                    int id = Integer.parseInt(pathInfo.substring(1)); // Extrae el ID de la ruta
                    Categoria categoria = categoriaDAO.obtenerPorId(id);
                    if (categoria != null) {
                        request.setAttribute("categoria", categoria);
                        request.getRequestDispatcher("/WEB-INF/jsp/categoria/detalle.jsp").forward(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Categoría no encontrada");
                    }
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ruta no válida");
            }
        } catch (Exception e) {
            throw new ServletException("Error al procesar la solicitud", e);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // Obtiene la ruta después de /categorias
        response.setContentType("text/html;charset=UTF-8");

        try {
            if (pathInfo == null || "/".equals(pathInfo)) {
                // Crear una nueva categoría
                String nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");

                if (nombre == null || nombre.trim().isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El nombre no puede estar vacío");
                    return;
                }

                Categoria categoria = new Categoria();
                categoria.setNombre(nombre);
                categoria.setDescripcion(descripcion);

                categoriaDAO.insertar(categoria);
                response.sendRedirect(request.getContextPath() + "/categorias");
            } else if ("/eliminar".equals(pathInfo)) {
                // Eliminar una categoría
                String idParam = request.getParameter("id");
                if (idParam == null || idParam.isEmpty()) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID no proporcionado");
                    return;
                }

                try {
                    int id = Integer.parseInt(idParam);
                    categoriaDAO.eliminar(id);
                    response.sendRedirect(request.getContextPath() + "/categorias");
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
                }
            } else if (pathInfo.startsWith("/editar/")) {
                // Actualizar una categoría
                String[] pathParts = pathInfo.split("/");
                if (pathParts.length == 3) {
                    try {
                        int id = Integer.parseInt(pathParts[2]);
                        String nombre = request.getParameter("nombre");
                        String descripcion = request.getParameter("descripcion");

                        if (nombre == null || nombre.trim().isEmpty()) {
                            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El nombre no puede estar vacío");
                            return;
                        }

                        Categoria categoria = new Categoria();
                        categoria.setId(id);
                        categoria.setNombre(nombre);
                        categoria.setDescripcion(descripcion);

                        categoriaDAO.actualizar(categoria);
                        response.sendRedirect(request.getContextPath() + "/categorias");
                    } catch (NumberFormatException e) {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ruta no válida para editar");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no soportada");
            }
        } catch (Exception e) {
            throw new ServletException("Error al procesar la solicitud", e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Categoria categoria = categoriaDAO.obtenerPorId(id);
            if (categoria != null) {
                categoria.setNombre(request.getParameter("nombre"));
                categoria.setDescripcion(request.getParameter("descripcion"));

                categoriaDAO.actualizar(categoria);
                response.sendRedirect(request.getContextPath() + "/categorias");
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Categoría no encontrada");
            }
        } catch (Exception e) {
            throw new ServletException("Error al actualizar la categoría", e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            categoriaDAO.eliminar(id);
            response.sendRedirect(request.getContextPath() + "/categorias");
        } catch (Exception e) {
            throw new ServletException("Error al eliminar la categoría", e);
        }
    }
}