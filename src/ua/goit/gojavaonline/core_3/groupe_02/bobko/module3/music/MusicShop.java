package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.music;

import java.util.ArrayList;
import java.util.List;

/*ToDo by Dmitrij Lenchuk
* Typo ошибки режут глаз
* */
/*ToDo by Dmitrij Lenchuk
* Можно не менять, но что касается антипаттернов, -
* нельзя смешивать функционал и сервис.
* Это по поводу логирования внутри методов
* */
/*ToDo by Dmitrij Lenchuk
* Если реализовать методы equals() & hashCode() в классе MusicalInstrument,
* код в этом классе станет намного красивее
* */
public class MusicShop {

<<<<<<< HEAD
    private List<MusicalInstrument> instruments = new ArrayList<>();
=======
    /*ToDo by Dmitrij Lenchuk
    * Можно поменять на
    * private List<MusicalInstrument> instruments = new ArrayList<>();
    * */
    private List<MusicalInstrument> instruments = new ArrayList<MusicalInstrument>();
>>>>>>> fce7624ec010e9da03d1b15b2f1f1ebb42ccf2ab

    public void addToStore(MusicalInstrument instrument) {
        this.instruments.add(instrument);
    }

    public void sellInstrument(String instrument) {
        int index = findIndex(instrument);
        if (index >= 0) {
            System.out.println(instruments.get(index).toString() + " to sold!");
            instruments.remove(index);
            printStore();
        }
        else{
            System.out.println("Instruneent not available!");
        }
    }

    public void printStore(){
        System.out.println("module6 shop stor:");
        int i = 0;
        for (MusicalInstrument instrument: instruments) {
            System.out.println(++i+" "+instrument.toString());
        }
        System.out.println("/////////////");
    }

    public void demoPlay(){
        System.out.println("Instruments play:");
        for (MusicalInstrument instrument: instruments) {
            instrument.play();
        }
        System.out.println("////////////////");
    }

    private int findIndex(String instrument){
        for(int i=0; i<instruments.size(); i++){
            if (instruments.get(i).toString().equals(instrument)){
                return i;
            }
        }
        return -1;
    }

    public void setInstruments(List<MusicalInstrument> instruments) { //add new line
        this.instruments = instruments;
    }

    public List<MusicalInstrument> getInstruments() {
        return instruments;
    }

}
