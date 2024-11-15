package com.Anotacion.ej1;


public class Empleado {
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private String telefono;
    private String clase;


    public Empleado(String nombre, String apellidos, String direccion, String dni, String telefono) {
        clase = this.getClass().getSimpleName();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.dni = dni;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String toString(){
        return "Nombre: "+nombre+" | " +
                "Apellidos: " +apellidos+" | " +
                "DNI: "+dni+" | " +
                "Direccion: "+direccion+" | " +
                "Telefono: "+telefono+" | " +
                "Clase: "+clase+" | ";

    }
}

