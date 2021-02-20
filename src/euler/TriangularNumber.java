package euler;

/**
 * Problem 12. We can see that 28 is the first triangle number to have over five
 * divisors. What is the value of the first triangle number to have over five
 * hundred divisors?
 *
 * @author jsavely
 */
public class TriangularNumber {

    public void genTriangleNumbers() {
        long t = 0;
        int n = 0;
        for (int i = 1; n < 500; i++) {
            t += i;
            n = countDivisorsSQRT(t);
            System.out.println(" i:" + i + " numbers:" + t + " n = " + n);
        }
    }

    public int countDivisorsLinear(long t) {
        int count = 0;
        for (int i = 1; i <= t; i++) {
            if (t % i == 0) {
                count++;
            }
        }
        return count;
    }

    public int countDivisorsSQRT(long t) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(t); i++) {
            if (t % i == 0) {
                if (i == Math.sqrt(t)) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TriangularNumber t = new TriangularNumber();
        t.genTriangleNumbers();
    }
}
