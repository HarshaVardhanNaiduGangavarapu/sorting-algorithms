package harsha.algorithms.sorting;

/**
 * @author harshavardhannaidugangavarapu
 *
 * This sorting algorithm sorts the array by selecting a pivot (here it is element at end of array)
 * and sort the elements in such a way that the elements < pivot are towards left and elements > pivot towards right.
 * <p>
 * After sorting based on the pivot number, the pivot number is placed in its sorted position.
 * Now sort the left sub array and right sub array of the array recursively.
 * <p>
 * Time Complexity  = O(NLogN)
 * Space Complexity = O(N)
 * <p>
 * ### When to use ###
 * 1. When time is a concern
 * 2. When don't need a stable sort (preserving the sequence order of identical elements)
 * <p>
 * ### When not to use ###
 * 1. Space is a concern
 * 2. When you need a stable sort
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 1, 5, 100, 2, 8, 2, 7, -99, 99, 1, -2};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = partitionArray(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partitionArray(int[] arr, int start, int end) {
        // select the end element as pivot
        int pivot = end;
        // pointer to left and pointer to the right
        int leftPtr = start, rightPtr = end - 1;
        // until left and pointers meet
        while (leftPtr < rightPtr) {
            // check if leftPtr element is less than pivot. if yes increment
            // else stop as we have to move the larger element to right
            while (arr[leftPtr] <= arr[pivot] && leftPtr < rightPtr) {
                leftPtr++;
            }
            // check if rightPtr element is greater than pivot. if yes decrement
            // else stop as we have to move the smaller element to left
            while (arr[rightPtr] >= arr[pivot] && leftPtr < rightPtr) {
                rightPtr--;
            }
            // swap the elements in left and right
            int temp = arr[leftPtr];
            arr[leftPtr] = arr[rightPtr];
            arr[rightPtr] = temp;
        }
        // when left and right meet, check if meeting point element is greater than pivot.
        // if yes, swap the pivot with the meeting point, thus making the meeting point as new pivot
        // and elements towards left of pivot are less than pivot
        // and elements towards right of pivot are greater than pivot
        // if no, don't swap, as all elements are towards left side of pivot are smaller than pivot, so return pivot.
        if (arr[leftPtr] > arr[pivot]) {
            int temp = arr[leftPtr];
            arr[leftPtr] = arr[pivot];
            arr[pivot] = temp;
            return leftPtr;
        }
        return pivot;
    }
}