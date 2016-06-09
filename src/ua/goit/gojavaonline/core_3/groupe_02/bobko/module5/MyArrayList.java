package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

import java.util.Iterator;

public class MyArrayList<T extends Comparable> implements MyList, Iterator<T>, Iterable<T>{

    private Object[] array;
    private int size;
    private final int START_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private int iteratorIndex;

    MyArrayList(){
        int size = 0;
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
    public boolean add(Comparable o) {
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
    public boolean remove(Comparable o) {
        for (int i = 0; i < size; i++){
            if ( ((T) array[i]).compareTo(o) == 0 ){
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Comparable o) {
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
    public Comparable get(int index) {
        if (indexIsCorrect(index)){
            return (T)array[index];
        }
        return null;
    }

    @Override
    public Comparable set(int index, Comparable o) {
        if (indexIsCorrect(index)){
            T oldObject = (T)array[index];
            array[index] = o;
            return oldObject;
        }
        return null;
    }

    @Override
    public Comparable remove(int index) {
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
        String outString = "[";
        for (int i = 0; i<size; i++){
            outString += (T)array[i].toString() + ", ";
        }
        return outString.substring(0, outString.length()-2) + "]";
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
        if (array.length * 2 > MAX_ARRAY_SIZE){
            return MAX_ARRAY_SIZE;
        }
        else{
            return array.length * 2;
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
