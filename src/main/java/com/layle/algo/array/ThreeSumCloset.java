package com.layle.algo.array;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Created by layle on 2019-06-04.
 */
public class ThreeSumCloset {
    /**
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     * @param args
     */
    public static void main(String[] args) {
        int[] a = {-1, 2, 1, -4};
        System.out.println("3Sum Closet for {-1, 2, 1, -4}, target 2: " + threeSumClosest(a, 2));
        System.out.println("3Sum Closet for {-1, 2, 1, -4}, target 3: " + threeSumClosest(a, 3));
    }
    /**
     * This problem is similar to 2 Sum. This kind of problem can be solved by using a similar approach, i.e.,
     * two pointers from both left and right.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if(diff == 0) return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }
}
