package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class Area {
    public static double triangle(double sideA, double sideB, double sideC){
        double p = (sideA + sideB + sideC)/2;
        double area = Math.sqrt( p * ( p - sideA ) * ( p - sideB) * ( p - sideC));
        return area;
    }

    public static double rectangle(double height, double widht){
        double area = height*widht;
        return area;
    }

    public static double circle(double radius){
        double area = Math.PI * Math.pow(radius,2);
        return area;
    }

}
