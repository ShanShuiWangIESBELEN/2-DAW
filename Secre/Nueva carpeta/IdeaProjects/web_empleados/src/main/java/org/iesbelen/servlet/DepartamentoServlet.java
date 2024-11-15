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
import org.iesbelen.dto.DepartamentoDTO;
import org.iesbelen.model.Departamento;

@WebServlet(name = "departamentoServlet", value = "/sitio/departamento/*")
public class DepartamentoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;

        String pathInfo = request.getPathInfo(); //

        if (pathInfo == null || "/".equals(pathInfo)) {
            DepartamentoDAO deDAO = new DepartamentoDAOImpl();
            //int min = Integer.parseInt(request.getParameter("min")); NO ME HA DADO TIEMPO A HACER EL FILTRO
           // int max = Integer.parseInt(request.getParameter("max"));


            List<DepartamentoDTO> departamentoDTO = deDAO.getAll().stream()
                    .map(departamento -> {
                        Optional<Integer> numEmpleado = deDAO.getCountEmpleados(departamento.getCodigo());
                        DepartamentoDTO deDTO = new DepartamentoDTO();
                        deDTO.setCodigo(departamento.getCodigo());
                        deDTO.setNombre(departamento.getNombre());
                        deDTO.setPresupuesto(departamento.getPresupuesto());
                        deDTO.setGastos(departamento.getGastos());
                        deDTO.setCountEmpleados(numEmpleado.orElse(0));
                        return deDTO;
                    }).toList();


           /* if (min != 0 || max != 0){
                departamentoDTO = deDAO.filtrar(max, min);
            }*/

            request.setAttribute("listaDep", departamentoDTO);
            dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/departamento.jsp");

        } else {


            pathInfo = pathInfo.replaceAll("/$", "");
            String[] pathParts = pathInfo.split("/");

            if (pathParts.length == 2 && "crear".equals(pathParts[1])) {


                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/crear-departamento.jsp");

            } else if (pathParts.length == 2) {

                try {

                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/detalle-departamento.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/departamento.jsp");
                }
            } else if (pathParts.length == 3 && "editar".equals(pathParts[1]) ) {

                try {
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/editar-departamento.jsp");

                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();
                    dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/departamento.jsp");
                }
            } else {
                System.out.println("Opción POST no soportada.");
                dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/departamento/departamento.jsp");

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
            DepartamentoDAO deDAO = new DepartamentoDAOImpl();

            String nombre = request.getParameter("nombre");
            Double presupuesto = Double.valueOf(request.getParameter("presupuesto"));
            Double gastos = Double.valueOf(request.getParameter("gastos"));

            Departamento nuevoDe = new Departamento();
            nuevoDe.setNombre(nombre);
            nuevoDe.setPresupuesto(presupuesto);
            nuevoDe.setGastos(gastos);
            deDAO.create(nuevoDe);

        } else if (__method__ != null && "put".equalsIgnoreCase(__method__)) {
            doPut(request, response);

        } else if (__method__ != null && "delete".equalsIgnoreCase(__method__)) {
            doDelete(request, response);
        } else {
            System.out.println("Opción POST no soportada.");
        }

        response.sendRedirect(request.getContextPath() + "/sitio/departamento");
    }


    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
    {

    }
}
