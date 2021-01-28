/**
 *
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author jsavely
 */
package euler;

public class LargestPalindromeProduct {

    public static void main(String[] args) {

//        for (int i = 100; i < 999; i++) {
//            for (int j = 100; j < 999; j++) {
//                System.out.print(" :" + i * j);
//            }
//            System.out.println();
//        }
        int[][] s;
        s = new int[10][10];
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                //s[i][0] = i;
                //s[0][j] = j;
                //s[i][j] = s[i][j];
                System.out.print( " " + i * j); 
                //System.out.print(" " + s);
            }
            System.out.println();
        }
    }
}
