package tk.solidays.algorithm.leetcode;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode200 {
    private char[][] grid;

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (i + 1 < grid.length)
                dfs(i + 1, j);
            if (i - 1 >= 0)
                dfs(i - 1, j);
            if (j + 1 < grid[0].length)
                dfs(i, j + 1);
            if (j - 1 >= 0)
                dfs(i, j - 1);
        }
    }
}
