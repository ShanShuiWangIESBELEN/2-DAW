package org.iesbelen.servlet;

import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.dao.ProductoDAOImpl;
import org.iesbelen.model.Producto;

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

@WebServlet(name = "ProductoServlet", value = "/productos/*")
public class ProductoServlet extends HttpServlet {
    private ProductoDAO productoDAO;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/TiendaDigital", "root", "12345678"
            );
            productoDAO = new ProductoDAOImpl();
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Error al inicializar el servlet", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo(); // Obtiene la ruta después de /productos
        response.setContentType("text/html;charset=UTF-8");

        try {
            if (pathInfo == null || "/".equals(pathInfo)) {
                // Lista de productos
                List<Producto> productos = productoDAO.obtenerTodos();
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("/WEB-INF/jsp/producto/lista.jsp").forward(request, response);
            } else if ("/crear".equals(pathInfo)) {
                // Mostrar formulario para crear un producto
                request.getRequestDispatcher("/WEB-INF/jsp/producto/nuevoProducto.jsp").forward(request, response);
            } else if (pathInfo.startsWith("/editar/")) {
                // Mostrar formulario para editar un producto
                try {
                    int id = Integer.parseInt(pathInfo.split("/")[2]); // Extrae el ID de la ruta
                    Producto producto = productoDAO.obtenerPorId(id);
                    if (producto != null) {
                        request.setAttribute("producto", producto);
                        request.getRequestDispatcher("/WEB-INF/jsp/producto/editarProducto.jsp").forward(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Producto no encontrado");
                    }
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
                }
            } else if (pathInfo.matches("^/\\d+$")) { // Manejar "/productos/{id}"
                // Mostrar detalles del producto
                try {
                    int id = Integer.parseInt(pathInfo.substring(1)); // Extrae el ID del producto
                    Producto producto = productoDAO.obtenerPorId(id);
                    if (producto != null) {
                        request.setAttribute("producto", producto);
                        request.getRequestDispatcher("/WEB-INF/jsp/producto/detalle.jsp").forward(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Producto no encontrado");
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
        String pathInfo = request.getPathInfo();

        /*No me funciona el editar, es algo relacionado con el idCategoria y Pero no se solucionarlo*/
        try {
            if (pathInfo != null && pathInfo.startsWith("/editar/")) {
                // Validar y procesar la edición de un producto
                try {
                    int id = Integer.parseInt(pathInfo.split("/")[2]); // ID del producto desde la URL
                    String nombre = request.getParameter("nombre");
                    String descripcion = request.getParameter("descripcion");
                    String precioParam = request.getParameter("precio");
                    String stockParam = request.getParameter("stock");
                    String idCategoriaParam = request.getParameter("id_categoria");

                    // Validar que los campos no sean nulos
                    if (nombre == null || descripcion == null || precioParam == null || stockParam == null || idCategoriaParam == null) {
                        throw new IllegalArgumentException("Parámetros faltantes.");
                    }

                    // Convertir valores a los tipos esperados
                    double precio = Double.parseDouble(precioParam);
                    int stock = Integer.parseInt(stockParam);
                    int idCategoria = Integer.parseInt(idCategoriaParam);

                    // Crear y actualizar el producto
                    Producto producto = new Producto();
                    producto.setId(id);
                    producto.setNombre(nombre);
                    producto.setDescripcion(descripcion);
                    producto.setPrecio(precio);
                    producto.setStock(stock);
                    producto.setIdCategoria(idCategoria);

                    productoDAO.actualizar(producto);
                    response.sendRedirect(request.getContextPath() + "/productos");
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Datos inválidos: asegúrate de que los campos numéricos son correctos.");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Ruta no válida");
            }
        } catch (Exception e) {
            throw new ServletException("Error al procesar la solicitud", e);
        }
    }
}