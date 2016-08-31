package ua.goit.gojavaonline.core_3.groupe_02.bobko.ee.module2;

public class NumberValidator implements Validator<Number>{

    @Override
    public boolean isValid(Number result) {
        return result.longValue() >= 0;
    }
}
