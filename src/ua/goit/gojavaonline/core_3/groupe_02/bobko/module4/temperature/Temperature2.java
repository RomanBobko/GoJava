package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.temperature;

import java.util.EmptyStackException;

public class Temperature2 implements Term {

    private double value;

    Temperature2 (){
        this.value = 0;
    }

    private Temperature2 ( double value){
        this.value = value;
    }

    Temperature2 ( String temperature ){
        this.value = parse( temperature );
    }

    private double parse( String temperature ) {
        double temp;
        temp = Double.valueOf(temperature.substring(0, temperature.length() - 1));
        String sufix = temperature.substring(temperature.length() - 1);
        if (sufix.equals("C")){
             return temp;
        }
        else if (sufix.equals("F")) {
            return ( 5.0 / 9.0 ) * ( temp - 32.0 );
        }
        else {
            throw new EmptyStackException();
        }

    }

    @Override
    public Term add( Term anTerm ){
        if (anTerm instanceof Temperature2){
            return this.getValue( (Temperature2) anTerm);
        }
        return this;
    }

    @Override
    public Term add ( String temperature ){
        Temperature2 temperature2 = new Temperature2(temperature);
        return this.add(temperature2);
    }

    @Override
    public String getFarenheithValue() {
        double valueF = this.value;
        valueF = ( 9.0 / 5.0 ) * this.value + 32.0;
        return String.format( "%.2fF", valueF );
    }

    @Override
    public String getCelsiusValue() {
        return String.format( "%.2fC", value );
    }

    @Override
    public String toString(){
        return String.format("Temperature = %.2fC", this.value);
    }

    @Override
    public boolean equals(Object anObject){
        if ( this == anObject ){
            return true;
        }
        if (anObject instanceof Temperature2 && ((Temperature2) anObject).value == this.value){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(value);
        return (int) (temp ^ (temp >>> 32));
    }

    public void setValue(String temperature){
        this.value = parse(temperature);
    }

    public double getValue(){
        return this.value;
    }

    private Temperature2 getValue( Temperature2 temp){
        return new Temperature2( this.value + temp.value);
    }
}
