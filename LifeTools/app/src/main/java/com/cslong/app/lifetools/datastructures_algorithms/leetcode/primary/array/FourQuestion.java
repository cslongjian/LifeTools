package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.array;


import java.util.HashMap;

/**
 * 存在重复
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class FourQuestion {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};

        System.out.println(containsDuplicate(nums));


    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums.length > 0) {
            HashMap map = new HashMap();

            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], nums[i]);
                } else {
                    return true;
                }
            }
            return false;
        }
        return false;
    }


}
