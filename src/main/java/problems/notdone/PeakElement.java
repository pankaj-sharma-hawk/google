package problems.notdone;

public class PeakElement {

    public static void main(String[] args) {
        int A[] = {1, 2, 3, 7, 5, 6, 4};
        System.out.println(peakElement(A, A.length));
    }

    public static int peakElement(int[] arr, int n) {
        return findPeakByBinarySearch(arr, 0, n - 1);
    }

    private static int findPeakByBinarySearch(int arr[], int start, int end) {
        if (start > end)
            return -1;
        int mid = start + (end - start) / 2;
        if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
            return mid;
        }
        if (mid > 0 && arr[mid - 1] > arr[mid]) {
            return findPeakByBinarySearch(arr, start, mid - 1);
        } else {
            return findPeakByBinarySearch(arr, mid + 1, end);
        }

    }


}
