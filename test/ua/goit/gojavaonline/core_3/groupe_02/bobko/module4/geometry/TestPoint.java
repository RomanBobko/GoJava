package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestPoint {

    @Test
    public void testDistanceToPoint(){
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 2);
        assertEquals(2, p1.distanceToPoint(p2), 1e-9);
    }
}
