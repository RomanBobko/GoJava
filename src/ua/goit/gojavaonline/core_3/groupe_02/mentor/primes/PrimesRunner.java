package ua.goit.gojavaonline.core_3.groupe_02.mentor.primes;

/**
 * Created by dima on 05.07.2016.
 */
public class PrimesRunner {

    static final int TOP_MARGIN = 46339;//max = 46339;

    public static void main(String[] args) throws PrimeNumbersAlredyFindedException {
        PrimesList primes = new PrimesEratospheneListUnoptimized(TOP_MARGIN);

        long startMillies = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            primes = new PrimesEratospheneListUnoptimized(TOP_MARGIN);
            primes.findPrimes();
        }
        System.out.println("PrimesEratospheneListUnoptimized: time spended (millieseconds): " + (System.currentTimeMillis() - startMillies));
        System.out.println(primes.toString());

        startMillies = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            primes = new PrimesEratospheneListBinaryoptimized(TOP_MARGIN);
            primes.findPrimes();
        }
        System.out.println("PrimesEratospheneListBinaryoptimized: time spended (millieseconds): " + (System.currentTimeMillis() - startMillies));
        System.out.println(primes.toString());

    }

}
