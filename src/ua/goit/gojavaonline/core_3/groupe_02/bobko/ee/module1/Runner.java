package ua.goit.gojavaonline.core_3.groupe_02.bobko.ee.module1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Runner {

    public static final int K10 = 10000;
    public static final int K100 = 100000;
    public static final int K1000 = 1000000;
    public static final int AMOUNT_OF_METERING = 100;


    public static void main(String[] args) throws IOException {

        FileWriter writer = new FileWriter("report.txt", false);

        writer.write("\t\t\t add \t\t get \t\t remove \t contains \t populate \t iterator.add \t iterator.remove\n");


        writer.write("ArrayLst \t|");

        List<Integer> arrayList = new ArrayList<>();
        ListMetering listMetering = new ListMetering(arrayList, AMOUNT_OF_METERING);


        double time = 0.0;
        time += listMetering.addMetering(K10);
        time += listMetering.addMetering(K100);
        time += listMetering.addMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.getMetering(K10);
        time += listMetering.getMetering(K100);
        time += listMetering.getMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.removeMetering(K10);
        time += listMetering.removeMetering(K100);
        time += listMetering.removeMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.containsMetering(K10);
        time += listMetering.containsMetering(K100);
        time += listMetering.containsMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.populateMetering(K10);
        time += listMetering.populateMetering(K100);
        time += listMetering.populateMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.addListIteratorMetering(K10);
        time += listMetering.addListIteratorMetering(K100);
        time += listMetering.addListIteratorMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.removeListIteratorMetering(K10);
        time += listMetering.removeListIteratorMetering(K100);
        time += listMetering.removeListIteratorMetering(K1000);
        writer.write(String.format("%10f \n", time));

        writer.write("LinkedLst \t|");

        List<Integer> linkedList = new LinkedList<>();
        listMetering = new ListMetering(linkedList, AMOUNT_OF_METERING);

        time = 0.0;
        time += listMetering.addMetering(K10);
        time += listMetering.addMetering(K100);
        time += listMetering.addMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.getMetering(K10);
        time += listMetering.getMetering(K100);
        time += listMetering.getMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.removeMetering(K10);
        time += listMetering.removeMetering(K100);
        time += listMetering.removeMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.containsMetering(K10);
        time += listMetering.containsMetering(K100);
        time += listMetering.containsMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.populateMetering(K10);
        time += listMetering.populateMetering(K100);
        time += listMetering.populateMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.addListIteratorMetering(K10);
        time += listMetering.addListIteratorMetering(K100);
        time += listMetering.addListIteratorMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += listMetering.removeListIteratorMetering(K10);
        time += listMetering.removeListIteratorMetering(K100);
        time += listMetering.removeListIteratorMetering(K1000);
        writer.write(String.format("%10f \n", time));

        writer.write("HashSet \t|");

        Set<Integer> set = new HashSet<>();
        SetMetering setMetering = new SetMetering(set, AMOUNT_OF_METERING);

        time = 0.0;
        time += setMetering.addMetering(K10);
        time += setMetering.addMetering(K100);
        time += setMetering.addMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += setMetering.removeMetering(K10);
        time += setMetering.removeMetering(K100);
        time += setMetering.removeMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += setMetering.containsMetering(K10);
        time += setMetering.containsMetering(K100);
        time += setMetering.containsMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += setMetering.populateMetering(K10);
        time += setMetering.populateMetering(K100);
        time += setMetering.populateMetering(K1000);
        writer.write(String.format("%10f \n", time));

        writer.write("TreeSet \t|");

        set = new TreeSet<>();
        setMetering = new SetMetering(set, AMOUNT_OF_METERING);

        time = 0.0;
        time += setMetering.addMetering(K10);
        time += setMetering.addMetering(K100);
        time += setMetering.addMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += setMetering.removeMetering(K10);
        time += setMetering.removeMetering(K100);
        time += setMetering.removeMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += setMetering.containsMetering(K10);
        time += setMetering.containsMetering(K100);
        time += setMetering.containsMetering(K1000);
        writer.write(String.format("%10f |", time));

        time = 0.0;
        time += setMetering.populateMetering(K10);
        time += setMetering.populateMetering(K100);
        time += setMetering.populateMetering(K1000);
        writer.write(String.format("%10f \n", time));

        writer.flush();
    }

}

