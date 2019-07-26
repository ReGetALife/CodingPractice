package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 题目描述
 *
 *    Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，不知道为什么？你能替Redraiment研究他最多走的步数吗？
 *
 *
 *
 * 样例输入
 *
 * 6
 *
 * 2 5 1 5 4 5
 *
 *
 *
 * 样例输出
 *
 * 3
 *
 *
 *
 * 提示
 *
 * Example:
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5
 * 从第5格开始走最多有2步,4 5
 *
 * 所以这个结果是3。
 */
public class WalkStub {
    //最长递增子序列问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int[] lis = new int[n];
            lis(nums, lis, n);
            System.out.println(lis[n - 1]);
        }
    }
    //nums是原始序列，lis存放了以每个元素为末尾的最长递增子序列长度
    private static void lis(int[] nums, int[] lis, int n) {
        List<Integer> stack = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int pos = Arrays.binarySearch(stack.toArray(new Integer[0]), nums[i]);
            if (0 > pos) {
                int insertion = -(pos + 1);
                if (insertion < stack.size())
                    stack.set(insertion, nums[i]);
                else stack.add(nums[i]);
            }
            lis[i] = stack.size();
        }
    }
}
