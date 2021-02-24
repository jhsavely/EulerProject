/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author jsavely
 */
public class ReadFile {

    void readFile() {
        try {
            File file = new File("res/src_grid.txt");
            byte[] bytes = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(bytes);
            fis.close();
            String[] valueStr = new String(bytes).trim().split("\\s+");
            int[] grid = new int[valueStr.length];
            for (int i = 0; i < valueStr.length; i++) {
                grid[i] = Integer.parseInt(valueStr[i]);
            }
            for (int i = 0; i < grid.length; i++) {
                System.out.println(" " + grid[i]); 
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        ReadFile rf = new ReadFile();
        rf.readFile();
    }
}
