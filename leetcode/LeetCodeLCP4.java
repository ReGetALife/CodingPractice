package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你有一块棋盘，棋盘上有一些格子已经坏掉了。你还有无穷块大小为1 * 2的多米诺骨牌，你想把这些骨牌不重叠地覆盖在完好的格子上，请找出你最多能在棋盘上放多少块骨牌？这些骨牌可以横着或者竖着放。
 * <p>
 *  
 * <p>
 * 输入：n, m代表棋盘的大小；broken是一个b * 2的二维数组，其中每个元素代表棋盘上每一个坏掉的格子的位置。
 * <p>
 * 输出：一个整数，代表最多能在棋盘上放的骨牌数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, m = 3, broken = [[1, 0], [1, 1]]
 * 输出：2
 * 解释：我们最多可以放两块骨牌：[[0, 0], [0, 1]]以及[[0, 2], [1, 2]]。（见下图）
 * <p>
 * <p>
 *  
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3, m = 3, broken = []
 * 输出：4
 * 解释：下图是其中一种可行的摆放方式
 * <p>
 * <p>
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 8
 * 1 <= m <= 8
 * 0 <= b <= n * m
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/broken-board-dominoes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCodeLCP4 {
    //法一：回溯法，每个点可横放或竖放，也可不放，每次能放的时候都贪婪放下，耗时911ms
    private boolean[][] map;
    private int n, m;

    public int domino(int n, int m, int[][] broken) {
        map = new boolean[n][m];
        this.n = n;
        this.m = m;
        for (int[] ij : broken) {
            map[ij[0]][ij[1]] = true;
        }
        return backtrace(0, 0);
    }

    int backtrace(int i, int j) {
        int max = 0;
        //横放
        if (!map[i][j] && j + 1 < m && !map[i][j + 1]) {
            if (j + 2 < m) max = Math.max(max, 1 + backtrace(i, j + 2));
            else if (i + 1 < n) max = Math.max(max, 1 + backtrace(i + 1, 0));
            else max = Math.max(max, 1);
        }
        //竖放，需要回溯
        if (!map[i][j] && i + 1 < n && !map[i + 1][j]) {
            map[i + 1][j] = true;
            if (j + 1 < m) max = Math.max(max, 1 + backtrace(i, j + 1));
            else if (i + 1 < n) max = Math.max(max, 1 + backtrace(i + 1, 0));
            else max = Math.max(max, 1);
            map[i + 1][j] = false;
        }
        //不放
        if (max == 0) {
            if (j + 1 < m) {
                max = Math.max(max, backtrace(i, j + 1));
            } else if (i + 1 < n) {
                max = Math.max(max, backtrace(i + 1, 0));
            }
        }

        return max;
    }

    //法二：匈牙利算法求二分图最大匹配，采用dfs实现，耗时3 ms

    private int col;//列数
    private boolean[] check;//用来存储当前深搜到的交替路信息，避免重复，因为是二分图，只需存储匹配边的后节点信息就足以避免重复
    private int[] matched;//记录目前的匹配情况
    private List[] table;//邻接表

    public int domino2(int n, int m, int[][] broken) {
        //记录broken的块
        boolean[][] mapForBroken = new boolean[n][m];
        col = m;
        for (int[] ij : broken) {
            mapForBroken[ij[0]][ij[1]] = true;
        }
        matched = new int[n * m + 1];
        check = new boolean[n * m + 1];
        //初始化邻接表
        table = new List[n * m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List<Integer> list = new ArrayList<>();
                if (!mapForBroken[i][j]) {
                    if (i - 1 >= 0 && !mapForBroken[i - 1][j]) list.add(convert(i - 1, j));
                    if (j - 1 >= 0 && !mapForBroken[i][j - 1]) list.add(convert(i, j - 1));
                    if (i + 1 < n && !mapForBroken[i + 1][j]) list.add(convert(i + 1, j));
                    if (j + 1 < m && !mapForBroken[i][j + 1]) list.add(convert(i, j + 1));
                }
                table[convert(i, j)] = list;
            }
        }
        //开始匹配
        int ans = 0;
        for (int i = 1; i <= n * m; i++) {
            //未匹配则开始匹配
            if (matched[i] == 0) {
                Arrays.fill(check, false);//每次找增广路都要初始化
                if (dfs(i)) ans++;//每次成功找到增广路只能新增一个匹配
            }
        }
        return ans;
    }

    private boolean dfs(int a) {
        for (Object i : table[a]) {
            int b = (Integer) i;
            if (!check[b]) {
                check[b] = true;
                if (matched[b] == 0 || dfs(matched[b])) {//当前层或者之后递归遇到未匹配点，即成功找到增广路
                    matched[a] = b;
                    matched[b] = a;
                    return true;
                }
            }
        }
        return false;
    }

    //二维转一维，标号从1开始
    private int convert(int i, int j) {
        return col * i + j + 1;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCodeLCP4().domino(7, 7, new int[0][]));
        System.out.println(new LeetCodeLCP4().domino(8, 8, new int[0][]));
        System.out.println(new LeetCodeLCP4().domino2(7, 7, new int[0][]));
        System.out.println(new LeetCodeLCP4().domino2(8, 8, new int[0][]));
        System.out.println(new LeetCodeLCP4().domino2(9, 9, new int[0][]));
        System.out.println(new LeetCodeLCP4().domino2(20, 20, new int[0][]));
    }
}
