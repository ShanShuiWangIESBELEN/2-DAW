package org.iesbelen.genericos.test;

import org.iesbelen.genericos.Bag;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BagTest {
    private Bag<String> bag;

    @BeforeEach
    void setUp() {
        bag = new Bag<>();
    }

    @Test
    @DisplayName("Test 1 añadir un elemento")
    void testAdd() {
        bag.add("Patata");
    }

    @Test
    @DisplayName("Test 2. Anadir n elementos")
    void testAdd2() {
        bag.add("Patata", 2);
        bag.add("zanahoria", 5);
    }

    @Test
    @DisplayName("Test 3. getCount ")
    void testGetCount() {
        bag.add("Patata", 2);
        assertEquals(2, bag.getCount("Patata"));
    }

    @Test
    @DisplayName("Test 4 . remove:")
    void testRemove() {
        bag.add("Patata");
        bag.remove("Patata");
    }

    @Test
    @DisplayName("Test 4.1. remove:")
    void testRemove2() {
        bag.add("Patata", 5);
        bag.remove("Patata", 2);
    }

    @Test
    @DisplayName("Test 5. tamaño")
    void testSize() {
        bag.add("Patata");
        bag.add("zanahoria", 2);
        assertEquals(3, bag.size());
    }
}
//
//    @Test
//    void testUniqueSet() {
//        bag.add("Apple");
//        bag.add("Banana");
//        Set<String> uniqueElements = bag.uniqueSet();
//        assertEquals(2, uniqueElements.size(), "Debería haber 2 elementos únicos.");
//        assertTrue(uniqueElements.contains("Apple"), "El conjunto único debe contener 'Apple'.");
//        assertTrue(uniqueElements.contains("Banana"), "El conjunto único debe contener 'Banana'.");
//    }