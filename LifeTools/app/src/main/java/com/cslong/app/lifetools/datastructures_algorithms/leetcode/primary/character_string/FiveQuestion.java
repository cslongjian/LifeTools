package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.character_string;


/**
 * 验证回文字符串
 * <p>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 * <p>
 * <p>
 * <p>
 * 一开始没看明白题目，找了网上相关讲解
 * <p>
 * 验证回文字符串是比较常见的问题，所谓回文，就是一个正读和反读都一样的字符串，
 * 比如“level”或者“noon”等等就是回文串。但是这里，加入了空格和非字母数字的字符，
 * 增加了些难度，但其实原理还是很简单：只需要建立两个指针，left和right,
 * 分别从字符的开头和结尾处开始遍历整个字符串，如果遇到非字母数字的字符就跳过，
 * 继续往下找，直到找到下一个字母数字或者结束遍历，如果遇到大写字母，就将其转为小写。
 * 等左右指针都找到字母数字时，比较这两个字符，若相等，则继续比较下面两个分别找到的字母数字，
 * 若不相等，直接返回false.
 * <p>
 * <p>
 * 时间复杂度为O(n),
 */
public class FiveQuestion {
    public static void main(String[] args) {

        String sss = "A man, a plan, a canal: Panama";

        isPalindrome(sss);

    }

    public static boolean isPalindrome(String s) {

        //这里没必要分组再过滤了。
//        String newString = s.toLowerCase();
//        String[] s1 = newString.split(" ");
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = 0; i < s1.length; i++) {
//            char[] chars = s1[i].toCharArray();
//            for (int j = 0; j < chars.length; j++) {
//                if (chars[j] >= 'a' && chars[j] <= 'z')
//                {
//                    stringBuffer = stringBuffer.append(chars[j]);
//                }
//            }
//        }


        String lowString = s.toLowerCase();
        char[] chars = lowString.toCharArray();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                stringBuffer2 = stringBuffer2.append(chars[i]);
            }

            if (chars[i] >= '0' && chars[i] <= '9') {
                stringBuffer2 = stringBuffer2.append(chars[i]);
            }
        }

        int length = stringBuffer2.length();
        for (int i = 0; i < length / 2; i++) {
            if (stringBuffer2.charAt(i) != stringBuffer2.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    //所谓的搞笑方法。也是利用isLetterOrDigit 方法。判断是否符合规定限定的范围。然后单独对比。
    /**
     * 也是利用isLetterOrDigit
     * 类型：System.Char
     * 要计算的 Unicode 字符。
     * 返回值
     * 类型：System.Boolean
     * 如果 c 是字母或十进制数字，则为 true；否则为 false。
     *
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        if (s.length() == 0 || s.isEmpty()) return true;
        String str = s.toUpperCase();
        int head = 0, tail = str.length() - 1;
        char cHead, cTail;
        while (head <= tail) {
            cHead = str.charAt(head);
            cTail = str.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (cHead != cTail) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

}
