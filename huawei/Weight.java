package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目描述
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 *
 *
 * 注：
 *
 * 称重重量包括0
 *
 *
 * 方法原型：public static int fama(int n, int[] weight, int[] nums)
 *
 *
 * 输入描述:
 * 输入包含多组测试数据。
 *
 * 对于每组测试数据：
 *
 * 第一行：n --- 砝码数(范围[1,10])
 *
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 *
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 * 输出描述:
 * 利用给定的砝码可以称出的不同的重量数
 *
 * 示例1
 * 输入
 * 复制
 * 2
 * 1 2
 * 2 1
 * 输出
 * 复制
 * 5
 */
public class Weight {
    //求集合的全部子集的衍生问题，此处采用迭代法
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] weights =new int[n];
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                weights[i]=scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                nums[i]=scanner.nextInt();
            }
            //不需要记录所有集合，并且不同砝码集合可能具有一样重量，可等效处理
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < nums[i]; j++) {
                    Set<Integer> newSet = new HashSet<>();
                    for (Integer e:set){
                        newSet.add(e+weights[i]);
                    }
                    set.addAll(newSet);
                }
            }
            System.out.println(set.size());
        }
    }
}
