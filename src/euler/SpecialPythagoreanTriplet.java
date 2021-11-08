package euler;

/*
 * Problem 9 A Pythagorean triplet is a set of three natural numbers, a < ab <
 * c, for which, a^2 + b^2 = c^2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 *
 * @author jsavely
 */
public class SpecialPythagoreanTriplet {
    
   // Euclid's algorithm
    boolean isCoprime(int dividend, int divisor) {
        while (divisor > 1) {
            int rest = dividend % divisor;
            if (rest == 0) {
                return false;
            }
            dividend = divisor;
            divisor = rest;
        }
        return true;
    }

    public void findTriplet(int limit) {
        int a, b, c, s = 0;
        for (int m = 2; m < limit; m++) {//m > n
            for (int n = 1; n < m; n++) {//n > 0
                a = m * m - n * n;//check if values is isCoprime here
                b = 2 * m * n;
                c = m * m + n * n;
                s = a + b + c;
                System.out.println(a + " " + b + " " + c);
                if (s == 1000) {
                    System.out.println(a + " " + b + " " + c + " s: " + s);
                    int prod = a * b * c;
                    System.out.println("answer: " + prod);
                }
            }
        }
    }
    public int solutionTwo() {
        for (int a = 1; a <= 500; ++a) {
            for (int b = a + 1; b < 1000; ++b) {
                if (1000 * a + 1000 * b - a * b - 500000 == 0) {
                    int c = 1000 - a - b;
                    return a * b * c;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpecialPythagoreanTriplet spt = new SpecialPythagoreanTriplet();
//        spt.findTriplet(24);
        System.out.println(spt.solutionTwo());
        System.out.println("time = " + (System.currentTimeMillis() - start));
    }
}
