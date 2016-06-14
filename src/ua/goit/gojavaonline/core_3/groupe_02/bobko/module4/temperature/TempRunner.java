package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.temperature;

import java.util.ArrayList;
import java.util.List;

public class TempRunner {
    public static void main(String[] args) {

        Temperature t1 = new Temperature("36.6C");
        Temperature t2 = new Temperature("32F");

        Temperature2 t3 = new Temperature2("10C");
        Temperature2 t4 = new Temperature2("10F");

        Temperature t5 = (Temperature) t1.add(t3);
        Temperature2 t6 = (Temperature2) t4.add(t2);

        ArrayList<Term> list = new ArrayList<>();
        list.add( t1 );
        list.add( t2 );
        list.add( t3 );
        list.add( t4 );
        list.add( t5 );
        list.add( t6 );

        for (Term t:list){
            System.out.println(t);
            System.out.println(t.getCelsiusValue());
            System.out.println(t.getFarenheithValue());


        }


    }
}
