package ua.goit.gojavaonline.core_3.groupe_02.bobko.module6;

public class Guitar extends MusicalInstrument {

    @Override
    public void play() {
        System.out.println("Guitar play");
    }

    @Override
    public String toString(){
        return "guitar";
    }
}
