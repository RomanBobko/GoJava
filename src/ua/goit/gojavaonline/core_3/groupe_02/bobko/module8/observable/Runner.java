package ua.goit.gojavaonline.core_3.groupe_02.bobko.module8.observable;


public class Runner {

    public static void main(String[] args) {

        ObservableArrayList<Integer> list = new ObservableArrayList<>();
        CurrentColectionsCondition ccc = new CurrentColectionsCondition();
        list.addObserver(ccc);
        list.add(2);
        list.add(10);
        list.add(100);
        list.set(1,200);
        list.sort();
        list.remove(0);
        list.deleteObserver(ccc);
        list.add(333);

    }

}
