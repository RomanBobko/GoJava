package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.temperature;

/*ToDo by Dmitrij Lenchuk
* Typo ошибки режут глаз
* */
/*ToDo by Dmitrij Lenchuk
* Лишние пустые строки
* */
public interface Term {

    String getFarenheithValue();
    String getCelsiusValue();
    double getValue(); //Return value in C
    Term add( Term anTerm );
    Term add( String temperature );


}
