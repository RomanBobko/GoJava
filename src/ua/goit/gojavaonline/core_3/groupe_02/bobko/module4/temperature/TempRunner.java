package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.temperature;

import java.util.ArrayList;
import java.util.List;

public class TempRunner {
    public static void main(String[] args) {

        Temperature2 t1 = new Temperature2("36.6C");
        System.out.println(t1.getFarenheithValue());
        System.out.println(t1.getCelsiusValue());

        Temperature2 t2 = new Temperature2("97.88F");
        System.out.println(t2.getFarenheithValue());
        System.out.println(t2.getCelsiusValue());

        Temperature2 t3 = ( Temperature2 ) t1.add(t2);
        System.out.println(t3);
        System.out.println(t3.getFarenheithValue());

        Temperature2 t4 = ( Temperature2 ) t2.add("10C");
        System.out.println(t4);

        Temperature t5 = new Temperature("10C");

        ArrayList<Term> list = new ArrayList<>();
        list.add( t1 );
        list.add( t2 );
        list.add( t3 );
        list.add( t4 );
        list.add( t5 );

        for (Term t:list){
            System.out.println(t);
            System.out.println(t.getFarenheithValue());
        }


    }
}
