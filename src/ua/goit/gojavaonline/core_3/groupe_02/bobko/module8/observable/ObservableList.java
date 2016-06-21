package ua.goit.gojavaonline.core_3.groupe_02.bobko.module8.observable;

public interface ObservableList {

    boolean addObserver(ListObserver o);
    boolean deleteObserver(ListObserver o);
    void notifyObservers();

}
