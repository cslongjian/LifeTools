package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.character_string;


/**
 * 颠倒整数
 * <p>
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class SecondQuestion {

    public static void main(String[] args) {

//        System.out.println(String.valueOf(new StringBuffer(12).reverse().toString()));

        System.out.println(String.valueOf(reverse(-123)));


    }

    public static int reverse(int x) {

        if (x == 0) {
            return 0;
        }

        if (x > 0) {
            String num = String.valueOf(x);
            char[] nums = num.toCharArray();
            for (int i = 0; i < nums.length / 2; i++) {
                if (!(i == nums.length - i - 1)) {
                    char temp = nums[i];
                    nums[i] = nums[nums.length - i - 1];
                    nums[nums.length - i - 1] = temp;
                }
            }
            num = String.valueOf(nums);

            try {
                int reverseNum = Integer.parseInt(num);
                if (reverseNum < Integer.MAX_VALUE) {
                    return reverseNum;
                } else {
                    return 0;
                }
            } catch (Exception e) {
                return 0;
            }


        } else {
            x = -x;
            String num = String.valueOf(x);

            char[] nums = num.toCharArray();
            for (int i = 0; i < nums.length / 2; i++) {
                if (!(i == nums.length - i - 1)) {
                    char temp = nums[i];
                    nums[i] = nums[nums.length - i - 1];
                    nums[nums.length - i - 1] = temp;
                }
            }
            num = String.valueOf(nums);
            try {
                int reverseNum = Integer.valueOf(num).intValue();
                reverseNum = -reverseNum;
                if (reverseNum > Integer.MIN_VALUE) {
                    return reverseNum;
                } else {
                    return 0;
                }
            } catch (Exception e) {
                return 0;
            }
        }
    }

    //搞笑简洁方法.用求雨的方法，针对每一位数进行操作。
    public int reverse2(int x) {
        long res = 0;
        for(;x!=0;x/=10){
            res = res*10 + x%10;
        }
        return res>Integer.MAX_VALUE || res<Integer.MIN_VALUE ? 0 : (int) res;

    }

}
