package org.iesbelen.genericos.test;

import org.iesbelen.genericos.Bag;
import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBag {

    Bag bag = new Bag();

    @Test
    void testAdd(){
        bag.add(1);
        assertEquals(1, bag.size());
    }

    @Test
    void testAddN(){
        bag.add(1, 4);
        assertEquals(4, bag.size());
    }

    @Test
    void testGetCount(){
        bag.add(1, 4);
        assertEquals(4, bag.getCount(1));
    }

    @Test
    void testRemove(){
        bag.add(1);
        bag.remove(1);
        assertEquals(0,bag.size());
    }


    @Test
    void testSize(){
        bag.add(1);
        assertEquals(1, bag.size());
    }


}
