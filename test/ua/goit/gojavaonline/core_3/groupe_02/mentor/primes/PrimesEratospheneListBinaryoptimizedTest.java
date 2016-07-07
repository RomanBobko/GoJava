package ua.goit.gojavaonline.core_3.groupe_02.mentor.primes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dima on 05.07.2016.
 */
public class PrimesEratospheneListBinaryoptimizedTest extends Assert {
    private PrimesList testPrimes;

    private int[] etalonPrimesUpTo100 = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97};

    private int primesFinded;

    @Before
    public void setUp() throws Exception {
        testPrimes = new PrimesEratospheneListBinaryoptimized(100);
        primesFinded = testPrimes.findPrimes();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindPrimesByFundedQty() throws Exception {

        assertEquals(etalonPrimesUpTo100.length, primesFinded);

    }

    @Test
    public void testFindPrimesByFindedValues() throws Exception {

        for (int i = 0; i < testPrimes.findedPrimesCount(); i++) {
            assertEquals(etalonPrimesUpTo100[i],testPrimes.getPrimeByOrder(i));
        }
    }

    @Test(expected = PrimeNumbersAlredyFindedException.class)
    public void testFindPrimesForException() throws Exception {
        testPrimes.findPrimes();
    }

    @Test
    public void testIsPrimesFindedCaseFalse() throws Exception {
        PrimesList otherTestPrimes = new PrimesEratospheneListBinaryoptimized(10);
        assertEquals(false, otherTestPrimes.isPrimesFinded());
    }

    @Test
    public void testIsPrimesFindedCaseTrue() throws Exception {
        assertEquals(true, testPrimes.isPrimesFinded());
    }

    @Test
    public void testFindedPrimesCount() throws Exception {
        assertEquals(etalonPrimesUpTo100.length, testPrimes.findedPrimesCount());
    }

    @Test
    public void testGetPrimeByOrder() throws Exception {
        for (int i = 0; i < testPrimes.findedPrimesCount(); i++) {
            assertEquals(etalonPrimesUpTo100[i],testPrimes.getPrimeByOrder(i));
        }
    }

}