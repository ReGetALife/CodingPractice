package tk.solidays.algorithm.leetcode;

/**
 * 你有一块棋盘，棋盘上有一些格子已经坏掉了。你还有无穷块大小为1 * 2的多米诺骨牌，你想把这些骨牌不重叠地覆盖在完好的格子上，请找出你最多能在棋盘上放多少块骨牌？这些骨牌可以横着或者竖着放。
 *
 *  
 *
 * 输入：n, m代表棋盘的大小；broken是一个b * 2的二维数组，其中每个元素代表棋盘上每一个坏掉的格子的位置。
 *
 * 输出：一个整数，代表最多能在棋盘上放的骨牌数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2, m = 3, broken = [[1, 0], [1, 1]]
 * 输出：2
 * 解释：我们最多可以放两块骨牌：[[0, 0], [0, 1]]以及[[0, 2], [1, 2]]。（见下图）
 *
 *
 *  
 *
 * 示例 2：
 *
 * 输入：n = 3, m = 3, broken = []
 * 输出：4
 * 解释：下图是其中一种可行的摆放方式
 *
 *
 *  
 *
 * 限制：
 *
 * 1 <= n <= 8
 * 1 <= m <= 8
 * 0 <= b <= n * m
 *
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
        if(max==0){
            if (j + 1 < m) {
                max = Math.max(max, backtrace(i, j + 1));
            } else if (i + 1 < n) {
                max = Math.max(max, backtrace(i + 1, 0));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCodeLCP4().domino(8,8,new int[0][]));
        System.out.println(new LeetCodeLCP4().domino(9,9,new int[0][]));
    }
}
