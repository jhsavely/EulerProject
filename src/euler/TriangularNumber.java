package euler;

/*
 * Problem 12. We can see that 28 is the first triangle number to have over five
 * divisors. What is the value of the first triangle number to have over five
 * hundred divisors?
 *
 * @author jsavely
 */
import org.apache.log4j.Logger;  

public class TriangularNumber {

     static Logger log = Logger.getLogger(TriangularNumber.class.getName());  
    
    public void generateTriangleNumbers() {
        long triangularNumber = 0;
        int divisors = 0;
        for (int i = 1; divisors < 500; i++) {
            triangularNumber += i;
            divisors = countDivisorsSQRT(triangularNumber);
            //System.out.println(" i:" + i + " number:" + triangularNumber + " divisors = " + divisors);
            if(divisors >= 500) log.info(" i:" + i + " number:" + triangularNumber + " divisors = " + divisors);
        }
    }

    public int countDivisorsLinear(long t) {//38 minutes
        int count = 0;
        for (int i = 1; i <= t; i++) {
            if (t % i == 0) {
                count++;
            }
        }
        return count;
    }

    public int countDivisorsSQRT(long t) {//2 seconds
        int count = 0;
        for (int i = 1; i <= Math.sqrt(t); i++) {
            if (t % i == 0) {
                if (i == Math.sqrt(t)) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TriangularNumber t = new TriangularNumber();
        t.generateTriangleNumbers();
        System.out.println("duration = " + (System.currentTimeMillis() - start) + "ms");
    }
}
