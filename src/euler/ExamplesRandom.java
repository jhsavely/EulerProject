/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import org.apache.log4j.Logger;

import java.io.*;

/**
 *
 * @author jsavely
 */
public class ExamplesRandom {

    static Logger log = Logger.getLogger(ExamplesRandom.class.getName());

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
            for (int j : grid) {
                System.out.println(" " + j);
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
        //Output ASCII characters
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

    String binaryFormat(int m) {
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

    public static String ternary(int a, int b) {
        String c = (a > 0) ? "a" : "b";
        return c;
    }

    public static void main(String[] args) {
        int startCount = 0;
        long start = System.currentTimeMillis();
        ExamplesRandom rf = new ExamplesRandom();
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
        log.info("Encrypted String: " + encryptedString);
        log.info("Decrypted String: " + encryptDecrypt(encryptedString));
        System.out.println("Duration = " + (System.currentTimeMillis() - start) + " ms");
        System.out.println("startCount = " + startCount);
        //log.info(" startCount" + startCount + " ");
        double a = .999;
        int b = (int) Math.round(a);
        b = 200;
        System.out.println("a = " + a + " b  = " + b);
        System.out.println("c = " + ternary((int) a, b));
        String c = "This is string";
        String newStr = c.substring(5, 11);
        System.out.println(c);
        System.out.println(newStr);
        int cpCount = c.codePointCount(0, c.length());
        System.out.println(cpCount);
        int amountToRetire = 1_000_000;
        int payment = 3000;
        int interest;
        int interestRate = 4;
        int balance = 0;
        int years = 30;
        while (balance < amountToRetire) {
            balance += payment;
            interest = balance * interestRate / 100;
            balance += interest;
            years++;
        }
        System.out.println("You can retire in :" + years);
    }
}
