package problems.done;

import java.util.Scanner;

public class FloodFillAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int board[][] = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            floodFill(board, sc.nextInt(), sc.nextInt(), sc.nextInt());
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    public static void floodFill(int board[][], int x, int y, int color) {
        fill(board, x, y, color);
    }

    private static void fill(int board[][], int i, int j, int toColor) {
        int fromColor = board[i][j];
        board[i][j] = toColor;
        if ((i + 1) < board.length && board[i + 1][j] == fromColor) {
            fill(board, i + 1, j, toColor);
        }
        if ((i - 1) >= 0 && board[i - 1][j] == fromColor) {
            fill(board, i - 1, j, toColor);
        }
        if ((j + 1) < board.length && board[i][j + 1] == fromColor) {
            fill(board, i, j + 1, toColor);
        }
        if ((j - 1) >= 0 && board[i][j - 1] == fromColor) {
            fill(board, i, j - 1, toColor);
        }
    }
}
