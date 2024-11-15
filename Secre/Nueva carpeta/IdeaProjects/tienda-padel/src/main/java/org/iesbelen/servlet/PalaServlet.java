package org.iesbelen.servlet;

        import jakarta.servlet.RequestDispatcher;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;
        import org.iesbelen.dao.PalaDAOImpl;
        import org.iesbelen.dao.PalaDAO;
        import org.iesbelen.model.Pala;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

@WebServlet(name = "palaServlet", value = "/tienda/pala/*")
public class PalaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            PalaDAO palaDAO = new PalaDAOImpl();



            String filtro = request.getParameter("filtrar-por");
            List<Pala> listaPala;

            if (filtro != null) {
                listaPala = palaDAO.filtrar(filtro);
            }else {
                listaPala = palaDAO.getAll();
            }

            request.setAttribute("listaPala", listaPala);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pala/pala.jsp");


        } else {

            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "carrito-pala".equals(pathParts[1])) {

                PalaDAO palaDAO = new PalaDAOImpl();
                List<Optional<Pala>> carrito = new ArrayList<>();
                if (request.getParameter("carrito1").equals("carrito1")){
                    carrito.add(palaDAO.find(1));
                }else if (request.getParameter("carrito2").equals("carrito2")){
                    carrito.add(palaDAO.find(2));
                }else if (request.getParameter("carrito3").equals("carrito3")){
                    carrito.add(palaDAO.find(3));
                }else if (request.getParameter("carrito4").equals("carrito4")){
                    carrito.add(palaDAO.find(4));
                }else if (request.getParameter("carrito5").equals("carrito5")){
                    carrito.add(palaDAO.find(5));
                }else if (request.getParameter("carrito6").equals("carrito6")){
                    carrito.add(palaDAO.find(6));
                }else if (request.getParameter("carrito7").equals("carrito7")){
                    carrito.add(palaDAO.find(7));
                }else if (request.getParameter("carrito8").equals("carrito8")){
                    carrito.add(palaDAO.find(8));
                }else if (request.getParameter("carrito9").equals("carrito9")){
                    carrito.add(palaDAO.find(9));
                }

                request.setAttribute("carrito", carrito);
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pala/carrito-pala.jsp");


            } else if (pathParts.length == 2) {
                PalaDAO palaDAO = new PalaDAOImpl();

                try {
                    request.setAttribute("pala",palaDAO.find(Integer.parseInt(pathParts[1])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pala/detalle-pala.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pala/pala.jsp");
                }

            } else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {
                PalaDAO palaDAO = new PalaDAOImpl();

                try {
                    request.setAttribute("pala", palaDAO.find(Integer.parseInt(pathParts[2])));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editar-pala.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pala/pala.jsp");
                }


            } else {

                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pala/pala.jsp");

            }

        }

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String __method__ = request.getParameter("__method__");

        if (__method__ == null) {

            PalaDAO palaDAO = new PalaDAOImpl();

            String modelo = request.getParameter("modelo");
            String tipo = request.getParameter("tipo");
            String precio = request.getParameter("precio");
            String codigoMarca = request.getParameter("marca");

            Pala nuevoPala = new Pala();
            nuevoPala.setModelo(modelo);
            nuevoPala.setTipo(tipo);
            nuevoPala.setPrecio(Double.parseDouble(precio));
            nuevoPala.setCodigoMarca(Integer.parseInt(codigoMarca));
            palaDAO.create(nuevoPala);

        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            doPut(request, response);

        } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
            doDelete(request, response);

        } else {
            System.out.println("Opción POST no soportada.");
        }

        response.sendRedirect(request.getContextPath() + "/tienda/pala");
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PalaDAO palaDAO = new PalaDAOImpl();
        String codigo = request.getParameter("codigo");
        String precio = request.getParameter("precio");
        String modelo = request.getParameter("modelo");
        String tipo = request.getParameter("tipo");
        Pala pala = new Pala();

        try {

            int id = Integer.parseInt(codigo);
            double pr = Double.parseDouble(precio);

            pala.setCodigo(id);
            pala.setTipo(tipo);
            pala.setModelo(modelo);
            pala.setPrecio(pr);
            palaDAO.update(pala);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    {
        RequestDispatcher dispatcher;
        PalaDAO palaDAO = new PalaDAOImpl();
        String codigo = request.getParameter("codigo");

        try {

            int id = Integer.parseInt(codigo);

            palaDAO.delete(id);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }
}
