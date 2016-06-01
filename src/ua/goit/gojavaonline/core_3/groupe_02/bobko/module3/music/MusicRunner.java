package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.Music;

import java.util.Scanner;

public class MusicRunner {
    public static void main(String[] args) {
        MusicShop shop = new MusicShop();
        shop.addToStore(new Guitar());
        shop.addToStore(new Piano());
        shop.addToStore(new Trumpet());

        Scanner user_input = new Scanner(System.in);
        String command = "";
        System.out.println("Commands: " +
                "\n add - add Music instrument to Music shop " +
                "\n sell - sell musical instrument" +
                "\n demo - all Music instruments play sound" +
                "\n exit");
        while(!command.equals("exit")){
            command = user_input.next();

            if (command.equals("add")){
                System.out.println("what to add? guitar piano trumpet");
                String insrument = user_input.next();
                if(insrument.equals("guitar")){
                    shop.addToStore(new Guitar());
                }else if(insrument.equals("piano")){
                    shop.addToStore(new Piano());
                }else if(insrument.equals("trumpet")){
                    shop.addToStore(new Trumpet());
                }else{
                    System.out.println("Instruneent does not exist!");
                }
                shop.printStore();
            }else if(command.equals("sell")){
                System.out.println("Enter instrumenr for sale: guitar piano trumpet");
                String instrument = user_input.next();
                shop.sellInstrument(instrument);

            }else if(command.equals("demo")) {
                shop.demoPlay();
            }else if(command.equals("exit")){
                System.out.println("Close program");
            }
            else{
                System.out.println("Command not found!");
            }


        }

    }



}
