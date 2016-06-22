package ua.goit.gojavaonline.core_3.groupe_02.bobko.module8.maps;

import java.util.Collection;

public interface MyMap<K, V>{

    int size();
    boolean isEmpty();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    V get(Object key);
    V put(K key, V value);
    V remove(Object key);
    void clear();
    Collection<V> values();
    boolean equals(Object o);

    interface Entry<K, V>{
        K getKey();
        V getValue();
        V setValue(V value);
        int hashCode();
    }




}
