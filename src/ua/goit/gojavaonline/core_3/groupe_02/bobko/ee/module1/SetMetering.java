package ua.goit.gojavaonline.core_3.groupe_02.bobko.ee.module1;

import java.util.Random;
import java.util.Set;

public class SetMetering {

    private Set<Integer> set;
    private int amountOfMetering;
    private long time;
    private Random random = new Random();

    SetMetering(Set<Integer> set, int amountOfMetering) {
        this.set = set;
        this.amountOfMetering = amountOfMetering;
    }

    public long addMetering(int amountOfElements) {
        populate(amountOfElements);
        time = System.currentTimeMillis();
        for (int i = 0; i < amountOfMetering; i++) {
            set.add(i);
        }
        time = System.currentTimeMillis() - time;

        return time;
    }

    public long removeMetering(int amountOfElements) {
        populate(amountOfElements);
        time = System.currentTimeMillis();
        for (int i = 0; i < amountOfMetering; i++) {
            set.remove(random.nextInt());
        }
        time = System.currentTimeMillis() - time;

        return time;
    }

    public long containsMetering(int amountOfElements) {
        populate(amountOfElements);
        time = System.currentTimeMillis();
        for (int i = 0; i < amountOfMetering; i++) {
            set.contains(random.nextInt());
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

    private void populate(int amountOfElements) {
        set.clear();
        for (int i = 0; i < amountOfElements; i++) {
            set.add(random.nextInt());
        }
    }

}
