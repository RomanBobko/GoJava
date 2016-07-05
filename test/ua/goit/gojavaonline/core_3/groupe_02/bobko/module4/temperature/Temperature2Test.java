package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.temperature;

import org.junit.Test;

import static org.junit.Assert.*;

public class Temperature2Test {

    @Test
    public void testAdd() throws Exception {
        Temperature2 t1 = new Temperature2("10C");
        Temperature2 t2 = new Temperature2("5C");
        assertTrue(t1.add(t2).getValue() == 15);
    }

    @Test
    public void testAddString() throws Exception {
        Temperature2 t1 = new Temperature2("10C");
        assertTrue(t1.add("5C").getValue() == 15);
    }

    @Test
    public void testGetFarenheithValue(){
        Temperature2 t1 = new Temperature2("0C");
        assertEquals(t1.getFarenheithValue(), "32,00F");
    }

    @Test
    public void getCelsiusValue() throws Exception {
        Temperature2 t1 = new Temperature2("97.88F");
        assertEquals(t1.getCelsiusValue(), "36,60C");
    }

    @Test
    public void testGetValue() {
        Temperature2 t1 = new Temperature2("32C");
        assertTrue(t1.getValue() == 32.0);
    }

}