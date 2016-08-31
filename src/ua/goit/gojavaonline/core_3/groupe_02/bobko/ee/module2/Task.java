package ua.goit.gojavaonline.core_3.groupe_02.bobko.ee.module2;

public interface Task<T> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();

    T getValue();

}
