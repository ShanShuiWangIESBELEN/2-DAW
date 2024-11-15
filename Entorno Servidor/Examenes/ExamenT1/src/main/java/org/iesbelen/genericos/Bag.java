package org.iesbelen.genericos;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bag<T> {

    private Map<T, Integer> elementos;

    public Bag() {
        elementos = new HashMap<T, Integer>();
    }

    public void add(T e) {
        if (elementos.containsKey(e)) {
            int cantidadActual = elementos.get(e);
            elementos.put(e, cantidadActual + 1);
        } else {
            elementos.put(e, 1);
        }
    }

    public void add(T e, int n) {
        if (elementos.containsKey(e)) {
            int cantidadActual = elementos.get(e);
            elementos.put(e, cantidadActual + n);
        } else {
            elementos.put(e, n);
        }
    }

    public int getCount(T e) {
        if (elementos.containsKey(e)) {
            return elementos.get(e);
        } else {
            return 0;
        }
    }

    public void remove(T e) {
        elementos.remove(e);
    }

    public void remove(T e, int n) {
        if (elementos.containsKey(e)) {
            int cantidadActual = elementos.get(e);
            elementos.put(e, cantidadActual - n);
        } else {
            elementos.remove(e);
        }
    }

    public int size() {
        int tamano = 0;
        for (int elemento : elementos.values()) {
            tamano += elemento;
        }
        return tamano;
    }
    public Set<T> uniqueSet(){
        return elementos.keySet();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<T, Integer> entry : elementos.entrySet()) {
            sb.append(entry.getKey()).append(" x ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

}
