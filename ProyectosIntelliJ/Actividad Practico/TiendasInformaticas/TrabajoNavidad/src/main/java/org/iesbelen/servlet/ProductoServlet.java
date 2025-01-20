package org.iesbelen.servlet;


import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.model.Producto;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ProductoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productoId = request.getParameter("productoId");
        ProductoDAO productoDAO = new ProductoDAO();

        // Recuperar información del producto
        Producto producto = productoDAO.obtenerProductoPorId(Integer.parseInt(productoId));

        // Pasar el producto a la vista
        request.setAttribute("producto", producto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/views/productos.jsp");
        dispatcher.forward(request, response);
    }
}
