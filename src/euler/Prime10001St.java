package euler;

/**
 * Problem 7.
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we
 * can see that the 6th prime is 13.
 * What is the 10001st prime number?
 *
 * @author jsavely
 */
import java.util.ArrayList;

public class Prime10001St {

    ArrayList<Integer> primes = new ArrayList<>();
    final static int PRIME_INDEX = 10001;

    public void sieve() {
        primes.clear();
        for (int n = 2; primes.size() < PRIME_INDEX; n++) {//from 2 
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
                System.out.println(primes.size() + ": " + n);
            }
        }
    }

    public static void main(String[] args) {
        Prime10001St p = new Prime10001St();
        p.sieve();
    }
}
