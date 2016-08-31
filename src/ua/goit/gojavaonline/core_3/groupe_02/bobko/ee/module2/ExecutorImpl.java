package ua.goit.gojavaonline.core_3.groupe_02.bobko.ee.module2;

import java.util.ArrayList;
import java.util.List;


public class ExecutorImpl<T> implements Executor<T> {

    private List<Task<? extends T>> list;
    private boolean isExecuted;

    private List<T> validTasks = new ArrayList<>();
    private List<T> invalidTasks = new ArrayList<>();

    ExecutorImpl() {
        list = new ArrayList<>();
        isExecuted = false;
    }


    @Override
    public void addTask(Task<? extends T> task) {
        if (isExecuted) {
            throw new IllegalStateException("Tasks executed");
        }
        list.add(task);
    }

    @Override
    public void addTask(Task<? extends T> task, Validator<T> validator) {
        if (isExecuted) {
            throw new IllegalStateException("Tasks executed");
        }
        task.execute();
        if (validator.isValid(task.getResult())) {
            validTasks.add(task.getResult());
        } else {
            invalidTasks.add(task.getResult());
        }
    }

    @Override
    public void execute() {
        Validator<Number> validator = new NumberValidator();
        for (Task<? extends T> task : list) {
            task.execute();
            if (validator.isValid((Number) task.getResult())) {
                validTasks.add(task.getResult());
            } else {
                invalidTasks.add(task.getResult());
            }
        }
        isExecuted = true;
    }

    @Override
    public List<? extends T> getValidResults() {
        if (!isExecuted) {
            throw new IllegalStateException("Not execute");
        }
        return validTasks;
    }

    @Override
    public List<? extends T> getInvalidResults() {
        if (!isExecuted) {
            throw new IllegalStateException("Not execute");
        }
        return invalidTasks;
    }
}
