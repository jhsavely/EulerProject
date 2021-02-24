package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.log4j.Logger;

/**
 * Problem 13. Work out the first ten digits of the sum of the following
 * one-hundred 50-digit numbers.
 *
 * @author jsavely
 */
public class LargeSum {

    static Logger log = Logger.getLogger(LargeSum.class.getName());

    void doBigIntSum() {
        try {
            File file = new File("res/hundred_numbers");
            if (!file.exists()) {
                log.info("File not found: " + file.getName());
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            int countLines = 0;
            BigInteger sum = BigInteger.ZERO;
            while ((str = br.readLine()) != null) {
                BigInteger bi = new BigInteger(str);
                //DEBUG log.info(countLines + " Bi is : " + bi);
                sum =  sum.add(bi);
               //DEBUG  log.info("Sum is : " + sum);
                countLines ++;
                
            }
            log.info("Lines in file: " + countLines);
            log.info("Sum is : " + sum);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
        void doBigDecSum() {
        try {
            File file = new File("res/hundred_numbers");
            if (!file.exists()) {
                log.info("File not found: " + file.getName());
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            int countLines = 0;
            BigDecimal sum = BigDecimal.ZERO;
            while ((str = br.readLine()) != null) {
                BigDecimal bi = new BigDecimal(str);
                //DEBUG log.info(countLines + " Bi is : " + bi);
                sum =  sum.add(bi);
               //DEBUG  log.info("Sum is : " + sum);
                countLines ++;
            }
            log.info("Lines in file: " + countLines);
            log.info("Sum is : " + sum);

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LargeSum ls = new LargeSum();
        ls.doBigDecSum();
        System.out.println("duration = " + (System.currentTimeMillis() - start) + "ms");
    }

}
