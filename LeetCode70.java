package tk.solidays.algorithm;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        if (n == 1 || n == 0)
            return 1;
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 2;
        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }
    //升级版，只需要记住前两个就好了
    public int climbStairsPro(int n) {
        if (n == 1 || n == 0)
            return 1;
        int a1 = 1;
        int a2 = 2;
        int a3 = 2;
        for (int i = 2; i < n; i++) {
            a3=a1+a2;
            a1=a2;
            a2=a3;
        }
        return a3;
    }
}
