package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.regex.Matcher;

public class ListRunner {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<Integer>();

        for (int i = 0; i<25; i++){
            Double d1 = Math.random() * 100;
            list.add(d1.intValue());
        }
        list.set(4, -77);
        MyArrayList<Integer> list2 = list.sortImmutable();

        System.out.println(list);
        System.out.println(list2);



    }
}
