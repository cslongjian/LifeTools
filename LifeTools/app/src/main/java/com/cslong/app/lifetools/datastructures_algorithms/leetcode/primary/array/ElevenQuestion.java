package com.cslong.app.lifetools.datastructures_algorithms.leetcode.primary.array;


import java.util.ArrayList;
import java.util.List;

/**
 * 旋转图像
 * <p>
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class ElevenQuestion {

    public static void main(String[] args) {

        int[][] testlength = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("int[2][3] length :" + testlength.length);
        System.out.println("int[0][3] length :" + testlength[0].length);

    }

    public static void rotate(int[][] matrix) {

        //获取整个数据
        List<List<Integer>> AllList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                temp.add(matrix[i][j]);
            }
            AllList.add(temp);
        }


        //获取新排序数据
        List<List<Integer>> newList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = matrix.length - 1; j >= 0; j--) {
                temp.add(AllList.get(j).get(i));
            }
            newList.add(temp);
        }

        //进行变换赋值
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = newList.get(i).get(j);
            }
        }


    }
}
