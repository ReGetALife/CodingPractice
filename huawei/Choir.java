package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * 题目描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 *
 * 说明：
 *
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 *
 *
 *
 * 输入描述:
 * 整数N
 *
 * 输出描述:
 * 最少需要几位同学出列
 *
 * 示例1
 * 输入
 * 复制
 * 8
 * 186 186 150 200 160 130 197 200
 * 输出
 * 复制
 * 4
 */
public class Choir {
    //最长递增子序列问题衍生问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
            int[] lis = new int[n];
            int[] lis2 = new int[n];
            lis(nums, lis, n);
            //反转nums
            reverse(nums);
            lis(nums, lis2, n);
            //反转lis2
            reverse(lis2);
            for (int i = 0; i < n; i++) {
                lis[i] = lis[i] + lis2[i] - 1;//自身重复计算了
            }
            //寻找最大值
            int max = 0;
            for (int i : lis) {
                max = i > max ? i : max;
            }
            System.out.println(n - max);
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
            } else
                stack.set(pos, nums[i]);
            lis[i] = stack.size();
        }
    }
    private static void reverse(int[] nums) {
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
        }
    }
}
