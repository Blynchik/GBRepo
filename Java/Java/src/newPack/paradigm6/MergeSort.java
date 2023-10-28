package newPack.paradigm6;

import java.util.Arrays;

public class MergeSort {

    public static int[] getSorted(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int[][] dividedArrays = divideArray(array);
        int[] firstHalf = dividedArrays[0];
        int[] secondHalf = dividedArrays[1];

        firstHalf = getSorted(firstHalf);
        secondHalf = getSorted(secondHalf);

        return merge(firstHalf, secondHalf);
    }

    private static int[][] divideArray(int[] array) {
        int middle = array.length / 2;
        int[] fA = new int[middle];
        int[] sA = new int[array.length - middle];

        System.arraycopy(array, 0, fA, 0, middle);

        int k = 0;
        for (int i = middle; i < array.length; i++) {
            sA[k] = array[i];
            k++;
        }
        return new int[][]{fA, sA};
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k] = arr1[i];
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arr1.length) {
            merged[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            merged[k] = arr2[j];
            j++;
            k++;
        }

        return merged;
    }
}
