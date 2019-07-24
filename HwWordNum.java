package tk.solidays.algorithm;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 * <p>
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 * <p>
 * 示例1
 * 输入
 * ABCDEF
 * A
 * 输出
 * 1
 */
public class HwWordNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().toLowerCase();
        String pattern = scanner.nextLine().toLowerCase();

        //pattern出现在头，split后第一个是空字符串，pattern出现在尾，末尾会忽略。
        String[] strings = string.split(pattern);
        int count = strings.length - 1;
        if (string.endsWith(pattern))
            count++;
        System.out.println(count);
    }
}
