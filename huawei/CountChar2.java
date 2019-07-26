package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入描述:
 * 输入一串字符。
 * <p>
 * 输出描述:
 * 对字符中的
 * 各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
 * <p>
 * 示例1
 * 输入
 * 复制
 * aadddccddc
 * 输出
 * 复制
 * dca
 */
public class CountChar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            MyChar[] count = new MyChar[128];
            for (int i = 0; i < 128; i++) {
                count[i] = new MyChar();
                count[i].k = i;
            }
            String s = scanner.nextLine();
            for (int i = 0; i < s.length(); i++) {
                count[s.charAt(i)].count++;
            }
            Arrays.parallelSort(count);//降序
            for (int i = 0; i < count.length; i++) {
                if (count[i].count > 0)
                    System.out.print((char) count[i].k);
            }
            System.out.print("\n");
        }
    }
}
class MyChar implements Comparable<MyChar> {
    int k;
    int count;
    @Override
    public int compareTo(MyChar o) {
        return o.count - count;
    }

}