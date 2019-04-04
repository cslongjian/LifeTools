package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.character_string;


//最长公共前缀
//        编写一个函数来查找字符串数组中的最长公共前缀。
//
//        如果不存在公共前缀，返回空字符串 ""。
//
//        示例 1:
//
//        输入: ["flower","flow","flight"]
//        输出: "fl"
//        示例 2:
//
//        输入: ["dog","racecar","car"]
//        输出: ""
//        解释: 输入不存在公共前缀。
//        说明:
//
//        所有输入只包含小写字母 a-z 。


public class NightQuestion {

    public static void main(String[] args) {
        String[] strs = {"flo1wer", "flo1w", "flo1ght"};

        System.out.println(longestCommonPrefix(strs));

    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length < 2) {
            return "";
        } else {
            int headIndex = 0;


            //获取第一个字符。去匹配后面所有的。只要成功。记录往前+1.不成功。结束循环。
            if (strs[0] == "") {
                return "";
            }

            for (int i = 0; i < strs[0].length(); i++) {
                
            }

            char check = strs[0].charAt(headIndex);

            for (int j = 1; j < strs.length; j++) {
                if (strs[j] == "") {
                    return "";
                }
                char check2 = strs[j].charAt(headIndex);
                if (check == check2) {
                    headIndex++;
                } else {
                    break;
                }
            }


            return strs[0].substring(0, headIndex);
        }
    }
}
