package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 题目描述
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 *
 * 输入描述:
 * int型整数
 *
 * 输出描述:
 * n以内自守数的数量。
 *
 * 示例1
 * 输入
 * 复制
 * 2000
 * 输出
 * 复制
 * 8
 */
public class AutomorphicNum {
    public static void main(String[] args) {
        //十进制的二阶自守数只有5和6结尾的，并且都是成对出现。每对的和等于10^n+1
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = 0;
            for (int i = 0; i <= n; i++) {
                BigInteger bigInteger = BigInteger.valueOf(i);
                if(bigInteger.multiply(bigInteger).toString().endsWith(bigInteger.toString())){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
