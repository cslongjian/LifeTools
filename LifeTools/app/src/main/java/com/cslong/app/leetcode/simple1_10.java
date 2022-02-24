package com.cslong.app.leetcode;


import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//leadcode 1-10简单题
public class simple1_10 {


}

//两数之和
class tip1 {
    //1 两数之和
    //限定条件。nums >=2

    //    暴力解法 两组for循环。时间复杂度n2
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //    优化解法。使用map存储key value  时间复杂度o(n)
    //  把值存起来作为KEY index作为value  通过Key 找value  找到对应的index.
    public static int[] twoSum2(int[] nums, int target) {
        // map实例化
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (maps.containsKey(value) && maps.get(value) != i) {
                return new int[]{i, maps.get(value)};
            }
        }

        return null;
    }


    //    最优解决  直接边存边查。节约空间和时间
    public int[] twoSumb(int[] nums, int target) {
        Map<Integer, Integer> aMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (aMap.containsKey(target - nums[i])) {
                return new int[]{aMap.get(target - nums[i]), i};
            }
            aMap.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }


}


//9. 回文数
//    给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
//        回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
//        例如，121 是回文，而 123 不是。
class tip2 {

    //数组反取值对比。
    public boolean isPalindrome(int x) {
        if (x >= 0) {
            char[] rome = String.valueOf(x).toCharArray();
            for (int i = 0; i < rome.length / 2; i++) {
                int end = rome.length - i - 1;
                if (rome[i] != rome[end]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //最简洁答案
    public boolean simple(int x) {
        return new StringBuffer(x + "").reverse().toString().equals(x + "");

    }

    //    对数结构的理解
    public boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        int y = 0;
        int b = x;
        while (x != 0) {
            int a = x % 10;
            y = y * 10 + a;
            x = x / 10;
        }
        return y == b;
    }


}




