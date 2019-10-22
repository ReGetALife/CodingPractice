package tk.solidays.algorithm.leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode69 {
    //法一，耗时15ms
    public int mySqrt(int x) {
        long ans = 0;
        while (ans * ans <= x) ans++;
        return (int) (ans - 1);
    }

    //法二：牛顿迭代法求函数零点，耗时1ms
    public int mySqrt2(int x) {
        double ans = x;
        double e = 0.1;
        while (ans * ans - x > e) {
            ans = (ans * ans + x) / (2 * ans);
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        System.out.println(new LeetCode69().mySqrt2(9));
        System.out.println(new LeetCode69().mySqrt2(Integer.MAX_VALUE));
    }
}
