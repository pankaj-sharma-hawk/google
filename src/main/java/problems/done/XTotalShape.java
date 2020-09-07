package problems.done;

import java.util.Scanner;

public class XTotalShape {

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t-- > 0) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                sc.nextLine();
                String matrix[] = sc.nextLine().split(" ");
                char board[][] = new char[row][col];
                for (int i = 0; i < row; i++) {
                    board[i] = matrix[i].toCharArray();
                }
                System.out.println(getTotalXShape(board, row, col));
            }
    }

    public static int getTotalXShape(char board[][], int row, int col) {
        boolean visited[][] = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    dfs(board, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(char board[][], int i, int j, boolean visited[][]) {
        visited[i][j] = true;
        if ((i + 1) < board.length && board[i + 1][j] == 'X' && !visited[i + 1][j]) {
            dfs(board, i + 1, j, visited);
        }
        if ((i - 1) >= 0 && board[i - 1][j] == 'X' && !visited[i - 1][j]) {
            dfs(board, i - 1, j, visited);
        }
        if ((j + 1) < board[i].length && board[i][j + 1] == 'X' && !visited[i][j + 1]) {
            dfs(board, i, j + 1, visited);
        }
        if ((j - 1) >= 0 && board[i][j - 1] == 'X' && !visited[i][j - 1]) {
            dfs(board, i, j - 1, visited);
        }
    }
}
