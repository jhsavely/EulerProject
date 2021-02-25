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

/**
 *
 * @author jsavely
 */
public class ReadFile {

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
            int linesCount = 0;
            int wordsCount = 0;
            int commaCount = 0;
            char comma = ',';
            
            while ((str = br.readLine()) != null) {
                char[] lineChars = new char[str.length()];
                for (int i = 0; i < str.length(); i++) {
                    lineChars[i] = str.charAt(i);
                    if(lineChars[i] == comma){
                        commaCount++;
                    }
                }
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
        ReadFile rf = new ReadFile();
        //rf.readFileAsBytes();
        rf.getFileStatistic();
    }
}
