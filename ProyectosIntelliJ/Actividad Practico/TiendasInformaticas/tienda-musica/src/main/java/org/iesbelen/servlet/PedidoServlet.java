package org.iesbelen.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.dao.PedidoDAOImpl;
import org.iesbelen.model.Pedido;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PedidoServlet", value = "/pedidos/*")
public class PedidoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final PedidoDAO pedidoDAO = new PedidoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        RequestDispatcher dispatcher;

        try {
            if (pathInfo == null || "/".equals(pathInfo)) {
                // Listar pedidos
                List<Pedido> listaPedidos = pedidoDAO.obtenerTodos();
                request.setAttribute("listaPedidos", listaPedidos);
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/lista-pedidos.jsp");
            } else if (pathInfo.startsWith("/crear")) {
                // Crear pedido
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/crear-pedido.jsp");
            } else if (pathInfo.startsWith("/editar")) {
                // Editar pedido
                int idPedido = Integer.parseInt(pathInfo.split("/")[2]);
                Pedido pedido = pedidoDAO.obtenerPorId(idPedido);
                request.setAttribute("pedido", pedido);
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/editar-pedido.jsp");
            } else {
                // Detalle del pedido
                int idPedido = Integer.parseInt(pathInfo.replace("/", ""));
                Pedido pedido = pedidoDAO.obtenerPorId(idPedido);
                request.setAttribute("pedido", pedido);
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pedidos/detalle-pedido.jsp");
            }

            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Error interactuando con la base de datos", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        try {
            if (pathInfo.startsWith("/crear")) {
                handleCreate(request);
            } else if (pathInfo.startsWith("/editar")) {
                handleUpdate(request);
            } else if (pathInfo.startsWith("/eliminar")) {
                handleDelete(request);
            }

            response.sendRedirect(request.getContextPath() + "/pedidos");
        } catch (SQLException e) {
            throw new ServletException("Error procesando la solicitud", e);
        }
    }

    private void handleCreate(HttpServletRequest request) throws SQLException {
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        double total = Double.parseDouble(request.getParameter("total"));

        Pedido pedido = new Pedido();
        pedido.setIdUsuario(idUsuario);
        pedido.setTotal(total);

        pedidoDAO.insertar(pedido);
    }

    private void handleUpdate(HttpServletRequest request) throws SQLException {
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        double total = Double.parseDouble(request.getParameter("total"));

        Pedido pedido = new Pedido();
        pedido.setIdPedido(idPedido);
        pedido.setIdUsuario(idUsuario);
        pedido.setTotal(total);

        pedidoDAO.actualizar(pedido);
    }

    private void handleDelete(HttpServletRequest request) throws SQLException {
        int idPedido = Integer.parseInt(request.getParameter("idPedido"));
        pedidoDAO.eliminar(idPedido);
    }
}