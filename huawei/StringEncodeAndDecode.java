package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。
 *
 * 输入描述:
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 *
 * 输出描述:
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 *
 * 示例1
 * 输入
 * 复制
 * abcdefg
 * BCDEFGH
 * 输出
 * 复制
 * BCDEFGH
 * abcdefg
 */
public class StringEncodeAndDecode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            StringBuilder string1 = new StringBuilder(scanner.nextLine());
            StringBuilder string2 = new StringBuilder(scanner.nextLine());
            //加密
            for (int i = 0; i < string1.length(); i++) {
                char c = string1.charAt(i);
                if (c >= 'a' && c < 'z') {
                    string1.setCharAt(i, (char) (Character.toUpperCase(c) + 1));
                } else if (c >= 'A' && c < 'Z') {
                    string1.setCharAt(i, (char) (Character.toLowerCase(c) + 1));
                } else if (c >= '0' && c < '9') {
                    string1.setCharAt(i, (char) (c + 1));
                } else if (c == 'Z') {
                    string1.setCharAt(i, 'a');
                } else if (c == 'z') {
                    string1.setCharAt(i, 'A');
                } else if (c == '9') {
                    string1.setCharAt(i, '0');
                }
            }
            //解密
            for (int i = 0; i < string2.length(); i++) {
                char c = string2.charAt(i);
                if (c > 'a' && c <= 'z') {
                    string2.setCharAt(i, (char) (Character.toUpperCase(c) - 1));
                } else if (c > 'A' && c <= 'Z') {
                    string2.setCharAt(i, (char) (Character.toLowerCase(c) - 1));
                } else if (c > '0' && c <= '9') {
                    string2.setCharAt(i, (char) (c - 1));
                } else if (c == 'a') {
                    string2.setCharAt(i, 'Z');
                } else if (c == 'A') {
                    string2.setCharAt(i, 'z');
                } else if (c == '0') {
                    string2.setCharAt(i, '9');
                }
            }
            System.out.println(string1);
            System.out.println(string2);
        }
    }
}
