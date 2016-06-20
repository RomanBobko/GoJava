package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

/*ToDo by Dmitrij Lenchuk
* Пишу здесь по всему пакету
* Могу ошибаться, но это антипаттерн копипаст.
* Полезность тренировки понимаю. Но с точки зрения дз нет.
* Зачем реализовывать то что уже реализовано? Лучше уж делегировать.
* */
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
