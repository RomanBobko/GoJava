package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

import java.util.Iterator;

public class MyLinkedList<T extends Comparable> implements MyList<T>, Iterable<Element>, Iterator<Element>{

    private int size = 0;
    private Element firstElement;
    private Element currentElement;
    private Element lastElement;

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
        Element e = new Element(o);
        if (this.isEmpty()){
            firstElement = e;
        }
        else{
            if (lastElement.getNext() == null){
                lastElement.setNext(e);
            }
        }
        lastElement = e;
        size++;
        return true;
    }

    @Override
    public boolean remove(T o) {
        Element removeElement = this.getElement((T) o);
        if (removeElement != null){
            if (removeElement == firstElement){
                firstElement = removeElement.getNext();
            }
            else if (removeElement == lastElement){
                lastElement = this.getElement(this.getIndex(removeElement)-1);
                lastElement.setNext(null);
            }
            else{
                Element previous = this.getElement(this.getIndex(removeElement)-1);
                previous.setNext(removeElement.getNext());
            }
            size--;
            removeElement.setNext(null);
            removeElement = null;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for(Element e : this){
            e = null;
        }
        firstElement = null;
        lastElement = null;
        currentElement = null;
        size = 0;
    }

    @Override
    public void sort() {
        for (int i = 0; i < this.size()-1; i++){
            boolean isSort = false;
            for (int j = 0; j < this.size() - i - 1; j++){
                Element first = this.getElement(j);
                Element second = this.getElement(j+1);
                if (first.getObject().compareTo(second.getObject()) > 0){
                    T temp = (T)first.getObject();
                    first.setObject(second.getObject());
                    second.setObject(temp);
                    temp = null;
                    isSort = true;
                }
            }
            if (!isSort){
                break;
            }
        }
    }

    @Override
    public T get(int index) {
        return (T)this.getElement(index).getObject();
    }

    @Override
    public T set(int index, T o) {
        Element element = this.getElement(index);
        T oldNumber = (T)element.getObject();
        element.setObject(o);
        return oldNumber;
    }

    @Override
    public T remove(int index) {
        Element removeElement = this.getElement(index);
        if (removeElement == firstElement){
            firstElement = removeElement.getNext();
        }
        else if (removeElement == lastElement){
            lastElement = this.getElement(index-1);
            lastElement.setNext(null);
        }
        else{
            Element previous = this.getElement(index-1);
            previous.setNext(removeElement.getNext());
        }
        size--;
        T object = (T)removeElement.getObject();
        removeElement.setNext(null);
        removeElement = null;
        return object;
    }

    @Override
    public boolean hasNext() {
        if (this.isEmpty()){
            return false;
        }
        if (currentElement == null && firstElement != null){
            return true;
        }
        if (currentElement.getNext() != null){
           return true;
        }
        return false;
    }

    @Override
    public Element next() {
        if (currentElement == null){
            currentElement = firstElement;
            return currentElement;
        }
        Element next = currentElement.getNext();
        currentElement = next;
        return next;
    }

    @Override
    public Iterator iterator() {
        currentElement = null;
        return this;
    }

    @Override
    public String toString(){
        StringBuffer outString = new StringBuffer();
        outString.append("[");
        for (Element e : this){
            outString.append(e.getObject().toString());
            if (currentElement == lastElement){
                continue;
            }
            outString.append(", ");
        }
        outString.append("]");
        return outString.toString();
    }

    public Element getFirstElement(){
        return firstElement;
    }

    private Element getElement(int index){
        if (index >= this.size()){
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        for(Element e : this){
            if (i++ == index){
                return e;
            }
        }
        return null;
    }

    private Element getElement(T o){
        for (Element e : this){
            if (e.getObject().equals(o)){
                return e;
            }
        }
        return null;
    }

    private int getIndex(Element element){
        int i = 0;
        for(Element e : this){
            if (e == element){
                return i;
            }
            i++;
        }
        return -1;
    }

}
