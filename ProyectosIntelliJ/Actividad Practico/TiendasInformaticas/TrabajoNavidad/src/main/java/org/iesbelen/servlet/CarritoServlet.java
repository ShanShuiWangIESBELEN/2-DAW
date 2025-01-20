package org.iesbelen.servlet;

import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.model.Producto;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarritoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Agregar producto al carrito
            String productoId = request.getParameter("productoId");
            ProductoDAO productoDAO = new ProductoDAO();
            Producto producto = productoDAO.obtenerProductoPorId(Integer.parseInt(productoId));

            if (producto != null) {
                carrito.add(producto);
            }

        } else if ("remove".equals(action)) {
            // Eliminar producto del carrito
            String productoId = request.getParameter("productoId");
            carrito.removeIf(producto -> producto.getId() == Integer.parseInt(productoId));
        }

        session.setAttribute("carrito", carrito);
        response.sendRedirect("carrito.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Producto> carrito = (List<Producto>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        request.setAttribute("carrito", carrito);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/views/carrito.jsp");
        dispatcher.forward(request, response);
    }
}
