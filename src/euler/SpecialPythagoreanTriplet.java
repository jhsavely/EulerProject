package euler;

import jdk.nashorn.api.tree.BreakTree;

/**
 * Problem 9 A Pythagorean triplet is a set of three natural numbers, a < ab <
 * c, for which, a^2 + b^2 = c^2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 *
 * @author jsavely
 */
public class SpecialPythagoreanTriplet {
    
   // Euclid's algorithm
    boolean isCoprime(int divident, int divisor) {
        while (divisor > 1) {
            int rest = divident % divisor;
            if (rest == 0) {
                return false;
            }
            divident = divisor;
            divisor = rest;
        }
        return true;
    }

    public void findTriplet(int limit) {
        int a, b, c, s = 0;
        for (int m = 2; m < limit; m++) {//m > n
            for (int n = 1; n < m; n++) {//n > 0

                a = m * m - n * n;
                b = 2 * m * n;
//                if (!isCoprime(a, b)) {
//                    continue;
//                }
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

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpecialPythagoreanTriplet spt = new SpecialPythagoreanTriplet();
        spt.findTriplet(24);
        System.out.println("time = " + (System.currentTimeMillis() - start));
    }
}
