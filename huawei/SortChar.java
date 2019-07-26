package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 *
 *
 *
 *
 * 输入描述:
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 *
 * 输出描述:
 * Lily的所有图片按照从小到大的顺序输出
 *
 * 示例1
 * 输入
 * 复制
 * Ihave1nose2hands10fingers
 * 输出
 * 复制
 * 0112Iaadeeefghhinnnorsssv
 */
public class SortChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            System.out.println(new String(chars));
        }
    }
}
