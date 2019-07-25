package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入
 * 复制
 * 5.5
 * 输出
 * 复制
 * 6
 */
public class HwRoundFloat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(in));
        while (scanner.hasNext()) {
            float n = scanner.nextFloat();
            System.out.println(Math.round(n));
        }
    }
}
