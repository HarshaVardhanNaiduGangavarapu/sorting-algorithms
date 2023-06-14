package harsha.algorithms.sorting;

/**
 * @author harshavardhannaidugangavarapu
 *
 * This sorting algorithm divides the given array into sub-arrays and continue till those sub-arrays cannot be divided.
 * After that conquer, start sorting the sub-arrays and merge them.
 * <p>
 * Time Complexity = O(NLogN) => For dividing into sub-arrays is LogN and conquering is N.
 * On each division, we are conquering so, N * LogN.
 * Space Complexity = O(N)
 * <p>
 * ### When to use ###
 * 1. When time is a concern
 * 2. When you need a stable sort (preserving the sequence order of identical elements)
 * <p>
 * ### When not to use ###
 * 1. When space is a concern
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9, 0, 1000, 3, 6, -10, 1, 8, 4, 2, 5, 7, 99};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        // recursively call merge sort on the divided sub arrays
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        sortElements(arr, start, mid, end);
    }

    private static void sortElements(int[] arr, int start, int mid, int end) {
        // create temporary left and right sub-array to hold divided arrays

        // left array length add 1 as start is from 0
        int leftLen = mid - start + 1;
        int rightLen = end - mid;
        int[] tempLeftArray = new int[leftLen];
        int[] tempRightArray = new int[rightLen];

        // copy all the sub arrays into temporary arrays
        for (int i = 0; i < leftLen; i++) {
            tempLeftArray[i] = arr[start + i];
        }

        for (int i = 0; i < rightLen; i++) {
            tempRightArray[i] = arr[mid + i + 1];
        }

        // starting from the `start` index of main array
        // compare and store elements accordingly
        int i = 0, j = 0, index = start;
        while (i < leftLen && j < rightLen) {
            if (tempLeftArray[i] < tempRightArray[j]) {
                arr[index] = tempLeftArray[i];
                index++;
                i++;
            } else {
                arr[index] = tempRightArray[j];
                index++;
                j++;
            }
        }

        // for unequal arrays if there are any leftover elements
        while (i < leftLen) {
            arr[index] = tempLeftArray[i];
            index++;
            i++;
        }

        while (j < rightLen) {
            arr[index] = tempRightArray[j];
            index++;
            j++;
        }
    }
}
