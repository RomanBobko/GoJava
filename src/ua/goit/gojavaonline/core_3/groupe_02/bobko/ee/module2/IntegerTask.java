package ua.goit.gojavaonline.core_3.groupe_02.bobko.ee.module2;

public class IntegerTask implements Task<Integer> {

    private Integer value;
    private boolean isExecuted;
    private Integer result;

    IntegerTask(int value) {
        this.value = value;
        isExecuted = false;
    }

    @Override
    public void execute() {
        if (Math.random() > 0.4) {
            result = value * 1;
        } else {
            result = value * -1;
        }
        isExecuted = true;
    }

    @Override
    public Integer getResult() {
        if (isExecuted) {
            return result;
        }
        throw new IllegalStateException("Task is not executed");
    }

    @Override
    public Integer getValue() {
        return value;
    }


}
