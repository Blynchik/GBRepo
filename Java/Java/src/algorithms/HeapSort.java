package algorithms;

import java.util.Random;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = getRndArray();

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        sort(array);

        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    private static void sort(int[] array) {

        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private static void heapify(int[] array, int heapSize, int rootIndex) {
        int largestNumIndex = rootIndex;

        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;

        if (leftChildIndex < heapSize && array[leftChildIndex] > array[largestNumIndex]) {
            largestNumIndex = leftChildIndex;
        }

        if (rightChildIndex < heapSize && array[rightChildIndex] > array[largestNumIndex]) {
            largestNumIndex = rightChildIndex;
        }

        if (largestNumIndex != rootIndex) {
            int temp = array[rootIndex];
            array[rootIndex] = array[largestNumIndex];
            array[largestNumIndex] = temp;

            heapify(array, heapSize, largestNumIndex);
        }
    }

    private static int[] getRndArray() {
        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(0, 20);
        }

        return array;
    }
}
