package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.Music;

import java.util.List;

public class MusicShop {
    private List<MusicalInstrument> instruments;

    public void setInstruments(List<MusicalInstrument> instruments){
        this.instruments = instruments;
    }

    public List<MusicalInstrument> getInstruments(){
        return instruments;
    }
}
