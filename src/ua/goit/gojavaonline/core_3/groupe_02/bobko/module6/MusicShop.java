package ua.goit.gojavaonline.core_3.groupe_02.bobko.module6;

import java.util.*;

/*ToDo by Dmitrij Lenchuk
* См. ошибки в модуле 3
* */
/*ToDo by Dmitrij Lenchuk
* И опять же Typo!!!
* */
public class MusicShop {

    private ArrayList<MusicalInstrument> instruments = new ArrayList<>();
    private HashSet<String> assortment = new HashSet<>();

    public boolean addToStore(MusicalInstrument instrument) {
        this.instruments.add(instrument);
        assortment.add(instrument.toString());
        return true;
    }

    public void sellInstruments(List<String> orderList) {
        if (orderList == null){
            return;
        }
        for (String musicalInstrument : orderList){
            sellInstrument(musicalInstrument);
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

    /*ToDo by Dmitrij Lenchuk
    * Может тут лучше выкидывать MusicShopException?
    * */
    public ArrayList<String> prepareInstruments(HashMap<String, Integer> order)
            throws NonexistentMusicalInstrumentException, OrderNumberMusicalInstrumentsLessThanOneException {
        ArrayList<String> orderList = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : order.entrySet()){

            if (!assortment.contains(entry.getKey())){
                throw new NonexistentMusicalInstrumentException("Instrument " + entry.getKey() + " noneexist!");
            }

            if (entry.getValue() <= 0){
                throw new OrderNumberMusicalInstrumentsLessThanOneException("Number " + entry.getValue() +
                        "is not allowed in order!");
            }
            if (entry.getValue() > numberOfStor(entry.getKey())){
                throw new IndexOutOfBoundsException("In stock only " + numberOfStor(entry.getKey()) +
                        " " + entry.getKey());
            }
            for (int i = 0; i < entry.getValue(); i++){
                orderList.add(entry.getKey());
            }
        }
        return orderList;
    }

    public ArrayList<MusicalInstrument> getInstruments() {
        return this.instruments;
    }

    public void setInstruments(ArrayList<MusicalInstrument> instruments) {
        this.instruments = instruments;
    }

    private int numberOfStor(String instrument){
        int count = 0;
        for (MusicalInstrument musicalInstrument : this.instruments){
            if (musicalInstrument.toString().equals(instrument)){
                count++;
            }
        }
        return count;
    }

    private int findIndex(String instrument){
        for(int i=0; i<instruments.size(); i++){
            if (instruments.get(i).toString().equals(instrument)){
                return i;
            }
        }
        return -1;
    }

    private void sellInstrument(String instrument) {
        int index = findIndex(instrument);
        if (index >= 0) {
            System.out.println(instruments.get(index).toString() + " to sold!");
            instruments.remove(index);
        }
        else{
            System.out.println("Instruneent not available!");
        }
    }

}
