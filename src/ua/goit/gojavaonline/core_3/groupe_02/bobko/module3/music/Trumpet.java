package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.music;

public class Trumpet extends MusicalInstrument{
    @Override
    public void play() {
        System.out.println("Trumpet play");
    }

    @Override
    public String toString(){
        return "trumpet";
    }
}
