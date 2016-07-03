package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

import org.junit.Test;
import ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry.Circle;
import ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry.Point;

import static org.junit.Assert.*;

public class TestCircle {

    @Test
    public void testArea(){
        Point center = new Point(2.0, 2.0);
        Circle circle = new Circle(center, 10);
        assertTrue(circle.getArea() == Math.PI*100);

    }

    @Test (expected = IllegalArgumentException.class)
    public void testNegativeArea(){
        Point center = new Point(2.0, 2.0);
        Circle circle = new Circle(center, -2.0);
        assertTrue(circle.getArea() == Math.PI*100);
    }


}
