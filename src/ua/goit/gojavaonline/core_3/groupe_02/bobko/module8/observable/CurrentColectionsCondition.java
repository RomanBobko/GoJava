package ua.goit.gojavaonline.core_3.groupe_02.bobko.module8.observable;

import java.util.Observable;
import java.util.Observer;


public class CurrentColectionsCondition implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o);
    }

}
