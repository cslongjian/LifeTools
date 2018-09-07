package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * 有效的数独
 * <p>
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 * ["8","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 */
public class TenQuestion {
    public static void main(String[] args) {

        String[][] board = {{"5", "3", ".", ".", "7", ".", ".", ".", "."}, {"6", ".", ".", "1", "9", "5", ".", ".", "."}, {".", "9", "8", ".", ".", ".", ".", "6", "."}, {"8", ".", ".", ".", "6", ".", ".", ".", "3"}, {"4", ".", ".", "8", ".", "3", ".", ".", "1"}, {"7", ".", ".", ".", "2", ".", ".", ".", "6"}, {".", "6", ".", ".", ".", ".", "2", "8", "."}, {".", ".", ".", "4", "1", "9", ".", ".", "5"}, {".", ".", ".", ".", "8", ".", ".", "7", "9"}};


        System.out.print("结果：" + isValidSudoku(board));

    }

    public static boolean isValidSudoku(String[][] board) {
        // 切分横、竖、方块块。三种判断。三者通过，即可。
        List<List<String>> AllList = new ArrayList<>();
        //横竖
        for (int i = 0; i < 9; i++) {
            List<String> row = new ArrayList<>();
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                row.add(String.valueOf(board[j][i]));
                list.add(String.valueOf(board[i][j]));
            }
            AllList.add(row);
            AllList.add(list);
        }

        //横向方格三组。
        for (int i = 0; i < 3; i++) {
            int rowcount = i % 3;
            List<String> temp = new ArrayList<>();
            for (int row = 0; row < 3; row++) {
                for (int list = 0; list < 3; list++) {
                    temp.add(String.valueOf(board[row][list + rowcount * 3]));
                }
            }
            AllList.add(temp);
        }

        for (int i = 0; i < 3; i++) {
            int rowcount = i % 3;
            List<String> temp = new ArrayList<>();
            for (int row = 0; row < 3; row++) {
                for (int list = 0; list < 3; list++) {
                    temp.add(String.valueOf(board[row + 1 * 3][list + rowcount * 3]));
                }
            }
            AllList.add(temp);
        }


        for (int i = 0; i < 3; i++) {
            int rowcount = i % 3;
            List<String> temp = new ArrayList<>();
            for (int row = 0; row < 3; row++) {
                for (int list = 0; list < 3; list++) {
                    temp.add(String.valueOf(board[row + 2 * 3][list + rowcount * 3]));
                }
            }
            AllList.add(temp);
        }


//        判断27组中。只要不满足条件。返回false,全部通过。返回true;
//        一组数中。不能存在重复。点除外
        for (int i = 0; i < AllList.size(); i++) {
            List<String> tempList = AllList.get(i);


            HashMap tempmap = new HashMap();

            for (int j = 0; j <tempList.size(); j++) {

                if (!tempList.get(j).equals(".")) {

                    if (!tempmap.containsKey(tempList.get(j))) {

                        tempmap.put(tempList.get(j), tempList.get(j));

                    } else {

                        return false;

                    }
                }
            }
        }

        return true;

    }

}
