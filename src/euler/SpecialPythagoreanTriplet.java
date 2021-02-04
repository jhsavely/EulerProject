package euler;

/**
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which, a^2 + b^2 = c^2 For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2. There
 * exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the
 * product abc.
 *
 * @author jsavely
 */
public class SpecialPythagoreanTriplet {

    public void findTriplet(int limit){
    int a, b, c = 0;
        for (int m = 2; m < limit; m++) {
            for (int n = 1; n < m; n++) {
                a = m * m - n * n; 
                b = 2 * m * n; 
                c = m * m + n * n; 
                System.out.println(a + " " + b + " " + c); 
            }
            //System.out.println();
        }
    }
    
    public static void main(String[] args) {
        SpecialPythagoreanTriplet spt = new SpecialPythagoreanTriplet();
        spt.findTriplet(10);
    }
}
