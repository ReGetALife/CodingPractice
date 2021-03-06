package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * 输入描述:
 * 整数N，后续N个名字
 *
 * 输出描述:
 * 每个名称可能的最大漂亮程度
 *
 * 示例1
 * 输入
 * 复制
 * 2
 * zhangsan
 * lisi
 * 输出
 * 复制
 * 192
 * 101
 */
public class DegreeOfBeautyOfName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                int[] ascii = new int[128];
                for (int j = 0; j < s.length(); j++) {
                    ascii[s.charAt(j)]++;
                }
                Arrays.sort(ascii);
                int beautyDegree = 0;
                for (int j = 127, degree = 26; j >= 0; j--, degree--) {
                    if (ascii[j] == 0)
                        break;
                    beautyDegree += (ascii[j] * degree);
                }
                System.out.println(beautyDegree);
            }
        }
    }
}
