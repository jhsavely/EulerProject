/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author jsavely
 */
public class ReadFile {
    public static void main(String[] args) throws FileNotFoundException, IOException {
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
        System.out.println(Arrays.asList(grid));
    }
}
