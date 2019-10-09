package tk.solidays.algorithm.leetcode;

import java.util.*;

/**
 * 力扣决定给一个刷题团队发LeetCoin作为奖励。同时，为了监控给大家发了多少LeetCoin，力扣有时候也会进行查询。
 * <p>
 *  
 * <p>
 * 该刷题团队的管理模式可以用一棵树表示：
 * <p>
 * 团队只有一个负责人，编号为1。除了该负责人外，每个人有且仅有一个领导（负责人没有领导）；
 * 不存在循环管理的情况，如A管理B，B管理C，C管理A。
 *  
 * <p>
 * 力扣想进行的操作有以下三种：
 * <p>
 * 给团队的一个成员（也可以是负责人）发一定数量的LeetCoin；
 * 给团队的一个成员（也可以是负责人），以及他/她管理的所有人（即他/她的下属、他/她下属的下属，……），发一定数量的LeetCoin；
 * 查询某一个成员（也可以是负责人），以及他/她管理的所有人被发到的LeetCoin之和。
 *  
 * <p>
 * 输入：
 * <p>
 * N表示团队成员的个数（编号为1～N，负责人为1）；
 * leadership是大小为(N - 1) * 2的二维数组，其中每个元素[a, b]代表b是a的下属；
 * operations是一个长度为Q的二维数组，代表以时间排序的操作，格式如下：
 * operations[i][0] = 1: 代表第一种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
 * operations[i][0] = 2: 代表第二种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
 * operations[i][0] = 3: 代表第三种操作，operations[i][1]代表成员的编号；
 * 输出：
 * <p>
 * 返回一个数组，数组里是每次查询的返回值（发LeetCoin的操作不需要任何返回值）。由于发的LeetCoin很多，请把每次查询的结果模1e9+7 (1000000007)。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：N = 6, leadership = [[1, 2], [1, 6], [2, 3], [2, 5], [1, 4]], operations = [[1, 1, 500], [2, 2, 50], [3, 1], [2, 6, 15], [3, 1]]
 * 输出：[650, 665]
 * 解释：团队的管理关系见下图。
 * 第一次查询时，每个成员得到的LeetCoin的数量分别为（按编号顺序）：500, 50, 50, 0, 50, 0;
 * 第二次查询时，每个成员得到的LeetCoin的数量分别为（按编号顺序）：500, 50, 50, 0, 50, 15.
 * <p>
 * <p>
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= N <= 50000
 * 1 <= Q <= 50000
 * operations[i][0] != 3 时，1 <= operations[i][2] <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-bonus
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCodeLCP5 {
    private Val[] map;

    class Val {
        public int sum;
        public int parent = 0;
        public List<Integer> sub;

        public Val(int sum, List<Integer> sub, int parent) {
            this.sub = sub;
            this.sum = sum;
            this.parent = parent;
        }
    }

    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        //将树存在map中
        map = new Val[n + 1];
        for (int[] ints : leadership) {
            if (map[ints[0]] != null) {
                map[ints[0]].sub.add(ints[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(ints[1]);
                map[ints[0]] = new Val(0, list, 0);
            }
            if (map[ints[1]] != null) {
                map[ints[1]].parent = ints[0];
            } else {
                map[ints[1]] = new Val(0, new ArrayList<>(), ints[0]);
            }
        }
        //执行操作
        List<Integer> ans = new ArrayList<>();
        for (int[] operation : operations) {
            if (operation[0] == 1) {
                Val person = map[operation[1]];
                person.sum += operation[2];
                person.sum %= 1000000007;
                while (person.parent != 0) {
                    person = map[person.parent];
                    person.sum += operation[2];
                    person.sum %= 1000000007;
                }
            } else if (operation[0] == 2) {
                int increase = batch(operation[1], operation[2]);
                Val person = map[operation[1]];
                while (person.parent != 0) {
                    person = map[person.parent];
                    person.sum += increase;
                    person.sum %= 1000000007;
                }
            } else if (operation[0] == 3) {
                ans.add(map[operation[1]].sum);
            }
        }
        return ans.stream().mapToInt((Integer i) -> i).toArray();
    }

    private int batch(int current, int val) {
        Val person = map[current];
        int increase = val;
        if (person.sub.size() > 0) {
            List<Integer> list = person.sub;
            for (Integer i : list) {
                increase += batch(i, val);
            }
        }
        person.sum += increase;
        person.sum %= 1000000007;
        return increase;
    }

    public static void main(String[] args) {
        int[][] leadership = new int[][]{{1, 2}, {1, 6}, {2, 3}, {2, 5}, {1, 4}};
        int[][] operations = new int[][]{{1, 1, 500}, {2, 2, 50}, {3, 1}, {2, 6, 15}, {3, 1}};
        System.out.println(Arrays.toString(new LeetCodeLCP5().bonus(6, leadership, operations)));
    }
}
