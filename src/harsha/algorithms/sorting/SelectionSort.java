package harsha.algorithms.sorting;

/**
 * @author harshavardhannaidugangavarapu
 *
 * This sorting algorithm `select` the smallest element and moves to the left.
 * Next starts from left+1 index, does this until the end of array.
 * At the end all the smallest elements will be moved towards the left and get sorted.
 * <p>
 * Time Complexity = O(N^2)
 * Space Complexity = O(1)
 * <p>
 * ### When to use ###
 * 1. When space is a concern, and we have insufficient memory
 * 2. Easy to implement
 * <p>
 * ### When not to use ###
 * 1. Time is a concern
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {-123, 10, 1, 5, 100, 0, 2, 8, 2, 7, -99, 99, 143, 1, -2, 12345};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void selectionSort(int[] arr) {
        int len = arr.length;
        // start from left side of the array
        for (int i = 0; i < len; i++) {
            // assume first element is the smallest
            int smallIndex = i;
            // find the smallest element in the array
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[smallIndex]) {
                    smallIndex = j;
                }
            }
            // if the small index is not same as current `i` index,
            // then swap the small element to the left
            if (smallIndex != i) {
                int temp = arr[i];
                arr[i] = arr[smallIndex];
                arr[smallIndex] = temp;
            }
        }
    }
}
