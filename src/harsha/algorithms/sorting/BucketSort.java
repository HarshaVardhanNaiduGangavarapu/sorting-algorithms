package harsha.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author harshavardhannaidugangavarapu
 *
 * This sorting algorithm create a bucket and distribute the elements into buckets based on bucket formula.
 * After that sort the individual buckets using any in-built sorting algorithm like `Collections.sort()`.
 * Finally, merge all the buckets.
 * Bucket formula uses `Maximum element` of the array in formula calculations.
 * <p>
 * Formulas:
 * 1. No. of Buckets = round(sqrt(length of array))
 * 2. Element Bucket No. = (ceil( (element_value * no. of buckets) / Max. element of array))
 * <p>
 * Time Complexity  = O(NLogN)
 * Space Complexity = O(N)
 * <p>
 * ### When to use ###
 * 1. When inputs are uniformly distributed
 * <p>
 * ### When not to use ###
 * 1. Space is a concern
 */

public class BucketSort {
    public static void main(String args[]) {
        int[] arr = {9, 0, 1000, 3, 6, -10, 1, 8, 4, 2, 5, 7, 99};
        bucketSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void bucketSort(int[] arr) {
        int len = arr.length;
        // 1. find the max element
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        // 2. Calculate no. of buckets and create buckets
        int noOfBuckets = (int) Math.round(Math.sqrt(len));
        List<Integer>[] bucketLists = new ArrayList[noOfBuckets];
        for (int i = 0; i < noOfBuckets; i++) {
            bucketLists[i] = new ArrayList<>();
        }

        // 3. populate the elements into buckets
        for (int i = 0; i < len; i++) {
            int elementBucketNo = (int) Math.ceil((arr[i] * noOfBuckets) / maxElement);
            int bucketIndex = elementBucketNo > 0 ? elementBucketNo - 1 : elementBucketNo;
            bucketLists[bucketIndex].add(arr[i]);
        }

        // 4. Sort the buckets elements
        for (List bucket : bucketLists) {
            Collections.sort(bucket);
        }

        // 5. Now copy all sorted elements from buckets into array
        int index = 0;
        for (List<Integer> bucket : bucketLists) {
            for (int element : bucket) {
                arr[index] = element;
                index++;
            }
        }
    }
}
