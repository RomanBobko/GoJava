package ua.goit.gojavaonline.core_3.groupe_02.mentor.primes;

/**
 * Created by dima on 05.07.2016.
 */
public abstract class AbstractPrimesList implements PrimesList {

    public final int DEFAULT_TOP_MARGIN = 1000;

    protected int topMargin = DEFAULT_TOP_MARGIN;

    protected int count = 0;

    private boolean primesFinded = false;

    protected int[] primes;

    public AbstractPrimesList() {
        primes = new int[topMargin];
    }

    public AbstractPrimesList(int topMargin) {
        this.topMargin = topMargin;
        primes = new int[topMargin];
    }

    public int findPrimes() throws PrimeNumbersAlredyFindedException {
        if( primesFinded ) {
            throw new PrimeNumbersAlredyFindedException();
        } else {

            // main algorithm implementation
            findPrimesImplementation();

            primesFinded = true;
        }
        return count;
    }

    abstract void findPrimesImplementation();

    public boolean isPrimesFinded() {
        return primesFinded;
    }

    public int findedPrimesCount() {
        return count;
    }

    public int getPrimeByOrder(int primeNumber) {
        return primes[primeNumber];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count-1; i++) {
            sb.append( primes[i] + ", ");
        };
        sb.append( primes[count-1] );

        return "primes=[" + sb.toString() + "]}";
    }
}
