package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.array;


/**
 * 两数之和
 * <p>
 * <p>
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * <p>
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */


public class NineQuestion {

    public static void main(String[] args) {

    }


    public static int[] twoSum(int[] nums, int target) {

        int[] result = {0, 0};
        if (nums.length > 2) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int count = nums[i] + nums[j];
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }

        }


        return result;
    }

    //最简便的是使用hashmap 配对思路。。直接索引，效率最高。
}
