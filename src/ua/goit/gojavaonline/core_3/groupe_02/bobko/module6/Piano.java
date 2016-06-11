package ua.goit.gojavaonline.core_3.groupe_02.bobko.module6;

public class Piano extends MusicalInstrument {
    @Override
    public void play() {
        System.out.println("Piano play");
    }

    @Override
    public String toString(){
        return "piano";
    }
}
