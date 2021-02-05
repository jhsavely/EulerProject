/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Problem 10 The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17. Find the sum
 * of all the primes below two million.
 *
 * @author jsavely
 */
public class SumOfPrimes {

    ArrayList<Integer> primes = new ArrayList<>();
    final static int PRIME_INDEX = 2_000_000;

    public void sieve() {
        primes.clear();
        for (int n = 2; n < PRIME_INDEX; n++) {//start from 2
            boolean isPrime = true;
            for (int j = 0; j < primes.size(); j++) {
                int prime = primes.get(j);
                if (prime * prime > n) {
                    break;
                }
                if ((n % prime) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(n);
                // System.out.println(primes.size() + ": " + n);
            }
        }
    }

    void calcPrimeSum() {
        long sum = 0;
        sieve();
        for (Integer i : primes) {
            sum += i;
           //System.out.println(i+" : " + sum);
        }
        System.out.println("sumOfAllPrimes : " + sum);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SumOfPrimes sop = new SumOfPrimes();
        sop.calcPrimeSum();
        System.out.println("time = " + (System.currentTimeMillis() - start));
    }
}
