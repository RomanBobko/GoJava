package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

public class Element {

    private Comparable object;
    private Element nextElement;

    Element(Comparable object) {
        this.object = object;
    }

    public void setNext(Element nextElement) {
        this.nextElement = nextElement;
    }

    public Element getNext() {
        return this.nextElement;
    }

    public Comparable getObject() {
        return this.object;
    }

    public void setObject(Comparable object) {
        this.object = object;
    }

}
