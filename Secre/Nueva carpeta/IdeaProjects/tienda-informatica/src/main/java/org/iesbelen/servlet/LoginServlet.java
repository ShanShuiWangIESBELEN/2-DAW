package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iesbelen.dao.UsuarioDAO;
import org.iesbelen.dao.UsuarioDAOImpl;
import org.iesbelen.model.Usuario;

import java.io.IOException;
import java.util.List;



@WebServlet(name = "loginServlet", value = "/tienda/login/*")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * HTTP Method: GET
     * Paths:
     * 		/login/
     * 		/login/{id}
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            try {
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuario-login.jsp");
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuario.jsp");
            }

            dispatcher.forward(request, response);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;


        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        UsuarioDAO usu = new UsuarioDAOImpl();
        Usuario usuComparar = usu.validar(usuario, password);

        if (usuComparar != null) {
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("usuarioLogin", usuComparar);

            response.sendRedirect(request.getContextPath() + "/");

        } else {
            request.setAttribute("Error", "Usuario o contraseña incorrecta");
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/usuarios/usuario-login.jsp");
            dispatcher.forward(request, response);

        }
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        String codigo = request.getParameter("codigo");
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
        Usuario usu = new Usuario();

        try {
            int id = Integer.parseInt(codigo);

            usu.setIdUsuario(id);
            usu.setUsuario(usuario);
            usu.setPassword(password);
            usu.setRol(rol);

            usuarioDAO.update(usu);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    {
        RequestDispatcher dispatcher;
        UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
        String codigo = request.getParameter("codigo");

        try {
            int id = Integer.parseInt(codigo);

            usuarioDAO.delete(id);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
}
