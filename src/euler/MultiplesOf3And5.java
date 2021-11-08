package euler;

/*
 * Problem 1.
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the
 * multiples of 3 or 5 below 1000.
 *
 * @author jsavely
 */
public class MultiplesOf3And5 {

    public static void main(String[] args) {
        int n = 1000, s = 0;
        for (int i = 0; i < n; i++) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                s += i;
                //System.out.println("multiples: " + i);
            }
        }
        System.out.println("sum of all the multiples: " + s);
    }
}
