package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class Triangle {
    Triangle(Point p1, Point p2, Point p3){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public void setP1(Point p){
        p1 = p;
    }

    public void setP2(Point p){
        p2 = p;
    }

    public void setP3(Point p){
        p3 = p;
    }

    public Point getP1(){
        return p1;
    }

    public Point getP2(){
        return p2;
    }

    public Point getP3(){
        return p3;
    }

    @Override
    public String toString(){
        return String.format( "Triangle \n" +
                "ponit1( x = %.2f; y = %.2f );\n" +
                "ponit2( x = %.2f; y = %.2f );\n" +
                "ponit3( x = %.2f; y = %.2f );", p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY() );
    }

    private Point p1;
    private Point p2;
    private Point p3;
}
