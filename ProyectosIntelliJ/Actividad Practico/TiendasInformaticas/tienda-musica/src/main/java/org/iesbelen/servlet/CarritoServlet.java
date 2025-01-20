package org.iesbelen.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.iesbelen.dao.ProductoDAO;
import org.iesbelen.dao.ProductoDAOImpl;
import org.iesbelen.model.Producto;
import org.iesbelen.model.CarritoCompra;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CarritoServlet", value = "/carrito/*")
public class CarritoServlet extends HttpServlet {
    private ProductoDAO productoDAO = new ProductoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<CarritoCompra> carrito = (List<CarritoCompra>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
        }

        int totalCantidad = carrito.stream().mapToInt(CarritoCompra::getCantidad).sum();
        session.setAttribute("cantCart", totalCantidad);

        req.setAttribute("carrito", carrito);
        req.getRequestDispatcher("/WEB-INF/jsp/carrito/carrito.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<CarritoCompra> carrito = (List<CarritoCompra>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
            session.setAttribute("carrito", carrito);
        }

        String action = req.getParameter("action");

        if ("eliminar".equals(action)) {
            try {
                int productoId = Integer.parseInt(req.getParameter("productoId"));
                carrito.removeIf(item -> item.getProducto().getId() == productoId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            try {
                int productoId = Integer.parseInt(req.getParameter("productoId"));
                int cantidad = Integer.parseInt(req.getParameter("cantidad"));

                Producto producto = productoDAO.obtenerPorId(productoId);

                if (producto != null) {
                    boolean encontrado = false;
                    for (CarritoCompra item : carrito) {
                        if (item.getProducto().getId() == productoId) {
                            item.setCantidad(item.getCantidad() + cantidad);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        carrito.add(new CarritoCompra(producto, cantidad));
                    }
                }
            } catch (NumberFormatException | SQLException e) {
                e.printStackTrace();
            }
        }

        int totalCantidad = carrito.stream().mapToInt(CarritoCompra::getCantidad).sum();
        session.setAttribute("cantCart", totalCantidad);

        resp.sendRedirect(req.getContextPath() + "/carrito");
    }
}
