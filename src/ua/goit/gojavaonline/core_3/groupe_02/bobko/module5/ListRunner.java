package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

import java.util.ArrayList;
import java.util.Iterator;

public class ListRunner {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();

        list.add(100500);
        list.clear();

        list.add(4);
        list.add(7);
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(99);
        list.add(98);

        list.remove(5);
        list.remove(new Integer(98));

        list.set(4, 77);

        list.sort();

        for (Element e: list){
            System.out.println(e.getObject());
        }

    }
}
