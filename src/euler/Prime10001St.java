package euler;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13. What is the 10 001st prime number?
 *
 * @author jsavely
 */
import java.util.ArrayList;

public class Prime10001St {

    ArrayList<Integer> primes = new ArrayList<>();
    final static int PRIME_INDEX = 10001;

    public void sieve() {
        primes.clear();
        for (int N = 2; primes.size() < PRIME_INDEX; N++) {
            boolean isPrime = true;
            for (int j = 0; j < primes.size(); j++) {
                long x = primes.get(j);
                if (x * x > N) {
                    break;
                }
                if ((N % x) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(N);
                System.out.println(primes.size()+": "+N);
            }
        }
    }

    public static void main(String[] args) {
        Prime10001St p = new Prime10001St();
        p.sieve();
    }
}
