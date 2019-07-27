package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 兔子长两个月，第三个月马上生兔子
 * 输入描述:
 * 输入int型表示month
 *
 * 输出描述:
 * 输出兔子总数int型
 *
 * 示例1
 * 输入
 * 复制
 * 9
 * 输出
 * 复制
 * 34
 */
public class HowManyRabbits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a =0,b=1;
            for (int i = 0; i < n - 1; i++) {
                int c = a+b;
                a=b;
                b=c;
            }
            System.out.println(b);
        }
    }
}
