package euler;

/**
 *Problem 3.
 * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime
 * factor of the number 600851475143 ?
 *
 * @author jsavely
 */
import java.util.ArrayList;
import java.util.Collections;

public class LargestPrimeFactor {

    final static long TEST_NUMBER = 600851475143L;
    ArrayList<Long> divisors = new ArrayList<>();
    ArrayList<Long> primes = new ArrayList<>();

    public void sieve(long limit) {
        primes.clear();
        primes.add(1L);
        long start = primes.get(primes.size() - 1) + 1;
        for (long i = start; i < limit + 1; i++) {
            boolean isPrime = true;
            for (int j = 1; j < primes.size(); j++) {
                long x = primes.get(j);
                if (x * x > i) {
                    break;
                }
                if ((i % x) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
    }

    public long findDivsor(long limit) {
        long result = 0;
        for (long prime : primes) {
            if (prime < 2) {
                continue;
            }
            if (prime * prime > limit) {
                break;
            }
            if (limit % prime == 0) {//adding only prime divisors to the divisors array
                result = prime;
                divisors.add(result);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        LargestPrimeFactor p = new LargestPrimeFactor();
        p.sieve((long) Math.sqrt(TEST_NUMBER));
        for (long divident = TEST_NUMBER; divident > 1;) {
            long divisor = p.findDivsor(divident);
            if (divisor > 0) {
                p.divisors.add(divisor);
            } else {
                p.divisors.add(divisor = divident);
            }
            divident = divident / divisor;
        }
        for (long div : p.divisors) {
            System.out.println(div);
        }
        System.out.println("Max divisor : " + Collections.max(p.divisors));
    }
}
