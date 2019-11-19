package com.layle.algo.array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * Created by layle on 2019-06-06.
 */
public class MaximumSubArray {
    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5, 4};

        System.out.println("Maximum sum of [-2,1,-3,4,-1,2,1,-5, 4]: " + maxSubArraySolution1(a));
    }

    /**
     * The easiest way to formulate the solution of this problem is using DP. Let f(n) be the maximum subarray for an
     * array with n elements. We need to find the subproblem and the relation.
     *
     * f(n) = { f(n-1)>0 ? f(n-1) : 0 } + nums[n-1]
     * f(0) = 0
     * f(1) = nums[0]
     *
     * The changing condition for dynamic programming is "We should ignore the sum of the previous n-1 elements if
     * nth element is greater than the sum."
     *
     * @param nums
     * @return
     */
    public static int maxSubArraySolution1(int[] nums) {
        int result = nums[0];
        int[] sum =  new int[nums.length];
        sum[0] = nums[0];

        for(int i=1; i<nums.length; i++){
            sum[i] = Math.max(nums[i], sum[i-1] + nums[i]);
            result = Math.max(result, sum[i]);
        }

        return result;
    }

    /**
     * The time complexity and space complexity are the same O(n). However, we can improve the space complexity
     * and make it to be O(1).
     * @param nums
     * @return
     */
    public static int maxSubArraySolution2(int[] nums) {
        int result = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++){
            sum = Math.max(nums[i], sum + nums[i]);
            result = Math.max(result, sum);
        }

        return result;
    }
}
