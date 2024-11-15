package com.Anotacion.ej1;

import com.Anotacion.ej1.cargos.Directivo;
import com.Anotacion.ej1.cargos.Oficial;
import com.Anotacion.ej1.cargos.Tecnico;

import java.util.ArrayList;
import java.util.List;

@EmpleadoAn(
        nombre = "Shanshui",
        apellidos = "Wang",
        dni = "Y1251612F",
        direccion = "La luz",
        telefono = "123456789",
        clase = "Directivo",
        codigoDespacho = 1
)
@EmpleadoAn(
        nombre = "Juan",
        apellidos = "Perez",
        dni = "Y1251612F",
        direccion = "La Paz",
        telefono = "837182951",
        clase = "Tecnico",
        codigoDespacho = 2
)
@EmpleadoAn(
        nombre = "Samuel",
        apellidos = "García",
        dni = "Y9999999F",
        direccion = "La Paz",
        telefono = "837182951",
        clase = "Oficial",
        codigoDespacho = 3
)



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
    public void anadirEmpleado(Empleado empleado){
        this.empleadoList.add(empleado);
    }



    public static Empresa cargadorDeContexto(){
        Empresa empresa = new Empresa("");
        EmpleadoAn[] anotaciones = Empresa.class.getAnnotationsByType(EmpleadoAn.class);

        for (EmpleadoAn ea : anotaciones) {
            if ("Directivo".equals(ea.clase())){
                Directivo directivo = new Directivo(ea.nombre(), ea.apellidos(), ea.dni(), ea.direccion(), ea.telefono(), ea.codigoDespacho());
                empresa.anadirEmpleado(directivo);
            } else if("Tecnico".equals(ea.clase())){
                Tecnico tecnico = new Tecnico(ea.nombre(), ea.apellidos(), ea.dni(), ea.direccion(), ea.telefono(),ea.codigoTaller(),ea.perfil());
                empresa.anadirEmpleado(tecnico);
            } else if ( "Oficial".equals(ea.clase())) {
                Oficial oficial = new Oficial( ea.nombre(), ea.apellidos(), ea.dni(), ea.direccion(), ea.telefono(), ea.codigoDespacho(), ea.categoria());
                empresa.anadirEmpleado(oficial);
            }


        }

        return empresa;


    }

    @Override
    public String toString() {
        String res = "Empresa: " + nombre + "\nEmpleados:" + "\n";
        for (Empleado empleado : empleadoList) {
            res += empleado.toString() + "\n";
        }
        return res + "----------------------------------------------------------------------------------------------------------------------------";
    }
}
