package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
 *
 * 接口说明
 *
 * 原型：
 *
 * void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag);
 *
 * 输入参数：
 *
 * Integer[] pIntegerArray：整型数组
 *
 * int  iSortFlag：排序标识：0表示按升序，1表示按降序
 *
 * 输出参数：
 *
 * 无
 *
 * 返回值：
 *
 * void
 *
 *
 * 输入描述:
 * 1、输入需要输入的整型数个数
 *
 * 输出描述:
 * 输出排好序的数字
 *
 * 示例1
 * 输入
 * 复制
 * 8
 * 1 2 4 9 3 55 64 25
 * 0
 * 输出
 * 复制
 * 1 2 3 4 9 25 55 64
 */
public class SortNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);
            StringBuilder sb = new StringBuilder();
            if (scanner.nextInt() == 0) {
                for (int i = 0; i < n; i++) {
                    sb.append(nums[i]).append(" ");
                }
            } else {
                for (int i = n - 1; i >= 0; i--)
                    sb.append(nums[i]).append(" ");
            }
            sb.replace(sb.length() - 1, sb.length(), "");
            System.out.println(sb);
        }
    }
}
