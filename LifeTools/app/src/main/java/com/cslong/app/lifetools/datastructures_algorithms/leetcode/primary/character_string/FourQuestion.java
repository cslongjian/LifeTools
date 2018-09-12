package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.character_string;


import java.util.HashMap;

/**
 * 有效的字母异位词
 * <p>
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * <p>
 * 有找相同子集的方法累屎。与array中的第六题，相近。核心可以使用字符的lastIndexof 方法
 */
public class FourQuestion {

    public static void main(String[] args) {
//        1 a ab
//        2 aacc  ccac
    }

    //这种解法，无法处理2 情况。可以废弃了。
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] checkList = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (t.lastIndexOf(checkList[i]) == -1) {
                return false;
            }
        }
        return true;
    }


//    用表对比处理
    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] checkList = s.toCharArray();
        char[] reCheckList = t.toCharArray();
        HashMap map = new HashMap();
        //添加到map
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(checkList[i])) {
                int count = (Integer) map.get(checkList[i]);
                map.put(checkList[i], count + 1);
            } else {
                map.put(checkList[i], 1);
            }
        }

        //做减法，等于0 移除。不在表内，添加到成-1 。做最后判断处理
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(reCheckList[i])) {
                int count = (Integer) map.get(reCheckList[i]);
                count = count - 1;
                if (count == 0) {
                    map.remove(reCheckList[i]);
                } else {
                    map.put(reCheckList[i], count);
                }

            } else {
//                map.put(reCheckList[i], -1);
                return false;
            }
        }

        if (map.size()>0)
        {
            return false;
        }


        return true;
    }

//    搞笑做法 其实也是对字符做匹配处理.限定在26个字母中进行.
    public boolean isAnagram3(String s, String t) {
        char[] chars = new char[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            chars[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }

//    总结:思路基本一致.可以扩展到限定内容.针对字符操作加减可以得到固定的值.限定好了范围.再遍历检查;

}
