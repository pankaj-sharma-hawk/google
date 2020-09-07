package problems.done;

import java.util.HashSet;

public class IsValidSudoku {
    public static void main(String[] args) {
        String grid[][] = {{"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", "3", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        System.out.println(isValidSoduko(grid));
    }

    public static boolean isValidSoduko(String grid[][]) {
        String ROW_CONSTANT = "Row:";
        String COL_CONSTANT = "Col:";
        HashSet<String> validNumbers = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!grid[i][j].equalsIgnoreCase(".")) {
                    String rowValue = ROW_CONSTANT + i + "(" + grid[i][j] + ")";
                    String colValue = COL_CONSTANT + j + "(" + grid[i][j] + ")";
                    String threeByThreeBlock = i / 3 + "(" + grid[i][j] + ")" + j / 3;
                    if (!validNumbers.add(rowValue) || !validNumbers.add(colValue) || !validNumbers.add(threeByThreeBlock)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
