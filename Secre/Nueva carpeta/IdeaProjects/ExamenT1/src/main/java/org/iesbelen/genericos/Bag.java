package org.iesbelen.genericos;

import java.util.*;

public class Bag <T>{

    private List<T> lista;

    public Bag() {
        this.lista = new ArrayList<>();
    }

    public boolean add (T e){
        return lista.add(e);
    }

    public boolean add(T e, int n){
        if (n == 0){
            return false;
        }

        for (int indice = 0; indice < n; indice++) {
            lista.add(e);
        }
        return true;
    }

    public int getCount(T e){
        int contador = 0;
        for (T elemento : lista) {
            if (elemento.equals(e)) {
                contador++;
            }
        }
        return contador;
    }

    public boolean remove(T e){
        if (!lista.contains(e)) {
            return false;
        }
        for (int indice = 0; indice < lista.size(); indice++) {
            if (lista.get(indice).equals(e)){
                lista.remove(indice);
            }
        }
        return true;
    }

    public boolean remove(T e, int n){
        if (!lista.contains(e)) {
            return false;
        }
        for (int indice = 0; indice < lista.size(); indice++) {
            if (lista.get(indice).equals(e) && n > 0 ){
                lista.remove(indice);
                n--;
            }
        }
        return true;
    }

    public int size(){
        return lista.size();
    }

    public Set uniqueSet(){
        Set<T> set= new HashSet<>(lista);
        return set;
    }

    public String toString(){

        String cadena = "";

        for (int indice = 0; indice < lista.size(); indice++) {
            cadena += lista.get(indice).toString();
        }
        return cadena;
    }


}
