package euler;

/**
 *Problem 4.
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99. Find the largest
 * palindrome made from the product of two 3-digit numbers.
 *
 * @author jsavely
 */
import java.util.ArrayList;
import java.util.Collections;

public class LargestPalindromeProduct {

    final static int MAX2D = 99;
    final static int MAX3D = 999;
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
        for (int i = MAX3D; i > MAX2D; i--) {
            for (int j = MAX3D; j > MAX2D; j--) {
                String s = "" + (i * j);
                if (isPalindrome(s)) {
                    palindromes.add((i * j));
                }
            }
        }
        int pal = Collections.max(palindromes);
        System.out.println("max 3x3 palindrome: " + pal);
    }

    public static void main(String[] args) {
        LargestPalindromeProduct l = new LargestPalindromeProduct();
        l.findPalindrome();
    }
}
