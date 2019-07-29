package tk.solidays.algorithm.leetcode;

/**
 * 给定一个正整数 N，试求有多少组连续正整数满足所有数字之和为 N?
 *
 * 示例 1:
 *
 * 输入: 5
 * 输出: 2
 * 解释: 5 = 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * 示例 2:
 *
 * 输入: 9
 * 输出: 3
 * 解释: 9 = 9 = 4 + 5 = 2 + 3 + 4
 * 示例 3:
 *
 * 输入: 15
 * 输出: 4
 * 解释: 15 = 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * 说明: 1 <= N <= 10 ^ 9
 */
public class LeetCode829 {
    public int consecutiveNumbersSum(int N) {
        long n = N;
        int count = 1;
        //通过(1+n)n/2~N推得
        for (long i = 2; i * i < 4 * n; i++) {
            if (i % 2 == 0) {
                //大于等于0的判断是防止出现负数
                if ((n * 2) % i == 0 && (n % i) != 0 && n / i - (i / 2) >= 0) {
                    count++;
                }
            } else {
                if (n % i == 0 && n / i - (i / 2) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode829().consecutiveNumbersSum(4));
        System.out.println(new LeetCode829().consecutiveNumbersSum(5));
        System.out.println(new LeetCode829().consecutiveNumbersSum(6));
        System.out.println(new LeetCode829().consecutiveNumbersSum(9));
        System.out.println(new LeetCode829().consecutiveNumbersSum(15));
        System.out.println(new LeetCode829().consecutiveNumbersSum(68188380));
        System.out.println(new LeetCode829().consecutiveNumbersSum(933320757));
    }
}
