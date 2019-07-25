package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
 *
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 首先输入一个整数，为要输入的字符串个数。
 *
 * 例如：
 *
 * 输入：2
 *
 *       abc
 *
 *       12345789
 *
 * 输出：abc00000
 *
 *       12345678
 *
 *       90000000
 */
public class SplitString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < n; j++) {
                String string = scanner.nextLine();
                int len = string.length();
                for (int i = 0; i < len; i += 8) {
                    if (i + 8 < len)
                        System.out.println(string.substring(i, i + 8));
                    else {
                        StringBuilder stringBuilder = new StringBuilder("00000000");
                        stringBuilder.replace(0, string.substring(i).length(), string.substring(i));
                        System.out.println(stringBuilder);
                    }
                }
            }
        }
    }
}
