package org.iesbelen.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.iesbelen.dao.CategoriaDAO;
import org.iesbelen.model.Categoria;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.obtenerCategorias();

        // Enviar categorías a la vista
        request.setAttribute("categorias", categorias);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/index.jsp");
        dispatcher.forward(request, response);
    }
}
