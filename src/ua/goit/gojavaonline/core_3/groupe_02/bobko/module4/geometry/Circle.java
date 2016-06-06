package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class Circle {
    Circle(Point center, double radius){
        this.center = center;
        this.radius = radius;
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

    @Override
    public String toString(){
        return String.format("Circle\n center x = %.2f; y = %.2f\n radius = %.2f", center.getX(), center.getY(), getRadius());
    }

    private Point center;
    private double radius;


}
