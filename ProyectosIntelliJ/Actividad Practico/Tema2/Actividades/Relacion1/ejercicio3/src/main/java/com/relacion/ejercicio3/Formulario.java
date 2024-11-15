package com.relacion.ejercicio3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formulario", value = "/formulario")
public class Formulario extends HttpServlet {

    private List<String> fomuFacil = new ArrayList<>();
    private List<String[]> fomuComp = new ArrayList<>();

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        fomuFacil.add(request.getParameter("nombre"));
        fomuFacil.add(request.getParameter("apellidos"));
        fomuFacil.add(request.getParameter("edad"));
        fomuFacil.add(request.getParameter("peso"));
        fomuComp.add(request.getParameterValues("sexo"));
        fomuComp.add(request.getParameterValues("estadoCivil"));
        fomuComp.add(request.getParameterValues("aficiones"));

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Formulario</h1>");
        out.println("<p>Nombre: " + fomuFacil.get(0) + "</p>");
        out.println("<p>Apellido: " + fomuFacil.get(1) + "</p>");
        out.println("<p>Edad: " + fomuFacil.get(2) + "</p>");
        out.println("<p>Peso: " + fomuFacil.get(3) + "kg"   +"</p>");

        for (int i = 0; i < fomuComp.getFirst().length; i++) {
            if (fomuComp.getFirst()[i] != null) {
                out.println("<p>Sexo: " + fomuComp.getFirst()[i] + "</p>");
            }else {
                return;
            }
        }

        for (int i = 0; i < fomuComp.get(1).length; i++) {
            if (fomuComp.get(1)[i] != null) {
                out.println("<p>Estado civil: "+ fomuComp.get(1)[i]+"</p>");
            }else {
                return;
            }
        }

        out.println("<p>Aficiones:</p>");
        for (int i = 0; i< fomuComp.get(2).length; i++) {
            if (fomuComp.get(2)[i] != null) {
                out.print("<p>&ensp;" + fomuComp.get(2)[i] + "</p>");
            }else {
                return;
            }
        }

        out.println("</body></html>");


    }

    public void destroy() {
    }
}