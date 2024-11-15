package com.example.tema1relacion1ejerciciio2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "TiradaDado", value = "/hello-servlet")
public class TiradaDado extends HttpServlet {
    private String message;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Integer> lista = new ArrayList<>();
        int numDados = ((int) (Math.random() * 6))+ 2;
        for (int indice = 0; indice < numDados; indice++) {
            lista.add((int) (Math.random() * 6)+ 1);
        }
        List <Integer> listaOrdenada = new ArrayList<>(lista);
        listaOrdenada.sort(Integer::compareTo);

    }



    public void destroy() {
    }
}