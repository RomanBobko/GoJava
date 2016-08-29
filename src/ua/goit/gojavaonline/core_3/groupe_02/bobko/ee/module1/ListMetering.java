package ua.goit.gojavaonline.core_3.groupe_02.bobko.ee.module1;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListMetering {

    private List<Integer> list;
    private int amountOfMetering;
    private long time;
    private Random random = new Random();

    ListMetering(List<Integer> list, int amountOfMetering) {
        this.list = list;
        this.amountOfMetering = amountOfMetering;
    }

    public long addMetering(int amountOfElements) {
        populate(amountOfElements);
        time = System.currentTimeMillis();
        for (int i = 0; i < amountOfMetering; i++) {
            list.add(i, random.nextInt(amountOfElements));
        }
        time = System.currentTimeMillis() - time;

        return time;
    }

    public long getMetering(int amountOfElements) {
        populate(amountOfElements);

        time = System.currentTimeMillis();
        for (int i = 0; i < amountOfMetering; i++) {
            list.get(random.nextInt(amountOfElements));
        }
        time = System.currentTimeMillis() - time;

        return time;
    }

    public long removeMetering(int amountOfElements) {
        populate(amountOfElements);

        time = System.currentTimeMillis();
        for (int i = 0; i < amountOfMetering; i++) {
            list.remove(random.nextInt(amountOfElements - i));
        }
        time = System.currentTimeMillis() - time;

        return time;
    }

    public long containsMetering(int amountOfElements) {
        populate(amountOfElements);

        time = System.currentTimeMillis();
        for (int i = 0; i < amountOfMetering; i++) {
            list.contains(random.nextInt());
        }
        time = System.currentTimeMillis() - time;

        return time;
    }

    public long populateMetering(int amountOfElements) {

        time = System.currentTimeMillis();
        for (int i = 0; i < amountOfMetering; i++) {
            populate(amountOfElements);
        }
        time = System.currentTimeMillis() - time;

        return time;
    }

    public long addListIteratorMetering(int amountOfElements) {
        populate(amountOfElements);

        time = System.currentTimeMillis();
        ListIterator<Integer> iterator = list.listIterator();
        for (int i = 0; i < amountOfMetering; i++) {
            iterator.add(i);
        }
        time = System.currentTimeMillis() - time;

        return time;
    }

    public long removeListIteratorMetering(int amountOfElements) {
        populate(amountOfElements);

        time = System.currentTimeMillis();
        for (int i = 0; i < amountOfMetering; i++) {
            for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
                Integer remove = iterator.next();
                if (remove.equals(random.nextInt())){
                    iterator.remove();
                }
            }

        }
        time = System.currentTimeMillis() - time;

        return time;
    }

    private void populate(int amountOfElements) {
        list.clear();
        for (int i = 0; i < amountOfElements; i++) {
            list.add(random.nextInt());
        }
    }

}
