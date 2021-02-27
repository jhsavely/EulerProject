/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import static euler.LargeSum.log;
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
                //commaCount += str.length() - str.replace(",","").length();
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

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ReadFile rf = new ReadFile();
        //rf.readFileAsBytes();
        rf.getFileStatistic();
        System.out.println("duration = " + (System.currentTimeMillis() - start) + "ms");
    }
}
