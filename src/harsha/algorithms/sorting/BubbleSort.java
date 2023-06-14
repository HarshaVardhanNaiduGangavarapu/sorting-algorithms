package harsha.algorithms.sorting;

/**
 * @author harshavardhannaidugangavarapu
 *
 * This sorting algorithm compares two adjacent elements and swap if they are not in order of left is less than right.
 * At the end of this, the biggest element will be moved to the right.
 * Continues this with n-1 elements and soon...
 * <p>
 * Time Complexity = O(N^2)
 * Space Complexity = O(1)
 * ### When to use ###
 * 1. When array is almost sorted
 * 2. When space is a concern
 * 3. Easy to implement
 * <p>
 * ### When not to use ###
 * 1. Time is a concern
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {10, 1, 5, 100, 2, 8, 2, 7, -99, 99, 1, -2};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void bubbleSort(int[] arr) {
        int len = arr.length;
        // till len-1 elements
        for (int i = 0; i < len - 1; i++) {
            // comparing starting from left most index to right most index minus i,
            // and move large element to right
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
