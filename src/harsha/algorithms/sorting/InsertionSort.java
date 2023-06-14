package harsha.algorithms.sorting;

/**
 * @author harshavardhannaidugangavarapu
 *
 * This sorting algorithm divides the array into 2 parts - sorted and unsorted.
 * Pick the first element from the unsorted array in the right and
 * find its position in the sorted part present in the left.
 * <p>
 * Time Complexity = O(N^2)
 * Space Complexity = O(1)
 * <p>
 * ### When to use ###
 * 1. When we have continuous inflow of numbers, and we want to keep the sorted
 * 2. When we have insufficient memory
 * 3. Easy to implement
 * <p>
 * ### When not to use ###
 * 1. Time is a concern
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {-123, 10, 1, 5, 100, 0, 2, 8, 2, 7, -99, 99, 143, 1, -2, 12345};
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void insertionSort(int[] arr) {
        int len = arr.length;
        // start from index 1 so that we divide that into two parts
        for (int i = 1; i < len; i++) {
            // store the current pointed element
            // using j, iterate backwards till left and compare values
            int curr = arr[i], j = i;
            while (j > 0 && curr < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // after finding the insert position, copy the curr value to left part
            arr[j] = curr;
        }
    }
}
