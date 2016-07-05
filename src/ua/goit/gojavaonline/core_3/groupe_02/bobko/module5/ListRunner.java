package ua.goit.gojavaonline.core_3.groupe_02.bobko.module5;

public class ListRunner {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();

        for (int i = 0; i < 25; i++){
            Double d1 = Math.random() * 100;
            list.add(d1.intValue());
        }
        list.set(4, -77);
        MyArrayList<Integer> list2 = list.sortImmutable();

        System.out.println(list);
        System.out.println(list2);

        MyLinkedList<Integer> list3 = new MyLinkedList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);

        System.out.println(list3);


    }
}
