package lista;

import java.util.ArrayList;
import java.util.Collections;

    public class ListaOrdenada<E extends Comparable<E>> {
        private ArrayList<E> elementos;

        public ListaOrdenada() {
            this.elementos = new ArrayList<>();
        }

        public void add(E o) {
            elementos.add(o);
            Collections.sort(elementos);
        }

        public E get(int index) {
            if (index >= 0 && index < elementos.size()) {
                return elementos.get(index);
            }
            return null;
        }

        public int size() {
            return elementos.size();
        }

        public boolean isEmpty() {
            return elementos.isEmpty();
        }

        public boolean remove(E o) {
            return elementos.remove(o);
        }

        public int indexOf(E o) {
            return elementos.indexOf(o);
        }

        public String toString() {
            return elementos.toString();
        }
    }
