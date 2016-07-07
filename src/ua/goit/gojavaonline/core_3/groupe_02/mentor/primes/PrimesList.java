package ua.goit.gojavaonline.core_3.groupe_02.mentor.primes;

/**
 * Created by dima on 05.07.2016.
 */
public interface PrimesList {

    // returns the number of finded PRIME NUMBERS or the PrimeNumbersAlredyFindedException
    int findPrimes() throws PrimeNumbersAlredyFindedException;

    // true means that the PRIME NUMBERS alredy finded
    boolean isPrimesFinded();

    // returns the quantity of finded PRIME NUMBERS
    int findedPrimesCount();

    // returns the PRIME NUMBER in position. Position index starts from 0;
    int getPrimeByOrder(int primeNumber);

}
