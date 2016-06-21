package ua.goit.gojavaonline.core_3.groupe_02.bobko.module8.observable;


public class CurrentColectionsCondition implements ListObserver {

    @Override
    public void update(ObservableList o) {
        System.out.println(o);
    }

}
