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

    enum Direction {
        UNDEFINED,
        HORIZONTAL_LEFT,
        VERTICAL_DOWN,
        DIAGONAL_RIGHT_DOWN,
        DIAGONAL_LEFT_DOWN
    };

    class CellResult {

        Direction dir = Direction.UNDEFINED;
        int row = -1;
        int column = -1;
        int product = 0;

        int productCompare(CellResult cr) {
            return (product - cr.product);
        }

        void copy(CellResult cr) {
            dir = cr.dir;
            row = cr.row;
            column = cr.column;
            product = cr.product;
        }

        void print() {
            System.out.println("product = " + product + " row = " + row + " column = " + column + " dir = " + dir);
        }
    }

    public static final int DIM = 20;
    public static final int SLICE = 4;
    int[][] gridArray = new int[DIM][DIM];
    CellResult currentCell = new CellResult();
    CellResult maxProductCell = new CellResult(); 

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

    void processCell(int row, int column) {
        currentCell.row = row;
        currentCell.column = column;
        currentCell.product = 0;
        currentCell.dir = Direction.UNDEFINED;
        if (!((column + SLICE) > DIM)) {
            //currentCell.dir = Direction.HORIZONTAL_LEFT;
            // int productRow = gridArray[row][column] * gridArray[row][column + 1] * gridArray[row][column + 2] * gridArray[row][column + 3];
            int product = 1;
            for (int j = 0; j < SLICE; j++) {
                product *= gridArray[row][column + j];
            }
            if (product > currentCell.product) {
                currentCell.product = product;
                currentCell.dir = Direction.HORIZONTAL_LEFT;
            }
        }

        if (!((row + SLICE) > DIM)) {
            //currentCell.dir = Direction.VERTICAL_DOWN;
            // productCol = gridArray[row][column] * gridArray[row + 1][column] * gridArray[row + 2][column] * gridArray[row + 3][column];
            int product = 1;
            for (int j = 0; j < SLICE; j++) {
                product *= gridArray[row + j][column];
            }
            if (product > currentCell.product) {
                currentCell.product = product;
                currentCell.dir = Direction.VERTICAL_DOWN;
            }
        }

        if (!((row + SLICE) > DIM || (column + SLICE) > DIM)) {
            //currentCell.dir = Direction.DIAGONAL_RIGHT_DOWN;
            // productCol = gridArray[row][column] * gridArray[row + 1][column + 1] * gridArray[row + 2][column + 2] * gridArray[row + 3][column + 3];
            int product = 1;
            for (int j = 0; j < SLICE; j++) {
                product *= gridArray[row + j][column + j];
            }
            if (product > currentCell.product) {
                currentCell.product = product;
                currentCell.dir = Direction.DIAGONAL_RIGHT_DOWN;
            }
        }

        if (!((row + SLICE) > DIM || (column - SLICE) < -1)) {
            //productCol = gridArray[row][column] * gridArray[row + 1][column - 1] * gridArray[row + 2][column - 2] * gridArray[row + 3][column - 3];
            //currentCell.dir = Direction.DIAGONAL_LEFT_DOWN;
            int product = 1;
            for (int j = 0; j < SLICE; j++) {
                product *= gridArray[row + j][column - j];
            }
            if (product > currentCell.product) {
                currentCell.product = product;
                currentCell.dir = Direction.DIAGONAL_LEFT_DOWN;
            }
        }
    }

    public void findMaxProduct() {
        readFile();
        printArray();
        for (int row = 0; row < DIM; row++) {
            for (int col = 0; col < DIM; col++) {
                processCell(row, col);
                if (maxProductCell.productCompare(currentCell) < 0) {
                    maxProductCell.copy(currentCell);
                 }
            }
        }
        System.out.println("maxProduct: "  );
         maxProductCell.print();
    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        LargestProductInAGrid l = new LargestProductInAGrid();
        l.findMaxProduct();
        System.out.println("duration = " + (System.currentTimeMillis() - start) + "ms");
    }
}
