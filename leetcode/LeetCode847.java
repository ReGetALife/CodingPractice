package tk.solidays.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出 graph 为有 N 个节点（编号为 0, 1, 2, ..., N-1）的无向连通图。 
 *
 * graph.length = N，且只有节点 i 和 j 连通时，j != i 在列表 graph[i] 中恰好出现一次。
 *
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],[0],[0],[0]]
 * 输出：4
 * 解释：一个可能的路径为 [1,0,2,0,3]
 * 示例 2：
 *
 * 输入：[[1],[0,2,4],[1,3,4],[2],[1,2]]
 * 输出：4
 * 解释：一个可能的路径为 [0,1,4,2,3]
 *  
 *
 * 提示：
 *
 * 1 <= graph.length <= 12
 * 0 <= graph[i].length < graph.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * [[2,5],[3,6],[0,3,6],[1,2,4],[6,7,3],[7,0],[4,1,2],[4,5]]
 * [[7],[3],[3,9],[1,2,4,5,7,11],[3],[3],[9],[3,10,8,0],[7],[11,6,2],[7],[3,9]]
 */
public class LeetCode847 {
    private int min = Integer.MAX_VALUE;
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = 1000000000;
            }
            dp[i][1 << i] = 0;
        }
        for (int i = 0; i < n; i++) {
            dfs(i, 1 << i, dp, graph, 0);
        }
        return min;
    }

    //其实应该是状态压缩加广搜（采用循环和队列实现），不过一不小心写成了深搜。
    private void dfs(int i, int S, int[][] dp, int[][] graph, int count) {
        if (S == (1 << graph.length) - 1) {
            min = Math.min(min, dp[i][S]);
            return;
        }
        if (count > 20 || count > min || min == graph.length - 1)
            return;
        if ((S & (1 << i)) > 0) {//i点在S集合里时，看i能到哪
            boolean flag = true;
            //假如有新结点就贪心加入
            for (int j = 0; j < graph[i].length; j++) {
                int newNode = graph[i][j];
                if ((S & (1 << newNode)) == 0) {
                    int newSet = S | (1 << newNode);
                    dp[newNode][newSet] = Math.min(dp[newNode][newSet], dp[i][S] + 1);
                    dfs(newNode, newSet, dp, graph, count + 1);
                    flag = false;
                }
            }
            //没有新结点退化成无脑遍历
            if (flag) {
                for (int j = 0; j < graph[i].length; j++) {
                    int newNode = graph[i][j];
                    int newSet = S | (1 << newNode);
                    dp[newNode][newSet] = Math.min(dp[newNode][newSet], dp[i][S] + 1);
                    dfs(newNode, newSet, dp, graph, count + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] gragh = new int[12][];
        //[[7],[3],[3,9],[1,2,4,5,7,11],[3],[3],[9],[3,10,8,0],[7],[11,6,2],[7],[3,9]]
        gragh[0] = new int[]{7};
        gragh[1] = new int[]{3};
        gragh[2] = new int[]{3, 9};
        gragh[3] = new int[]{1, 2, 4, 5, 7, 11};
        gragh[4] = new int[]{3};
        gragh[5] = new int[]{3};
        gragh[6] = new int[]{9};
        gragh[7] = new int[]{3, 10, 8, 0};
        gragh[8] = new int[]{7};
        gragh[9] = new int[]{11, 6, 2};
        gragh[10] = new int[]{7};
        gragh[11] = new int[]{3, 9};
        System.out.println(new LeetCode847().shortestPathLength(gragh));
        Queue<Integer> queue = new LinkedList<>();
    }
}
