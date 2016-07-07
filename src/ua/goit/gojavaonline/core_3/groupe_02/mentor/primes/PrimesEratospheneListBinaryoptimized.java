package ua.goit.gojavaonline.core_3.groupe_02.mentor.primes;

import java.util.Arrays;

/**
 * Created by dima on 05.07.2016.
 */
public class PrimesEratospheneListBinaryoptimized extends AbstractPrimesList {

    private boolean[] numbersToFilter = new boolean[topMargin];

    public PrimesEratospheneListBinaryoptimized(int topMargin) {
        super(topMargin);
    }

    @Override
    void findPrimesImplementation() {

        Arrays.fill(numbersToFilter,true);
        for (int i = 0; i < topMargin; i=i+2) {
            numbersToFilter[i] = false;
        }

        for (int i = 3; i < topMargin; i=i+2) {
            if (numbersToFilter[i]){
                for (int k = 0; i*i+k*i < topMargin; k++) {
                    numbersToFilter[i*i+k*i] = false;
                }
            }
        }

        primes[count++] = 2;
        for (int i = 2; i < topMargin; i++) {
            if ( numbersToFilter[i]) {
                primes[count++] = i;
            }
        }

    }
}
