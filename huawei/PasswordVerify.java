package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 密码要求:
 *
 *
 *
 *
 *
 *
 *
 * 1.长度超过8位
 *
 *
 *
 *
 *
 *
 *
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 *
 *
 *
 *
 *
 *
 *
 * 3.不能有相同长度超2的子串重复
 *
 *
 *
 *
 *
 *
 *
 * 说明:长度超过2的子串
 *
 *
 * 输入描述:
 * 一组或多组长度超过2的子符串。每组占一行
 *
 * 输出描述:
 * 如果符合要求输出：OK，否则输出NG
 *
 * 示例1
 * 输入
 * 复制
 * 021Abc9000
 * 021Abc9Abc1
 * 021ABC9000
 * 021$bc9000
 * 输出
 * 复制
 * OK
 * NG
 * NG
 * OK
 */
public class PasswordVerify {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            int upper = 0;
            int lower = 0;
            int number = 0;
            int other = 0;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i + 3 <= s.length() && s.lastIndexOf(s.substring(i, i + 3)) != i) {
                    count = 0;
                    break;
                }
                if (c >= 'A' && c <= 'Z') {
                    if(upper == 0){
                        upper = 1;
                        count++;
                    }
                } else if (c >= 'a' && c <= 'z') {
                    if(lower == 0){
                        lower = 1;
                        count++;
                    }
                } else if (c >= '0' && c <= '9') {
                    if(number == 0){
                        number = 1;
                        count++;
                    }
                } else if (other == 0) {
                    other = 1;
                    count++;
                }
            }
            if (count < 3) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }
}
