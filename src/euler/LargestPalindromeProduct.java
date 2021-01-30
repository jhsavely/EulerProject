/**
 *
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author jsavely
 */
package euler;

import java.util.ArrayList;

public class LargestPalindromeProduct {

    public static void main(String[] args) {
          ArrayList<String> products = new ArrayList<>();

        for (int i = 100; i < 999; i++) {
            for (int j = 100; j < 999; j++) {
                Integer prod;
                prod = i * j;
                products.add(prod.toString());
                System.out.print(" " +i * j);
            }
            System.out.println();
        }
       
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                System.out.print((" " + i) + j);
//            }
//            System.out.println();
//        }
        String str = "aaaa";
        if (str.charAt(0) == str.charAt(str.length() - 2)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
