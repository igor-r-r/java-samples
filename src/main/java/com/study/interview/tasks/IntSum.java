package com.study.interview.tasks;

import java.util.Arrays;

public class IntSum {

    public static void main(String[] args) {
        int[][] numsArray = {{3, 3}, {2, 3, 4}, {2, 3, 4, 7, 11, 15}};
        //int[] nums = {2, 7, 3, 11, 15, 4, 8, 12, 76, 1, 3};
        //int[] nums = {3, 3};
        //int[] nums = {3, 2, 4};
        int target = 6;
        for (int[] nums : numsArray) {
            System.out.println(Arrays.toString(twoSumSorted(nums, target)));
        }
    }

    public static int[] twoSum1(int[] nums, int target) {
        // 1. We can use a straightforward approach and loop inside the loop with N^2 complexity

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        // 1. We can sort an array and then use to counters from start and from end to find first target sum

        int[] unsorted = Arrays.copyOf(nums, nums.length);

        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int currentSum = nums[start] + nums[end];
            if (currentSum == target) {
                int index1 = -1;
                int index2 = -1;
                for (int i = 0; i < nums.length; i++) {
                    if (unsorted[i] == nums[start] || unsorted[i] == nums[end]) {
                        if (index1 < 0) {
                            index1 = i;
                        } else if (index2 < 0) {
                            index2 = i;
                        } else {
                            break;
                        }
                    }
                }
                return new int[]{index1, index2};
            } else if (currentSum < target) {
                start++;
            } else {
                end--;
            }
        }

        return null;
    }

    public static int[] twoSumSorted(int[] nums, int target) {
        // 1. We can sort an array and then use to counters from start and from end to find first target sum

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int currentSum = nums[start] + nums[end];
            if (currentSum == target) {
                return new int[]{start, end};
            } else if (currentSum < target) {
                start++;
            } else {
                end--;
            }
        }

        return null;
    }


}
