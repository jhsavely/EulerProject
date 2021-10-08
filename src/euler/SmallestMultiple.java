package euler;

/*
 * Problem 5.
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder. What is the smallest positive number that is
 * evenly divisible by all of the numbers from 1 to 20?
 *
 * @author jsavely
 */
public class SmallestMultiple {

    final int STEP = 2 * 3 * 4 * 5 * 7 * 11 * 13 * 17 * 19;
    int cyclesAmount = 1000;
    int dividend = STEP;

    public boolean isDivisible() {
        for (int i = 2; i < 21; i++) {
            if (dividend % i != 0) {
                return false;
            }
        }
        return true;
    }

    public void findMinDivisible() {
        for (int i = 0; i < cyclesAmount; i++) {
            if (isDivisible()) {
                System.out.println("dividend: " + dividend);
                return;
            }
            dividend += STEP;
        }
        System.out.println("dividend not fo");
    }

    public static void main(String[] args) {
        SmallestMultiple sm = new SmallestMultiple();
        sm.findMinDivisible();

    }

}
