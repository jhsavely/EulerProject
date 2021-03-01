/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import static euler.LargeSum.log;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import org.apache.log4j.Logger;

/**
 *
 * @author jsavely
 */
public class ReadFile {

    static Logger log = Logger.getLogger(ReadFile.class.getName());

    void readFileAsBytes() {
        try {
            File file = new File("res/src_grid.txt");
            byte[] bytes = new byte[(int) file.length()];
            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String[] valueStr = new String(bytes).trim().split("\\s+");
            int[] grid = new int[valueStr.length];
            for (int i = 0; i < valueStr.length; i++) {
                grid[i] = Integer.parseInt(valueStr[i]);
            }
            for (int i = 0; i < grid.length; i++) {
                System.out.println(" " + grid[i]);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    void getFileStatistic() {
        try {
            File file = new File("res/lorem");
            if (!file.exists()) {
                log.info("File not found: " + file.getName());
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            int linesCount = 0, wordsCount = 0, commaCount = 0;
            while ((str = br.readLine()) != null) {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ',') {
                        commaCount++;
                    }
                }
                //DEBUG commaCount += str.length() - str.replace(",","").length();
                linesCount++;
                wordsCount += str.split("\\s+").length;
            }
            //DEBUG 
            log.info("File contains " + linesCount + " lines");
            log.info("File contains " + wordsCount + " words");
            log.info("File contains " + commaCount + " commas");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    void printASCII() {
        //Output ASCII charachters
        for (int i = 0; i < 255; i++) {
            //System.out.println(i + " ");
            System.out.println("ASCII " + (char) i + "  =  " + i);
        }
    }

    boolean isOdd(int n) {
        return ((n & 0x1) != 0);
    }

    boolean isEven(int n) {
        return ((n & 0x1) == 0);
    }

    String binaryFomat(int m) {
        return Integer.toString(m, 2);
    }

    static String encryptDecrypt(String inputString) {
        char key = 'K';
        String outputString = "";
        int len = inputString.length();
        for (int i = 0; i < len; i++) {
            outputString += Character.toString((char) (inputString.charAt(i) ^ key));
        }
        return outputString;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ReadFile rf = new ReadFile();
        //rf.readFileAsBytes();
        rf.getFileStatistic();
        for (int i = 0; i < 10; i++) {
            if (rf.isOdd(i)) {
                log.info("number " + i + " is odd");
            } else {
                log.info("number " + i + " is even");
            }
        }
        
        String sampleString = "ThisIsString"; 
        log.info("To XOR: " + sampleString); 
        String encryptedString = encryptDecrypt(sampleString); 
        log.info("Ecrypted String: " + encryptedString); 
        log.info("Decrypted String: " + encryptDecrypt(encryptedString)); 
        System.out.println("Duration = " + (System.currentTimeMillis() - start) + " ms");
    }
}
