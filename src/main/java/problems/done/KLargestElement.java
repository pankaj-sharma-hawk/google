package problems.done;

import java.util.Scanner;

public class KLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int size = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            HeapSort heapSort = new HeapSort(arr);
            int result[] = heapSort.getKValuesHeapArray(k);
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
            heapSort.heapSort();
        }

    }
}
