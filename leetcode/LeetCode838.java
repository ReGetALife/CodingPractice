package tk.solidays.algorithm.leetcode;

/**
 * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
 *
 * 在开始时，我们同时把一些多米诺骨牌向左或向右推。
 *
 *
 *
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
 *
 * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *
 * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
 *
 * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 *
 * 返回表示最终状态的字符串。
 *
 * 示例 1：
 *
 * 输入：".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 * 示例 2：
 *
 * 输入："RR.L"
 * 输出："RR.L"
 * 说明：第一张多米诺骨牌没有给第二张施加额外的力。
 * 提示：
 *
 * 0 <= N <= 10^5
 * 表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.';
 */
public class LeetCode838 {
    public String pushDominoes(String dominoes) {
        int[] left = new int[dominoes.length()];//从右往左，模拟向左推
        int[] right = new int[dominoes.length()];
        int count = -1;
        for (int i = dominoes.length() - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                count = 0;
            } else if (dominoes.charAt(i) == '.' && count >= 0) {
                count++;
                left[i] = count;
            } else if (dominoes.charAt(i) == 'R') {
                count = -1;
            }
        }
        count = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) == 'R') {
                count = 0;
            } else if (dominoes.charAt(i) == '.' && count >= 0) {
                count++;
                right[i] = count;
            } else if (dominoes.charAt(i) == 'L') {
                count = -1;
            }
        }
        //比较两个数组
        StringBuilder sb = new StringBuilder(dominoes);
        for (int i = 0; i < dominoes.length(); i++) {
            if (right[i] == 0 && left[i] != 0)
                sb.setCharAt(i, 'L');
            else if (right[i] != 0 && left[i] == 0)
                sb.setCharAt(i, 'R');
            else if (left[i] < right[i])
                sb.setCharAt(i, 'L');
            else if (left[i] > right[i])
                sb.setCharAt(i, 'R');
        }
        return sb.toString();
    }
}
