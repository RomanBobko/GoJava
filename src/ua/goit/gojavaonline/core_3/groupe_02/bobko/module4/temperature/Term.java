package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.temperature;

public interface Term {

    public String getFarenheithValue();
    public String getCelsiusValue();
    public double getValue(); //Return value in C
    public Term add( Term anTerm );
    public Term add( String temperature );


}
