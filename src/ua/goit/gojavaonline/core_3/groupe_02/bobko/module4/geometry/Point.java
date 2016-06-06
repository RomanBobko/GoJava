package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class Point {

    Point ( double x, double y ){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public String toString(){
        return String.format("x = %.2f; y = %.2f", x, y );
    }

    private double x;
    private double y;

}
