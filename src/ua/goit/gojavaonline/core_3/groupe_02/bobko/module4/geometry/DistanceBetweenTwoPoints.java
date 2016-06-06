package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class DistanceBetweenTwoPoints {

    DistanceBetweenTwoPoints( Point p1, Point p2){
        value = Math.sqrt( Math.pow( p2.getX() - p1.getX() , 2 ) + Math.pow( p2.getY() - p1.getY(), 2 ) );
    }

    public double getValue(){
        return value;
    }

    private final double value;

    @Override
    public String toString(){
        return String.format("Distance between two points = %.2f", value);
    }
}
