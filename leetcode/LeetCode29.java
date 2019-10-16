package tk.solidays.algorithm.leetcode;

import tk.solidays.learn.TestConstantPool;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 2147483647
 * 3
 */
public class LeetCode29 {
    //耗时1ms
    public int divide(int dividend, int divisor) {
        //换成负数可表示范围更大
        int a = -Math.abs(dividend);
        int b = -Math.abs(divisor);
        int ans = 0;
        while (a <= b) {
            int t = -1;
            int o = b;
            //后面两个判断是为了防止o不断左移仍大于a从而死循环
            while ((o << 1) >= a && o > (Integer.MIN_VALUE >> 1) && (o << 1) > (Integer.MIN_VALUE >> 1)) {
                o <<= 1;
                t <<= 1;
            }
            a -= o;
            ans += t;
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) return ans;
        if (ans == Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return -ans;
    }

    public static void main(String[] args) {
        LeetCode29 leetCode29 = new LeetCode29();
        System.out.println(leetCode29.divide(-8, 3));
        System.out.println(leetCode29.divide(-10, 1));
        System.out.println(leetCode29.divide(-0, 1));
        System.out.println(leetCode29.divide(Integer.MIN_VALUE, -1));
        System.out.println(leetCode29.divide(Integer.MIN_VALUE, 1));
        System.out.println(leetCode29.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
        System.out.println(leetCode29.divide(Integer.MIN_VALUE + 1000, Integer.MIN_VALUE + 100));
        System.out.println(leetCode29.divide(2147483647, 3));
    }
}

