package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void getArea() throws Exception {
        Point p0 = new Point(0, 0);
        double width = 4.5;
        double heigh = 6.5;
        Rectangle rectangle = new Rectangle(p0, heigh, width);
        assertTrue(rectangle.getArea() == heigh * width);
    }

}