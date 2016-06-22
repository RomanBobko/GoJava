package ua.goit.gojavaonline.core_3.groupe_02.bobko.module8.maps;

import ua.goit.gojavaonline.core_3.groupe_02.bobko.module8.observable.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class MapsRunner {

    public static void main(String[] args) {
        MyHashMap<Double, String> map = new MyHashMap<>();
        Double d = 12.0;
        map.put(d, "12.00");
        map.put(d, "12");
        map.put(23.9, "23.9");
        map.put(null, "NULL");
        System.out.println(map);
        map.remove(null);
        System.out.println(map);
        System.out.println(map.containsKey(12.0));
    }



}
