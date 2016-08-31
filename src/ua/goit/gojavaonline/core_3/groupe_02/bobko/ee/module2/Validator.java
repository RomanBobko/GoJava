package ua.goit.gojavaonline.core_3.groupe_02.bobko.ee.module2;

public interface Validator<T>{

    // Валидирует переданое значение
    boolean isValid(T result);

}
