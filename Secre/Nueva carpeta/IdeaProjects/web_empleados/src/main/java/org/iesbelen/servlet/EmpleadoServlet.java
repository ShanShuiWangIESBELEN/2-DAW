package org.iesbelen.servlet;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesbelen.dao.DepartamentoDAO;
import org.iesbelen.dao.DepartamentoDAOImpl;
import org.iesbelen.dao.EmpleadoDAO;
import org.iesbelen.dao.EmpleadoDAOImpl;
import org.iesbelen.model.Departamento;
import org.iesbelen.model.Empleado;

@WebServlet(name = "empleadoServlet", value = "/sitio/empleado/*")
public class EmpleadoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            EmpleadoDAO emDAO = new EmpleadoDAOImpl();

            List<Empleado> listaEm = emDAO.getAll();


            request.setAttribute("listaEm", listaEm);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/empleado.jsp");

        } else {


            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {

                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/crear-empleado.jsp");

            } else if (pathParts.length == 2) {

                try {

                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/detalle-empleado.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/empleado.jsp");
                }
            } else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {

                EmpleadoDAO emDAO = new EmpleadoDAOImpl();
                try {
                    request.setAttribute("empleado", emDAO.find(Integer.parseInt((pathParts[2]))));
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/editar-empleado.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/empleado.jsp");
                }
            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/empleado/empleado.jsp");

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

        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            doPut(request, response);

        } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
            doDelete(request, response);
        } else {
            System.out.println("Opción POST no soportada.");
        }

        response.sendRedirect(request.getContextPath() + "/sitio/empleado");
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        EmpleadoDAO emDAO = new EmpleadoDAOImpl();
        String codigo = request.getParameter("codigo");
        String nif = request.getParameter("nif");
        String nombre = request.getParameter("nombre");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String codigo_departamento = request.getParameter("codigo_departamento");
        Empleado em = new Empleado();

        try {

            int id = Integer.parseInt(codigo);
            em.setCodigo(id);
            em.setNif(nif);
            em.setNombre(nombre);
            em.setApellido1(apellido1);
            em.setApellido2(apellido2);

            if(codigo_departamento != null){
                em.setCodigo_departamento(Integer.parseInt(codigo_departamento));
            }else{
                em.setCodigo_departamento(0);
            }

            emDAO.update(em);

        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    {

    }
}
