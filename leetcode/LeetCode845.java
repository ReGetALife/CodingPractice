package tk.solidays.algorithm.leetcode;


/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 *
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 *
 * 提示：
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * [0,1,2,3,4,5,6,7,8,9]
 * [2,1,4,7,3,2,5]
 */
public class LeetCode845 {
    public int longestMountain(int[] A) {
        int count = 1;
        int max = 0;
        boolean flag = true;//true表示升
        for (int i = 1; i < A.length; i++) {
            if (flag && A[i] > A[i - 1]) {
                count++;
            } else if ((!flag) && A[i] < A[i - 1]) {
                count++;
            } else if (flag && A[i] < A[i - 1] && count > 1) {//改为降,考虑一开始就降是不行的
                flag = false;
                count++;
            } else if ((!flag) && A[i] > A[i - 1]) {
                if (count >= 3)
                    max = count > max ? count : max;
                count = 2;
                flag = true;
            }
            if ((!flag) && i == A.length - 1)
                if (count >= 3)
                    max = count > max ? count : max;
            if (A[i] == A[i - 1]) {//相等也不行
                if (count >= 3)
                    max = count > max ? count : max;
                count = 1;
                flag = true;
            }
        }
        return max;
    }
}
