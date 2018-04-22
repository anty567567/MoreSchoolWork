import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Arrays {

    public static InputStreamReader inStream = new InputStreamReader(System.in);
    public static BufferedReader sysin = new BufferedReader(inStream);

    public static void main(String[] args) {
        int[][] array = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}};
        /*for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }*/

        array = tismenkoSquares(array);


        /*for (int i = 0; i < array.length; i++){
            System.out.println();
            for (int j = array[0].length - 1; j >= 0 ; j--){
                System.out.print(array[i][j] + " ");
            }
        }*/

        for (int i = 0; i < array.length; i++) {
            System.out.println();
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
    }

    public static int[][] tismenkoSquares(int[][] array) {
        int m, swapOne, swapTwo;
        for (int i = 0; i < array.length; i++) {
            m = 0;
            for (int j = array[1].length - 1; j >= 0; j--) {
                for (int k = array[1].length - 2 - m; k >= 0; k--) {
                    array[i][j] += array[i][k];
                }
                m++;
            }
        }
        for (int i = 0; i < array.length; i ++){
            for (int j = 0; j < array[0].length/2; j++){
                swapOne = array[i][j];
                swapTwo = array[i][array[i].length - 1 - j];
                array[i][j] = swapTwo;
                array[i][array[i].length - 1 - j] = swapOne;
            }
        }
        return array;
    }

    public static int[][] shiftDown(int[][] array) {
        int x, y, z;
        for (int i = 0; i < array.length; i++) {
            x = array[array[0].length - 1][i];
            for (int j = array[0].length - 1; j > 0; j--) {
                array[j][i] = array[j - 1][i];
            }
            array[0][i] = x;
        }
        return array;
    }
}
