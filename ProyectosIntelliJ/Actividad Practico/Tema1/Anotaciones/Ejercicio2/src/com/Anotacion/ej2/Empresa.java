package com.Anotacion.ej2;

import com.Anotacion.ej2.Empleado.Empleado;

import com.Anotacion.ej2.cargos.Directivo;
import com.Anotacion.ej2.cargos.Oficial;
import com.Anotacion.ej2.cargos.Tecnico;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

@Directivo(
        nombre = "Shanshui",
        apellidos = "Wang",
        dni = "Y1251612F",
        direccion = "La luz",
        telefono = "123456789",
        clase = "Directivo",
        codigoDespacho = 1
)
@Tecnico(
        nombre = "Juan",
        apellidos = "Perez",
        dni = "Y1251612F",
        direccion = "La Paz",
        telefono = "837182951",
        clase = "Tecnico",
        codigoDespacho = 2
)
@Oficial(
        nombre = "Samuel", apellidos = "García", dni = "Y9999999F", direccion = "La Paz", telefono = "837182951", clase = "Oficial", codigoDespacho = 3, categoria = "")



public class Empresa {
    private String nombre;
    private List<Empleado> empleadoList;

    public Empresa(String nombre) {
        this.nombre = nombre;
        empleadoList = new ArrayList<>();

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    public void anadirEmpleado(Empleado empleado) {
        this.empleadoList.add(empleado);
    }


    public static Empresa cargadorDeContexto() {
        Empresa empresa = new Empresa("La luz");
        Annotation[] anotaciones = Empresa.class.getAnnotations();
        for (Annotation anotacion : anotaciones) {
            if (anotacion instanceof Directivo directivo) {
                Empleado empleado = new Empleado(directivo.nombre(), directivo.apellidos(), directivo.dni(), directivo.direccion(), directivo.telefono());
                empleado.setClase("Directivo");
                empresa.anadirEmpleado(empleado);
            } else if (anotacion instanceof Tecnico tecnico) {
                Empleado empleado = new Empleado(tecnico.nombre(), tecnico.apellidos(), tecnico.dni(), tecnico.direccion(), tecnico.telefono());
                empleado.setClase("Tecnico");
                empresa.anadirEmpleado(empleado);
            } else if (anotacion instanceof Oficial oficial) {
                Empleado empleado = new Empleado(oficial.nombre(), oficial.apellidos(), oficial.dni(), oficial.direccion(), oficial.telefono());
                empleado.setClase("Oficial");
                empresa.anadirEmpleado(empleado);
            }
        }
            return empresa;
    }

        @Override
        public String toString () {
            String res = "Empresa: " + nombre + "\nEmpleados:" + "\n";
            for (Empleado empleado : empleadoList) {
                res += empleado.toString() + "\n";
            }
            return res + "----------------------------------------------------------------------------------------------------------------------------";
        }
    }

