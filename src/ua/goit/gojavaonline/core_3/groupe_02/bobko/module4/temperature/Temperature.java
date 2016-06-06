package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.temperature;

import java.util.EmptyStackException;

public class Temperature {

    Temperature() {
        value = 0.0;
        units = Degree.C;
    }

    Temperature(double temp, Degree degree) {
        this.value = temp;
        this.units = degree;
    }

    Temperature(String temperature) {
        parse(temperature);
    }

    public String getFarenheithValue() {
        if (units == Degree.C) {
            double res = ( 9.0 / 5.0 ) * value + 32.0;
            return String.format( "%.2f", res ) + "F";
        }
        return String.format( "%.2f", value ) + units.name();
    }

    public String getCelsiusValue() {
        if (units == Degree.F) {
            double res = ( 5.0 / 9.0 ) * ( value - 32.0 );
            return String.format( "%.2f", res ) + "C";
        }
        return String.format( "%.2f", value ) + units.name();
    }

    @Override
    public String toString(){
        return String.format( "%.2f", value ) + units.name();
    }

    public boolean equals(Temperature anTemperature){
        if ( this == anTemperature ){
            return true;
        }
        if ( this.units == anTemperature.units ){
            if ( this.value == anTemperature.value){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if (this.getCelsiusValue().equals(anTemperature.getCelsiusValue())){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public Temperature add(Temperature anTemperature){
        Temperature result = new Temperature();
        if ( this.getUnits() == anTemperature.getUnits() ){
            if (this.units == Degree.C){
                result.units = Degree.C;
            }
            else{
                result.units = Degree.F;
            }
            result.value = this.getValue() + anTemperature.getValue();
        }
        else{
            result.units = Degree.C;
            result.value = this.getValueC() + anTemperature.getValueC();

        }
        return result;
    }

    private void parse(String temperature) {
        double temp;
        Degree degree = null;
        String sufix = temperature.substring(temperature.length() - 1);
        if (sufix.equals("C") || sufix.equals("F")) {
            degree = Degree.valueOf(sufix);
        } else {
            throw new EmptyStackException();
        }
        temp = Double.valueOf(temperature.substring(0, temperature.length() - 1));

        this.value = temp;
        this.units = degree;
    }

    public double getValue(){
        return value;
    }

    public double getValueC(){
        if (units == Degree.F) {
            return ( 5.0 / 9.0 ) * ( value - 32.0 );
        }
        return value;
    }

    public Degree getUnits(){
        return units;
    }

    private double value;
    private Degree units;

    enum Degree {C, F}




}
