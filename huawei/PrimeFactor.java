package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 *
 * 详细描述：
 *
 *
 * 函数接口说明：
 *
 * public String getResult(long ulDataInput)
 *
 * 输入参数：
 *
 * long ulDataInput：输入的正整数
 *
 * 返回值：
 *
 * String
 *
 *
 *
 * 输入描述:
 * 输入一个long型整数
 *
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 * 示例1
 * 输入
 * 复制
 * 180
 * 输出
 * 复制
 * 2 2 3 3 5
 */
public class PrimeFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(in));
        while (scanner.hasNext()) {
            long n = scanner.nextLong();
            if (n == 1)
                System.out.println(1);
            int index = 2;
            while (n != 1) {
                for (int i = index; ; i++) {
                    if (n % i == 0) {
                        System.out.print(i + " ");
                        n /= i;
                        index = i;
                        break;
                    } else if (i > Math.sqrt(n)) {
                        System.out.print(n + " ");
                        n = 1;
                        break;
                    }
                }
            }
        }
    }
}
