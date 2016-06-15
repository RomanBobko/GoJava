package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.temperature;

import java.util.EmptyStackException;

/*ToDo by Dmitrij Lenchuk
* Typo ошибки режут глаз
* */
public class Temperature implements Term {

    private double value;
    private Degree units;
    /*ToDo by Dmitrij Lenchuk
    * C, F - не информативно. Все равно Magic Numbers
    * */
    enum Degree {C, F}

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

    @Override
    public Term add(Term anTerm){
        return new Temperature(this.getValue() + anTerm.getValue(), Degree.C);
    }

    @Override
    public Term add(String temperature) {
        Temperature temp = new Temperature(temperature);
        return this.add(temp);
    }

    /*ToDo by Dmitrij Lenchuk
    * Маленьких обманывать не хорошо.
    * Нужно кидать правильный Exception
    * */
    /*ToDo by Dmitrij Lenchuk
    * Разберись с degree. Такой код потенциально опасен.
    * Нельзя привязываться к конкретным значениям.
    * */
    /*ToDo by Dmitrij Lenchuk
    * Magic Numbers в коде!!!
    * */
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

    @Override
    public String toString(){
        return String.format( "Temperature = %.2f", value ) + units.name();
    }

    /*ToDo by Dmitrij Lenchuk
    * Нужно упростить операторы.
    * Например:
    *        if ( this.value == ((Temperature) anObjetc).value){
    *            return true;
    *        }
    *        else{
    *            return false;
    *        }
    * Можно записать как:
    * return this.value == ((Temperature) anObjetc).value
    *
    * ПыСы... Это, кстати, антипаттерн "Индийский код"
    * */
    @Override
    public boolean equals(Object anObjetc){
        if ( this == anObjetc ){
            return true;
        }
        if (anObjetc instanceof Temperature && this.units == ((Temperature) anObjetc).units ){
            if ( this.value == ((Temperature) anObjetc).value){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if (this.getCelsiusValue().equals(((Temperature) anObjetc).getCelsiusValue())){
                return true;
            }
            else{
                return false;
            }
        }
    }

    @Override
    public double getValue(){
        if (units == Degree.F) {
            return ( 5.0 / 9.0 ) * ( value - 32.0 );
        }
        return value;
    }

    public Degree getUnits(){
        return units;
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

}
