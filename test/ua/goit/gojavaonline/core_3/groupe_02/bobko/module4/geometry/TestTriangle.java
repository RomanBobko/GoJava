package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTriangle {

    @Test
    public void testArea(){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 2);
        Point p3 = new Point(0, 4);
        Triangle triangle = new Triangle(p1, p2, p3);
        assertEquals(10, triangle.getArea(), 1e-9);
    }

    @Test (expected = ExceptionInInitializerError.class)
    public void testTriangle(){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        Point p3 = new Point(0, 4);
        Triangle triangle = new Triangle(p1, p2, p3);
    }

}
