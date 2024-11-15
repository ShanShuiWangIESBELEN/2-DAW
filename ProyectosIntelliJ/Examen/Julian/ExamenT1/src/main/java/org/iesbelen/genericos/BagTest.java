package org.iesbelen.genericos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class BagTest {
    private Bag<Integer> bag;

    @BeforeEach
    public void setUp() {
        bag = new Bag<>();
    }

    @Test
    @DisplayName("Mete numeros")
    public void testAdd() {
        assertTrue(bag.add(2), "Meto el numero 2");
        assertEquals(1, bag.size(), "Deberia aumentar 1 el tamaño");
    }

    @Test
    @DisplayName("Meto varios numeros")
    public void testAddCopias() {
        bag.add(3, 3);
        assertEquals(3, bag.size(), "Meto el numero 3, 3 veces, y deberia aumentar el tamaño");
    }

    @Test
    @DisplayName("Compruebo el tamaño de la bolsa")
    public void testGetCount() {
        bag.add(5);
        bag.add(5);
        bag.add(3);
        assertEquals(2, bag.getCount(5), "Deberian salir 2 veces 5");
        assertEquals(1, bag.getCount(3), "Deberia salir 1 vez 3");
        assertEquals(0, bag.getCount(8), "No debe aparecer 8");
    }

    @Test
    @DisplayName("Pruebo eliminar")
    public void testRemove() {
        bag.add(2);
        assertTrue(bag.remove(2), "Deberia eliminar 2");
        assertEquals(0, bag.size(), "El tamaño deberia ser 0");
    }

    @Test
    @DisplayName("Pruebo eliminar varias copias")
    public void testRemoveCopias() {
        bag.add(2, 5);
        bag.remove(2, 3);
        assertEquals(2, bag.size(), "El tamaño debe ser 2");
    }

    @Test
    @DisplayName("Pruebo que se hace bien el Set")
    public void testUniqueSet() {
        bag.add(8);
        bag.add(8);
        bag.add(5);
        Set<Integer> uniqueSet = bag.uniqueSet();
        assertEquals(2, uniqueSet.size(), "El tamaño debe ser 2");
    }

    @Test
    @DisplayName("Pruebo la salida")
    public void testToString() {
        bag.add(1);
        bag.add(2);
        assertEquals("Bag: [1, 2]", bag.toString(), "Deberian ser lo mismo");
    }
}
