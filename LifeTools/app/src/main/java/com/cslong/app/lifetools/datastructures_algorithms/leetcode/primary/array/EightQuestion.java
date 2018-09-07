package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.array;

/**
 * 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class EightQuestion {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes(nums);


    }


    public static void moveZeroes(int[] nums) {
        if (nums.length > 0) {
            int length = nums.length;
            for (int i = length; i >= 0; i--) {
                for (int j = i; j < length; j++) {
                    if (nums[j] == 0) {
                        int temp = nums[j];
                        if (j < length - 1) {
                            if (nums[j + 1] == 0) {
                                continue;
                            }
                            nums[j] = nums[j + 1];
                            nums[j + 1] = temp;
                        }
                    } else {
                        break;
                    }
                }
            }

            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
            }
        }
    }

}
