package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

public interface MyList<T> {

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
