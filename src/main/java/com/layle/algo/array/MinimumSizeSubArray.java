package com.layle.algo.array;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the
 * sum ≥ s. If there isn't one, return 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2 under the
 * problem constraint.
 *
 * Created by layle on 2019-06-06.
 */
public class MinimumSizeSubArray {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 2, 4, 3};
        System.out.println("Minimum sub array size of [2,3,1,2,4,3], s=7: " + minSubArrayLen(7, a));
    }

    /**
     * We can use 2 points to mark the left and right boundaries of the sliding window.
     * When the sum is greater than the target, shift the left pointer; when the sum is less than the target,
     * shift the right pointer.
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        int i=0;
        int j=0;
        int sum=0;

        int minLen = Integer.MAX_VALUE;

        while(j<nums.length){
            if(sum<s){
                sum += nums[j];
                j++;
            }else{
                minLen = Math.min(minLen, j-i);
                if(i==j-1)
                    return 1;

                sum -=nums[i];
                i++;
            }
        }

        while(sum>=s){
            minLen = Math.min(minLen, j-i);

            sum -=nums[i++];
        }

        return minLen==Integer.MAX_VALUE? 0: minLen;
    }
}
