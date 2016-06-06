package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class DistanceBetweenTwoPoints {
    public static double distance(double x1, double y1, double x2, double y2){
        double distance = Math.sqrt( Math.pow( x2 - x1 , 2 ) + Math.pow( y2 - y1, 2 ) );
        return distance;
    }
}
