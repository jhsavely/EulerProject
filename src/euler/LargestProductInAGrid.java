package euler;

/**
 * Problem 11. In the 20×20 grid below, four numbers along a diagonal line have
 * been marked in red. The product of these numbers is 26 × 63 × 78 × 14 =
 * 1788696. What is the greatest product of four adjacent numbers in the same
 * direction (up, down, left, right, or diagonally) in the 20×20 grid?
 *
 * @author jsavely
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LargestProductInAGrid {

    public static final int DIM = 20;
    public static final int SLICE = 4;
    int[][] gridArray = new int[DIM][DIM];

    public void readFile() {
        try {
            File myObj = new File("res/src_grid.txt");
            if (!myObj.exists()) {
                System.out.println("File not found: " + myObj.getName());
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(myObj));
            String str;
            {
                int i = 0, j = 0;
                while ((str = br.readLine()) != null) {
                    String[] str_arr = str.split("\\D+");// this left digits only, "\\W+" will include letters
                    for (String str_num : str_arr) {
                        int n = Integer.parseInt(str_num);
                        gridArray[i][j] = n;
                        if (++j >= DIM) {
                            break;
                        }
                    }
                    j = 0;
                    if (++i >= DIM) {
                        break;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
        }
    }

    public void printArray() {
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                System.out.print(gridArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int processHorizontalCells(int row,int column) {
        if((column + SLICE) > DIM) return 0;
        int product  = gridArray[row][column] * gridArray[row][column+1] * gridArray[row][column+2] * gridArray[row][column+3];
//        for (int i = column; i < SLICE; i++) {
//            product *= gridArray[row][column + i];
//        }

        return product;
    }

    public void findMaxProduct() {
        readFile();
        printArray();
        long maxProduct = 0;
        for (int row = 0; row < DIM; row++) {
            for(int col = 0;col < DIM; col++ ){
            int product = processHorizontalCells(row, col);
            if (product > maxProduct) {
                maxProduct = product;
            }
            }
            
        }
        System.out.println("Max product: " + maxProduct);
    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        LargestProductInAGrid l = new LargestProductInAGrid();
        l.findMaxProduct();
        System.out.println("duration = " + (System.currentTimeMillis() - start) + "ms");
    }
}
