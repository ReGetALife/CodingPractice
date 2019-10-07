package tk.solidays.algorithm.leetcode;

/**
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 * <p>
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * <p>
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 1：
 * <p>
 * 输入: tasks = ["A","A","A","B","B","B"], n = 2
 * 输出: 8
 * 执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 注：
 * <p>
 * 任务的总个数为 [1, 10000]。
 * n 的取值范围为 [0, 100]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
// 优先考虑出现次数最多的字母，有间隙的情况下，完成任务的时间至少为(max - 1) * (n + 1) + count;
// 假如出现次数最多的字母有许多个，把长度n区间内的空隙都填满了，抑或是出现次数较少的字母很多，
// 也把空隙填满了，我们可以在原先填满的任意位置拉开距离腾出空位，插入字母，且这种操作不会让相同字母的间距变小
// 也就是安全的。于是这种情况将不会有空隙出现，时间为字母个数。
// 执行用时 : 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
public class LeetCode621 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        //计数
        for (char task : tasks) map[task - 'A']++;
        //找最大的个数
        int max = 0;
        int count = 0;
        for (int i : map) {
            if (i > max) {
                max = i;
                count = 1;
            } else if (i == max) {
                count++;
            }
        }
        int ans = (max - 1) * (n + 1) + count;
        return ans < tasks.length ? tasks.length : ans;
    }
}
