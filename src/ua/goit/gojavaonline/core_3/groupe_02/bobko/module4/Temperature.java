package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4;

public class Temperature {
    public static double celsiusToFahrenheit(double temperatureC){
        double tF = ( 9.0 / 5.0 )* temperatureC + 32.0;
        return  tF;
    }

    public static double fahrenheitToCelsius(double temperatureF){
        return ( ( 5.0 / 9.0 ) * (temperatureF - 32.0) );
    }
}
