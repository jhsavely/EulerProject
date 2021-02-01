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
import java.util.Collections;

public class LargestPalindromeProduct {

    final static int max2d = 99;
    final static int max3d = 999;
    public ArrayList<Integer> palindromes = new ArrayList<>();

    public boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public void findPalindrome() {
        for (int i = max3d; i > max2d; i--) {
            for (int j = max3d; j > max2d; j--) {
                String s = "" + (i * j);
                if (isPalindrome(s)) {
                    palindromes.add((i * j));
                }
            }
        }
        int pal = Collections.max(palindromes);
        System.out.println("max3x3 : " + pal);
    }

    public static void main(String[] args) {
        LargestPalindromeProduct l = new LargestPalindromeProduct();
        l.findPalindrome();
    }
}
