package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

import java.util.ArrayList;

public class GeometryRunner {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle( new Point( 2, 3 ) , 15, 10 );
        Triangle t1 = new Triangle( new Point( 1, 1 ), new Point( 2, 4 ), new Point( 4, 2 ) );
        Circle c1 = new Circle( new Point( 3, 3 ), 12 );

        ArrayList<Figure> figureList = new ArrayList<>();
        figureList.add(r1);
        figureList.add(t1);
        figureList.add(c1);

        for (Figure f : figureList){
            System.out.println(f);
            System.out.println(f.getArea());
        }

    }
}
