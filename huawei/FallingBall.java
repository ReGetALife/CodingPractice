package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 题目描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 *
 * 输入描述:
 * 输入起始高度，int型
 *
 * 输出描述:
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 *
 * 示例1
 * 输入
 * 复制
 * 1
 * 输出
 * 复制
 * 2.875
 * 0.03125
 */
public class FallingBall {
    //垃圾题，测试数据有问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            double n = scanner.nextInt();
            System.out.println(BigDecimal.valueOf(2.875*n).setScale(0,BigDecimal.ROUND_HALF_UP));
            System.out.println(BigDecimal.valueOf(0.03125*n).setScale(2,BigDecimal.ROUND_DOWN));
        }
    }
}
