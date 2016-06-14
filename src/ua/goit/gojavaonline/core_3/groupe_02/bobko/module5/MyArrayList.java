package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

import org.omg.CORBA.ExceptionList;

import java.util.Iterator;

public class MyArrayList<T extends Comparable> implements MyList<T>, Iterator<T>, Iterable<T>{

    private Object[] array;
    private int size;
    private final int START_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = 1000000;
    private int iteratorIndex;

    MyArrayList(){
        array = new Object[START_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T o) {
        if (size == MAX_ARRAY_SIZE){
            return false;
        }
        if (isFull()){
            this.resize();
        }
        array[size++] = o;
        return true;
    }

    @Override
    public boolean remove(T o) {
        for (int i = 0; i < size; i++){
            if ( ((T) array[i]).compareTo(o) == 0 ){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(T o) {
        boolean isRemoved = false;
        for (int i = 0; i < size; i++){
            if ( ((T) array[i]).compareTo(o) == 0 ){
                remove(i--);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public void sort() {
        for (int i = 0; i < this.size()-1; i++){
            boolean isSort = false;
            for (int j = 0; j < this.size() - i - 1; j++){
                if (((T)array[j]).compareTo((T)array[j + 1]) > 0){
                    T temp = (T)array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    temp = null;
                    isSort = true;
                }
            }
            if (!isSort){
                break;
            }
        }
    }

    public MyArrayList<T> sortImmutable(){
        MyArrayList<T> sortedList = new MyArrayList<T>();
        for (T o : this){
            sortedList.add(o);
        }
        sortedList.sort();
        return sortedList;
    }

    @Override
    public T get(int index) {
        if (indexIsCorrect(index)){
            return (T)array[index];
        }
        return null;
    }

    @Override
    public T set(int index, T o) {
        if (indexIsCorrect(index)){
            T oldObject = (T)array[index];
            array[index] = o;
            return oldObject;
        }
        return null;
    }

    @Override
    public T remove(int index) {
        if (indexIsCorrect(index)){
            T removeObject = (T)array[index];
            for(int i = index; i<size - 1; i++){
                array[i] = array[i + 1];
            }
            size --;
            return removeObject;
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuffer outString = new StringBuffer();
        outString.append("[");
        for (int i = 0; i < size; i++){
            outString.append(((T)array[i]).toString());
            if (i == size - 1){
                continue;
            }
            outString.append(", ");
        }
        outString.append("]");
        return outString.toString();
    }

    @Override
    public Iterator iterator() {
        iteratorIndex = 0;
        return this;
    }

    @Override
    public boolean hasNext() {
        if (iteratorIndex < size){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public T next() {
        return (T)array[iteratorIndex++];
    }

    private boolean isFull(){
        if (size - array.length == 0){
            return true;
        }
        else{
            return false;
        }
    }

    private int nextSize(){
        if (array.length == MAX_ARRAY_SIZE){
            throw new ArrayIndexOutOfBoundsException();
        }
        if (MAX_ARRAY_SIZE / array.length >= 2){
            return array.length * 2;
        } else{
            return MAX_ARRAY_SIZE;
        }
    }

    private void resize(){

        Object[] newArray = new Object[this.nextSize()];

        for (int i = 0; i<array.length; i++){
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private boolean indexIsCorrect(int index){
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }
        else{
            return true;
        }
    }
}
