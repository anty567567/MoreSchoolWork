/* ReviewAssignment.java
Description: The game bingo
Name: Anthony De Luca
Date Created: 21st March 2018
Last Modified: 21st March 2018
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Bingo {

    public static InputStreamReader inStream = new InputStreamReader(System.in);
    public static BufferedReader sysin = new BufferedReader(inStream);

    //Main method which initializes board array and calls all secondary methods
    public static void main(String[] args) throws IOException {
        boolean play = true;
        while (play) {
            boolean verticalWin = false, horizontalWin = false, diagonalWin = false;
            int called;
            int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
            ArrayList<Integer> numbersCalled = new ArrayList<>();
            board = initializeBoard(board);
            while (!(verticalWin || horizontalWin || diagonalWin)) {
                called = callNumber(numbersCalled);
                numbersCalled.add(called);
                board = fillBoard(board, called);
                verticalWin = checkVerticalWin(board);
                horizontalWin = checkHorizontalWin(board);
                diagonalWin = checkDiagonalWin(board);
                outputBoard(board, numbersCalled);
                System.out.println("Play again? (Y/N): ");
            }
            if (sysin.readLine().equalsIgnoreCase("n")) {
                play = false;
            }
        }

    }

    //Creates the bingo board
    public static int[][] initializeBoard(int[][] board) {
        int x = 0;
        boolean same = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                while (same) {
                    x = (int) (Math.random() * 15 + 15 * i + 1);
                    for (int k = 0; k < 5; k++) {
                        if (board[i][k] == x) {
                            same = true;
                            k = 5;
                        } else {
                            same = false;
                        }
                    }
                }
                board[i][j] = x;
                same = true;
            }
        }
        board[2][2] = -1;
        return board;
    }

    //Replaces called numbers on bingo board with -1
    public static int[][] fillBoard(int[][] board, int called) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == called) {
                    board[i][j] = -1;
                }

            }

        }
        return board;
    }

    //Calls a random number
    public static int callNumber(ArrayList<Integer> numbersCalled) {
        int called = 0;
        boolean goodNum = false;
        while (!goodNum) {
            goodNum = true;
            called = (int) (Math.random() * 75 + 1);
            for (int i = 0; i < numbersCalled.size(); i++) {
                if (called == numbersCalled.get(i)) {
                    goodNum = false;
                }
            }
        }
        return called;
    }

    //Checks the vertical direction win
    public static boolean checkVerticalWin(int[][] board) {
        int win = 0;
        boolean winningLine = true;
        for (int[] i : board) {
            for (int j : i) {
                if (j != -1) {
                    winningLine = false;
                }
                if (!winningLine) {
                    win++;
                    winningLine = true;
                }
            }
        }
        if (win < 5) {
            return true;
        }
        return false;
    }

    //Checks the horizontal direction win
    public static boolean checkHorizontalWin(int[][] board) {
        int win = 0;
        boolean winningLine = true;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[j][i] != -1) {
                    winningLine = false;
                }
            }
            if (!winningLine) {
                win++;
                winningLine = true;
            }
        }
        if (win < 5) {
            return true;
        }
        return false;
    }

    //Checks the diagonal direction win
    public static boolean checkDiagonalWin(int[][] board) {
        boolean win = true;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != -1) {
                win = false;
            }
        }
        if (win) {
            return true;
        }
        for (int i = 0; i < 5; i++) {
            if (board[i][4 - i] != -1) {
                win = false;
            }
        }
        if (win) {
            return true;
        }
        return false;
    }

    //Displays the board and numbers called
    public static void outputBoard(int[][] board, ArrayList<Integer> numbersCalled) {
        System.out.println("Board");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.println();
        }
        System.out.print("\nNumbers Called: ");
        for (int i : numbersCalled) {
            System.out.print(i + "  ");

        }
        System.out.println();
    }
}
