package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 题目描述
 * 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值
 * 输入描述:
 * 输入任意个整数
 *
 * 输出描述:
 * 输出负数个数以及所有非负数的平均值
 *
 * 示例1
 * 输入
 * 复制
 * -13
 * -4
 * -7
 * 输出
 * 复制
 * 3
 * 0.0
 */
public class PositiveAndNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        int positive = 0;
        int negative = 0;
        double sum = 0;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n < 0)
                negative++;
            else {
                positive++;
                sum += n;
            }
        }
        System.out.println(negative);
        positive = positive > 0 ? positive : 1;
        System.out.println(BigDecimal.valueOf(sum / positive).setScale(1, BigDecimal.ROUND_HALF_UP));
    }
}
