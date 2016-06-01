package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.music;

import java.util.ArrayList;
import java.util.List;

public class MusicShop {
    private List<MusicalInstrument> instruments = new ArrayList<MusicalInstrument>();

    public void setInstruments(List<MusicalInstrument> instruments) {
        this.instruments = instruments;
    }

    public List<MusicalInstrument> getInstruments() {
        return instruments;
    }

    public void addToStore(MusicalInstrument instrument) {
        this.instruments.add(instrument);
    }

    public void sellInstrument(String instrument) {
        int index = findIndex(instrument);
        if (index >= 0) {
            System.out.println(instruments.get(index).toString() + " to sold!");
            instruments.remove(index);
            printStore();
        } else{
            System.out.println("Instruneent not available!");
        }

    }

    private int findIndex(String instrument){
        for(int i=0; i<instruments.size(); i++){
            if (instruments.get(i).toString().equals(instrument)){
                return i;
            }
        }
        return -1;
    }

    public void printStore(){
        System.out.println("Music shop stor:");
        int i = 0;
        for (MusicalInstrument instrument: instruments
             ) {
            System.out.println(++i+" "+instrument.toString());

        }
        System.out.println("/////////////");
    }

    public void demoPlay(){
        System.out.println("Instruments play:");
        for (MusicalInstrument instrument: instruments
             ) {
            instrument.play();
        }
        System.out.println("////////////////");
    }
}
