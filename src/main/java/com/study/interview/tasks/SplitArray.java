package com.study.interview.tasks;

/**
 * Given an array of ints, is it possible to divide the ints into two groups,
 * so that the sum of the two groups is the same, with these constraints:
 * all the values that are multiple of 5 must be in one group,
 * and all the values that are a multiple of 3 (and not a multiple of 5) must be in the other.
 * (No loops needed.)
 */
public class SplitArray {

    public boolean isSplittable(int[] nums) {
        return recursive(nums, 0, 0, 0);
    }

    public boolean recursive(int[] nums, int sum5, int sum3, int counter) {
        if (counter > nums.length - 1) {
            System.out.println("End of branch: " + (sum3 == sum5));
            return sum3 == sum5;
        }

        int current = nums[counter];

        //System.out.println(String.format("Beginning state: current %d, sum5 %d, sum3 %d, counter %d", current, sum5, sum3, counter));

        if (current % 5 == 0) {
            sum5 += current;
        } else if (current % 3 == 0) {
            sum3 += current;
        } else {
            System.out.println(String.format("No 5 or 3 state: current %d, sum5 %d, sum3 %d, counter %d", current, sum5, sum3, counter));
            return recursive(nums, sum5 + current, sum3, counter + 1) || recursive(nums, sum5, sum3 + current, counter + 1);
        }

        System.out.println(String.format("5 or 3 state: current %d, sum5 %d, sum3 %d, counter %d", current, sum5, sum3, counter));
        return recursive(nums, sum5, sum3, counter + 1);
    }

    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();

        int[] array = {5, 1, 3, 6, 4, 2, 3};
        int[] array2 = {3, 5, 6, 10, 4, 8, 7, 1, 4, 3, 3};

        System.out.println("Result: " + splitArray.isSplittable(array2));
    }
}
