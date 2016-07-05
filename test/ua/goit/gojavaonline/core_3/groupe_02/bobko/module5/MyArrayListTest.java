package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {
    @Test
    public void testSize(){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        assertTrue(list.size() == 2);
    }

    @Test
    public void testIsEmpty() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(2);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertTrue(list.add(5));
    }

    @Test
    public void testRemoveByObject(){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(16);
        list.add(32);
        list.add(64);
        assertTrue(list.remove((Integer) 32));
    }

    @Test
    public void testRemoveByIndex(){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(16);
        list.add(32);
        list.add(64);
        assertEquals(list.remove(1), (Integer) 32);
    }


    @Test
    public void testRemoveAll() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(32);
        list.add(16);
        list.add(32);
        list.add(64);
        list.add(32);
        list.removeAll((Integer) 32);

        assertFalse(list.remove((Integer) 32));
    }

    @Test
    public void testSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(64);
        list.add(16);
        list.add(32);
        list.sort();
        assertEquals(list.toString(), "[16, 32, 64]");
    }

    @Test
    public void testClear(){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(64);
        list.add(16);
        list.add(32);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testGet(){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(64);
        list.add(16);
        list.add(32);
        assertEquals(list.get(1), (Integer) 16);
    }

    @Test
    public void testSet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(64);
        list.add(16);
        list.add(32);
        list.set(1, 8);
        assertEquals(list.get(1), (Integer) 8);
    }

}