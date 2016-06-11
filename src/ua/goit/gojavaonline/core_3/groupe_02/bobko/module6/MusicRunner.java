package ua.goit.gojavaonline.core_3.groupe_02.bobko.module6;

import java.util.*;

public class MusicRunner {
    public static void main(String[] args) {

        MusicShop musicShop = new MusicShop();
        ArrayList<String> orderList;

        musicShop.addToStore(new Piano(), 2);
        musicShop.addToStore(new Guitar(), 17);
        musicShop.addToStore(new Trumpet(), 7);

        musicShop.printStore();

        HashMap<String, Integer> order1 = new HashMap<String, Integer>();
        order1.put("guitar", 7);
        order1.put("trumpet", 2);

        try {
            orderList = musicShop.prepareInstruments(order1);
            musicShop.sellInstruments(orderList);
        } catch (NonexistentMusicalInstrumentException e) {
            System.out.println(e.getMessage());
        } catch (OrderNumberMusicalInstrumentsLessThanOneException e) {
            System.out.println(e.getMessage());
        }finally {
            musicShop.printStore();
        }


        HashMap<String, Integer> order2 = new HashMap<String, Integer>();
        order2.put("piano", 1);
        try {
            orderList = musicShop.prepareInstruments(order2);
            musicShop.sellInstruments(orderList);
        } catch (NonexistentMusicalInstrumentException e) {
            System.out.println(e.getMessage());
        } catch (OrderNumberMusicalInstrumentsLessThanOneException e) {
            System.out.println(e.getMessage());
        }finally {
            musicShop.printStore();
        }



        HashMap<String, Integer> order3 = new HashMap<String, Integer>();
        order3.put("piano", 1);
        order3.put("guitar", 8);
        order3.put("trumpet", 6);
        try {
            orderList = musicShop.prepareInstruments(order3);
            musicShop.sellInstruments(orderList);
        } catch (NonexistentMusicalInstrumentException e) {
            System.out.println(e.getMessage());
        } catch (OrderNumberMusicalInstrumentsLessThanOneException e) {
            System.out.println(e.getMessage());
        } finally {
            musicShop.printStore();
        }



    }



}
