package harsha.algorithms.sorting;

/**
 * @author harshavardhannaidugangavarapu
 *
 * This sorting algorithm uses BinaryHeap which internally stores elements in sorted order on insertion.
 * On retrieving the elements from BinaryHeap, they are returned in sorted order.
 * <p>
 * Time Complexity = O(NLogN)
 * Space Complexity = O(1)
 * <p>
 * ### When to use ###
 * 1. When we have to sort arrays
 * <p>
 * ### When not to use ###
 * 1. When we have sort LinkedLists
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {10, 1, 5, 100, 2, 8, 2, 7, -99, 99, 1, -2};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void heapSort(int[] arr) {
        int len = arr.length;
        BinaryHeap bh = new BinaryHeap(len);

        // add elements
        for (int i = 0; i < len; i++) {
            bh.insert(arr[i], "Min");
        }

        // retrieve elements and assign to array
        for (int i = 0; i < len; i++) {
            arr[i] = bh.extractHeadOfBP("Min");
        }
    }
}
