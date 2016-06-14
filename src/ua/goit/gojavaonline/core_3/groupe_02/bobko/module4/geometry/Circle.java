package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class Circle implements Figure {

    private Point center;
    private double radius;

    Circle(Point center, double radius){
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String toString(){
        return String.format("Circle\n center x = %.2f; y = %.2f\n radius = %.2f\n area = %.2f",
                center.getX(), center.getY(), radius, this.getArea() );
    }

    public void setCenter(Point center){
        this.center = center;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public Point getCenter(){
        return center;
    }

    public double getRadius(){
        return radius;
    }







}
