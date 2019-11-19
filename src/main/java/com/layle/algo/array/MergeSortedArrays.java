package com.layle.algo.array;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p>
 * You may assume that A has enough space to hold additional elements from B. The number of elements initialized
 * in A and B are m and n respectively
 * </p>
 *
 * The key to solve this problem is moving element of A and B backwards. If B has some elements left after A is done,
 * also need to handle that case.
 *
 * The takeaway message from this problem is that the loop condition. This kind of condition is also used for merging
 * two sorted linked list.
 *
 * Created by layle on 2019-06-04.
 */
public class MergeSortedArrays {

    public static void mergeSolution1(int A[], int m, int B[], int n) {

        while (m > 0 && n > 0) {
            if (A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }

        while (n > 0) {
            A[m + n - 1] = B[n - 1];
            n--;
        }
    }

    /**
     * The loop condition also can use m+n like the following
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public static void mergeSolution2(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (k >= 0) {
            if (j < 0 || (i >= 0 && A[i] > B[j]))
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
    }
}
