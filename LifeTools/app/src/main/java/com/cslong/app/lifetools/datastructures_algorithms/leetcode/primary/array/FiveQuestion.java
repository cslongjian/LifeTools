package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.array;

import java.util.Arrays;

/**
 * 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class FiveQuestion {


    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 3, 6, 6, 5};

        System.out.println(singleNumber(nums));


    }

    public static int singleNumber(int[] nums) {

        if (nums.length > 0) {
            Arrays.sort(nums);

            int count = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (i % 2 == 1) {
                    count = count - nums[i];
                } else {
                    count = count + nums[i];
                }
            }

            return count;
        } else {
            return 0;
        }


    }

    //这是一种比较简便的解答方式。 更高效的请看下班，使用异或处理。

    public static int singleNumber2(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int aA : A) {
            rst ^= aA;
        }
        return rst;
    }


}



