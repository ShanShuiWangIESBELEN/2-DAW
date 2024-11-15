package com.Anotacion.ej2;
import com.Anotacion.ej2.Empleado.Empleado;

public class Principal {
    public static void main(String[] args) {
        Empresa empresa = Empresa.cargadorDeContexto();
        System.out.println(empresa.toString());
    }
    }

