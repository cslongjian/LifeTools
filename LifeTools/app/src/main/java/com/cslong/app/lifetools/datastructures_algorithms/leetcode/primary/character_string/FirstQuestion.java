package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.character_string;

/**
 * 反转字符串
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "olleh"
 * 示例 2:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 */
public class FirstQuestion {
    public static void main(String[] args) {

        reverseString("hello");

    }

    public static String reverseString(String s) {


        char[] chars = s.toCharArray();


        for (int i = 0; i < chars.length/2; i++) {
            if (!(i == chars.length - i - 1)) {
                char temp = chars[i];
                chars[i] = chars[chars.length - i - 1];
                chars[chars.length - i - 1] = temp;
            }
        }

        return String.valueOf(chars);


    }

    //优化版本。同样是变换。使用半截。效率高
    public static String reverseString2(String s) {

        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

}
