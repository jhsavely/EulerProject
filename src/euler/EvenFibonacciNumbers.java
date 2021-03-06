package euler;

/**
 * Problem 2.
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5,
 * 8, 13, 21, 34, 55, 89, ... By considering the terms in the Fibonacci sequence
 * whose values do not exceed four million, find the sum of the even-valued
 * terms.
 *
 * @author jsavely
 */
public class EvenFibonacciNumbers {

//    public static long fibonacci(int n) {//recursive Fibonacci numbers, purpousely ineffective, for demonstration 
//        if (n <= 1) {
//            return n;
//        } else {
//            return fibonacci(n - 1) + fibonacci(n - 2);
//        }
//    }
    public static void main(String[] args) {
//        int n = Integer.parseInt(args[0]);
//        System.out.println(fibonacci(n));
//        for (int i = 1; i <= n; ++i) {
//            System.out.println(i + ": " + fibonacci(i));
//        }
        final int MAX_FIB = 4000000;
        int iter_limit = 1000;//safety catch for while()
        int fib0 = 0;
        int fib1 = 1;
        long s = 0;

        while (fib1 < MAX_FIB && iter_limit > 0) {
            if (fib1 % 2 == 0) {
                s += fib1;
                System.out.println("even: " + fib1 + " sum = " + s);
            }
            int f = fib0 + fib1;
            fib0 = fib1;
            fib1 = f;
            iter_limit--;
        }
        System.out.println("sum of the even-valued terms: " + s);
    }
}
