package com.example.ejercicio3.servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.ejercicio3.entity.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "formulario", value = "/formulario")
public class FormularioServlet extends HttpServlet {
    private List<Usuario> listUsuarios = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        listUsuarios.add(new Usuario("Pedro", "Ramirez", "Mayor de Edad", "81", "Hombre", "Casado", new ArrayList<>(List.of("cine", "television"))));
        listUsuarios.add(new Usuario("Ana", "Gutierrez", "Menor de Edad", "54", "Mujer", "Soltero", new ArrayList<>(List.of("literatura"))));
        listUsuarios.add(new Usuario("Luis", "Miguel", "Mayor de Edad", "64", "Hombre", "Otro", new ArrayList<>(List.of("deporte", "tebeos"))));


        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("listUsuarios", listUsuarios);

        response.sendRedirect("mostrarUsuarios.jsp");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellidos");
        String edad = request.getParameter("edad");
        String peso = request.getParameter("peso");
        String sexo = request.getParameter("sexo");
        String estadoCivil = request.getParameter("estadoCivil");
        List<String> aficiones;
        try {
            aficiones = List.of(request.getParameterValues("aficiones"));
        } catch (Exception e) {
            String message = e.getMessage();
            aficiones = new ArrayList<>(Collections.emptyList());
        }


        listUsuarios.add(new Usuario(nombre, apellido, edad, peso, sexo, estadoCivil, aficiones));


        response.sendRedirect("index.jsp");


    }
}