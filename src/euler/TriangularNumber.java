package euler;

/**
 * Problem 12. We can see that 28 is the first triangle number to have over five
 * divisors. What is the value of the first triangle number to have over five
 * hundred divisors?
 *
 * @author jsavely
 */
public class TriangularNumber {
    int[] numbers = new int[100];
    
    public void genTriangleNumbers(){
    int s = 0;
        for (int i = 1; i < 100; i++) {
            s += i;
            numbers[i] = s;
            //System.out.println(" i:" + i + " s= " + s);
            System.out.println(" numbers:" + numbers[i]);
        }
    }
    
    public void findDivisors(){
    
    }

    public static void main(String[] args) {
        TriangularNumber t = new TriangularNumber();
        t.genTriangleNumbers();
    }
}
