package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.array;


/**
 * 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class SevenQuestion {

    public static void main(String[] args) {

    }


    //    冒泡排序。先排序好，再对最后一个进行操作

    public int[] plusOne(int[] digits) {

//        if (digits.length < 0) {
//            return null;
//        }
//
//        int[] arr = digits;
//
//
//        for (int i = 0; i < arr.length - 1; i++) {//外层循环控制排序趟数
//            for (int j = 0; j < arr.length - 1 - i; j++) {//内层循环控制每一趟排序多少次
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//
//        int[] tem = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            tem[i] = arr[arr.length - 1 - i];
//        }
//
//        tem[tem.length - 1] = tem[tem.length - 1] + 1;
//
//        return tem;

        //    理解错误，不需要排序。就是数字加一。然后返回对应数组。有可能遇到进一位情况需考虑

        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            //对应9进一位情况处理。
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        //全是9的情况。
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;


    }


}
