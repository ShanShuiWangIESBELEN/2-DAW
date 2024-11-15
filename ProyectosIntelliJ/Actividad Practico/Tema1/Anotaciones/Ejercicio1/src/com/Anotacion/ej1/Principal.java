package com.Anotacion.ej1;

public class Principal {
    public static void main(String[] args) {
        Empresa empresa = Empresa.cargadorDeContexto();
        System.out.println(empresa.toString());
    }
    }

