package ua.goit.gojavaonline.core_3.groupe_02.bobko.ee.module2;

public class LongTask implements Task<Long> {

    private Long value;
    private boolean isExecuted;
    private Long result;

    LongTask(Long task) {
        this.value = task;
        isExecuted = false;
    }

    @Override
    public void execute() {
        if (Math.random() > 0.4) {
            result = value * 1L;
        } else {
            result = value * -1L;
        }
        isExecuted = true;
    }

    @Override
    public Long getResult() {
        if (isExecuted) {
            return result;
        }
        throw new IllegalStateException("Task is not executed");
    }

    @Override
    public Long getValue() {
        return value;
    }
}
