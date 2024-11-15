package com.example.ejercicio3.entity;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellidos;
    private String edad;
    private String peso;
    private String sexo;

    private String estadoCivil;
    private List<String> aficiones;

    public Usuario() {

    }

    public Usuario(String nombre, String apellidos, String edad, String peso, String sexo, String estadoCivil, List<String> aficiones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.aficiones = new ArrayList<>(aficiones);
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<String> getAficiones() {
        return aficiones;
    }

    public void setAficiones(List<String> aficiones) {
        this.aficiones = aficiones;
    }

    @Override
    public String toString() {
        return "Usuario" +
                " Nombre: " + nombre +
                " Apellidos: " + apellidos +
                " Edad: " + edad +
                " Peso: " + peso +
                " Sexo: " + sexo +
                " Estado Civil: " + estadoCivil +
                " Aficiones: " + aficiones;
    }
}
