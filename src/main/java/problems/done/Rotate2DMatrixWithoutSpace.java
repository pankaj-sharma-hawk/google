package problems.done;

public class Rotate2DMatrixWithoutSpace {
    public static void main(String[] args) {

    }

    public static void rotate2dMatrixWithoutSpace(int arr[][], int n) {
        transposeMatrix(arr, n);
        reverseMatrixByColumn(arr, n);
    }

    private static void transposeMatrix(int arr[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    private static void reverseMatrixByColumn(int arr[][], int n) {
        for (int i = 0; i < n; i++) {
            int lastIndex = n;
            int firstIndex = 0;
            while (firstIndex < lastIndex) {
                int temp = arr[i][firstIndex];
                arr[i][firstIndex] = arr[i][lastIndex - 1];
                arr[i][lastIndex - 1] = temp;
                firstIndex++;
                lastIndex--;
            }
        }
    }
}
