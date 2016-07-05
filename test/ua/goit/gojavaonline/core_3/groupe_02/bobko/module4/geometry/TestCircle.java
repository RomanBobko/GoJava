package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCircle {

    Point center;

    @Before
    public void testInit(){
        center = new Point(2.0, 2.0);

    }

    @Test
    public void testArea(){
        Circle circle = new Circle(center, 10);
        assertTrue(circle.getArea() == Math.PI*100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNegativeArea(){
        Circle circle = new Circle(center, -2.0);
        assertTrue(circle.getArea() == Math.PI*100);
    }


}
