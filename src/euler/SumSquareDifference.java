package euler;

/**
 * Problem 6.
 * Find the difference between the sum of the squares of the first
 * one hundred natural numbers and the square of the sum.
 *
 * @author jsavely
 */
public class SumSquareDifference {

    public static void main(String[] args) {
        int sumOfSquares = 0;
        int sum = 0;
        for (int i = 1; i < 101; i++) {
            sumOfSquares += i * i;
            sum += i;
        }

        int squareOfSum = sum * sum;
        int diff = squareOfSum - sumOfSquares;
        System.out.println("sum : " + sum);
        System.out.println("squareOfSum : " + squareOfSum);
        System.out.println("sumOfSquares : " + sumOfSquares);
        System.out.println("diff : " + diff);
    }
}
