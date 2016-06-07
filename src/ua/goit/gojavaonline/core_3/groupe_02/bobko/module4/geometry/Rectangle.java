package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class Rectangle implements Figure {
    private Point leftBottom;
    private double height;
    private double width;

    Rectangle(Point leftBottom, double height, double widht ){
        this.leftBottom = leftBottom;
        this.height = height;
        this.width = widht;
    }

    @Override
    public double getArea() {
        return this.getHeigth() * this.getWidth();
    }

    @Override
    public String toString(){
        return String.format( "Rectangle \n" +
                "Left bottom point( x = %.2f; y = %.2f );\n" +
                "height = %.2f;\n" +
                "width = %.2f;\n" +
                "area = %.2f;", leftBottom.getX(), leftBottom.getY(), height, width, this.getArea());
    }

    public void setLeftBottom(Point leftBottom){
        leftBottom = leftBottom;
    }

    public void setHeigth(double heigth){
        this.height = heigth;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public Point getLeftBottom(){
        return leftBottom;
    }

    public double getHeigth(){
        return height;
    }

    public double getWidth(){
        return width;
    }

}
