package problems.done;

import java.util.Arrays;

public class HeapSort {

    private int heap[];

    public HeapSort(int arr[]) {
        this.heap = Arrays.copyOf(arr, arr.length);
    }

    public int[] getHeapSortedArray() {
        for (int i = 1; i < heap.length; i++) {
            heapify(heap, getParentIndex(i), i);
        }
        return heap;
    }

    public int[] getKValuesHeapArray(int k) {
        int result[] = new int[k];
        heapSort();
        for (int i = 1; i <= k; i++) {
            result[i - 1] = this.heap[0];
            swap(0, heap.length - i);
            heapifyAfterDelete(0, heap.length - 1 - i);
        }
        return result;
    }

    public void heapSort() {
        for (int i = (this.heap.length / 2) - 1; i >= 0; i--) {
            heapSortHeapify(i, this.heap.length - 1);
        }
    }

    public void printHeap() {
        System.out.println(Arrays.toString(this.heap));
    }

    private void heapSortHeapify(int index, int size) {
        int leftIndex = getLeftIndex(index, size);
        int rightIndex = getRightIndex(index, size);
        int resultIndex = leftIndex != -1 && this.heap[leftIndex] > this.heap[index] ? leftIndex : index;
        resultIndex = rightIndex != -1 && this.heap[rightIndex] > this.heap[resultIndex] ? rightIndex : resultIndex;
        if (resultIndex != -1 && resultIndex != index) {
            swap(index, resultIndex);
            heapSortHeapify(resultIndex, size);
        }
    }

    private void heapifyAfterDelete(int start, int end) {
        int leftIndex = getLeftIndex(start, end);
        int rightIndex = getRightIndex(start, end);
        if (leftIndex == -1 && rightIndex == -1)
            return;
        if (leftIndex != -1 && rightIndex != -1) {
            int resultIndex = heap[leftIndex] > heap[rightIndex] ? leftIndex : rightIndex;
            resultIndex = heap[resultIndex] > heap[start] ? resultIndex : start;
            if (resultIndex != start) {
                swap(resultIndex, start);
                heapifyAfterDelete(resultIndex, end);
            }
        } else {
            int resultIndex = leftIndex != -1 ? leftIndex : rightIndex;
            resultIndex = heap[resultIndex] > heap[start] ? resultIndex : start;
            if (resultIndex != start) {
                swap(resultIndex, start);
                heapifyAfterDelete(resultIndex, end);
            }

        }

    }

    private int getLeftIndex(int start, int end) {
        if (start != -1 && 2 * start + 1 <= end) {
            return 2 * start + 1;
        }
        return -1;
    }

    private int getRightIndex(int start, int end) {
        if (start != -1 && 2 * start + 2 <= end) {
            return 2 * start + 2;
        }
        return -1;
    }

    private void heapify(int arr[], int parentIndex, int currentNodeIndex) {
        if (parentIndex == -1)
            return;
        if (arr[parentIndex] > arr[currentNodeIndex])
            return;
        swap(parentIndex, currentNodeIndex);
        heapify(arr, getParentIndex(parentIndex), parentIndex);
    }

    private int getParentIndex(int childIndex) {
        if (childIndex == 0)
            return -1;
        return (childIndex - 1) / 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


}
