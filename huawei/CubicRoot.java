package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 题目描述
 * •计算一个数字的立方根，不使用库函数
 *
 * 详细描述：
 *
 * •接口说明
 *
 * 原型：
 *
 * public static double getCubeRoot(double input)
 *
 * 输入:double 待求解参数
 *
 * 返回值:double  输入参数的立方根，保留一位小数
 *
 *
 * 输入描述:
 * 待求解参数 double类型
 *
 * 输出描述:
 * 输入参数的立方根 也是double类型
 *
 * 示例1
 * 输入
 * 复制
 * 216
 * 输出
 * 复制
 * 6.0
 */
public class CubicRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            double n = scanner.nextDouble();
            double root = 1;
            double e = 0.1;
            while (Math.abs(root * root * root - n) > e) {
                //牛顿迭代法 https://zh.wikipedia.org/wiki/%E7%89%9B%E9%A1%BF%E6%B3%95
                root = (2 * root + n / root / root) / 3;
            }
            System.out.println(BigDecimal.valueOf(root).setScale(1, BigDecimal.ROUND_HALF_UP));
        }
    }
}
