package com.example.demo.modelo;


public class Libro {

    private String titulo;
    private String autor;
    private String editorial;
    private  int id;


    public Libro(String titulo, String autor, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
    }
    public Libro(int id, String titulo, String autor, String editorial) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
    }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTitulo() { return titulo; }

    public void setAutor(String autor) { this.autor = autor; }

    public String getAutor() { return autor; }

    public void setEditorial(String editorial) { editorial = editorial; }

    public String getEditorial() { return editorial; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

}

