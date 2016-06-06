package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.geometry;

public class Area {
    Area (Rectangle rectangle){
        value = rectangle.getHeigth() * rectangle.getWidth();
        figure = "Rectangle";
    }

    Area (Triangle triangle){
        DistanceBetweenTwoPoints sideA = new DistanceBetweenTwoPoints( triangle.getP1(), triangle.getP2() );
        DistanceBetweenTwoPoints sideB = new DistanceBetweenTwoPoints( triangle.getP2(), triangle.getP3() );
        DistanceBetweenTwoPoints sideC = new DistanceBetweenTwoPoints( triangle.getP3(), triangle.getP1() );
        double p = ( sideA.getValue() + sideB.getValue() + sideC.getValue() ) / 2;
        value = Math.sqrt( p * ( p - sideA.getValue() ) * ( p - sideB.getValue()) * ( p - sideC.getValue()));
        figure = "Triangle";
    }

    Area (Circle circle){
        value = Math.PI * Math.pow(circle.getRadius(),2);
        figure = "Circle";
    }

    @Override
    public String toString(){
        return String.format("Area of "+figure+" %.2f", value);
    }

    public boolean equals(Area anArea){
        if ( this == anArea ){
            return true;
        }
        if ( this.figure == anArea.figure && this.value == anArea.value){
            return true;
        }
        return false;
    }

    private final double value;
    private final String figure;

}
