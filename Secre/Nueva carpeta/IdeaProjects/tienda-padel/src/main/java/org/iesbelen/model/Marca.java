package org.iesbelen.model;

import java.util.Objects;

public class Marca {

    private int codigo;
    private String nombre;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return codigo == marca.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
