package org.iesbelen.genericos;

import java.util.*;

public class Bag<T> {
    List<T> lista;

    public Bag() {
        this.lista = new ArrayList<>();
    }

    public boolean add(T e) {
        return lista.add(e);
    }

    public void add(T e, int n){
        for (int i = 0; i < n; i++) {
            lista.add(e);
        }
    }

    public Integer getCount(T e){
        int cont = 0;
        for(T elem : lista){
            if(elem.equals(e)){
                cont++;
            }
        }
        return cont;
    }

    public boolean remove(T e){
        return lista.remove(e);
    }

    public void remove(T e, int n){
        for (int i = 0; i < n; i++) {
            lista.remove(e);
        }
    }

    public Integer size(){
        return lista.size();
    }

    public Set<T> uniqueSet(){
        return new HashSet<>(lista);
    }

    @Override
    public String toString() {
        return "Bag: " + lista;
    }
}
