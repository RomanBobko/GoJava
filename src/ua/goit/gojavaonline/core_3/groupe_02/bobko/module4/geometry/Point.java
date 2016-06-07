package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class Point {
    private double x;
    private double y;

    Point ( double x, double y ){
        this.x = x;
        this.y = y;
    }

    public double distanceToPoint(Point anPoint){
        return Math.sqrt( Math.pow( anPoint.getX() - this.getX() , 2 ) + Math.pow( anPoint.getY() - this.getY(), 2 ) );
    }

    @Override
    public String toString(){
        return String.format("x = %.2f; y = %.2f", x, y );
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }





}
