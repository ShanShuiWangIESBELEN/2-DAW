package org.iesbelen.servlet;

import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.model.Producto;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class CategoriasServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoriaId = request.getParameter("categoria");
        ProductoDAO productoDAO = new ProductoDAO();

        // Recuperar productos de la categoría seleccionada
        List<Producto> productos = productoDAO.obtenerProductosPorCategoria(Integer.parseInt(categoriaId));

        // Pasar los productos a la vista
        request.setAttribute("productos", productos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/views/categorias.jsp");
        dispatcher.forward(request, response);
    }
}
