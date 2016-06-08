package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

import java.util.List;

public interface MyList<T extends Comparable> {

    int size();
    boolean isEmpty();
    boolean add(T o);
    boolean remove(T o);
    void clear();
    void sort();
    T get(int index);
    T set(int index, T o);
    T remove(int index);

}
