package tk.solidays.algorithm.leetcode;

/**
 * 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 *
 * U: 向y轴正方向移动一格
 * R: 向x轴正方向移动一格。
 * 不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 *
 * 给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：command = "URR", obstacles = [], x = 3, y = 2
 * 输出：true
 * 解释：U(0, 1) -> R(1, 1) -> R(2, 1) -> U(2, 2) -> R(3, 2)。
 * 示例 2：
 *
 * 输入：command = "URR", obstacles = [[2, 2]], x = 3, y = 2
 * 输出：false
 * 解释：机器人在到达终点前会碰到(2, 2)的障碍物。
 * 示例 3：
 *
 * 输入：command = "URR", obstacles = [[4, 2]], x = 3, y = 2
 * 输出：true
 * 解释：到达终点后，再碰到障碍物也不影响返回结果。
 *  
 *
 * 限制：
 *
 * 2 <= command的长度 <= 1000
 * command由U，R构成，且至少有一个U，至少有一个R
 * 0 <= x <= 1e9, 0 <= y <= 1e9
 * 0 <= obstacles的长度 <= 1000
 * obstacles[i]不为原点或者终点
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/programmable-robot
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//把指令走的区域看成一个矩形。常数时间内可以判断某一个点是否会落在某一个矩形区域里
//然后判断点是否会落在路径上
public class LeetCodeLCP3 {
    private boolean[][] map;//记录第一个矩形内的路径，经过则为true

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int u = 0, r = 0;
        for (int k = 0; k < command.length(); k++) {
            if (command.charAt(k) == 'U') u++;
            else r++;
        }
        //初始化map
        map = new boolean[r + 1][u + 1];
        int i = 0, j = 0;
        for (int k = 0; k < command.length(); k++) {
            if (command.charAt(k) == 'R') i++;
            else j++;
            map[i][j] = true;
        }
        //判断x和y是否落在路径内
        int[] pos;
        if ((pos = convert(r, u, x, y)) == null || !map[pos[0]][pos[1]]) return false;
        //判断障碍物是否在路径内
        for (int[] obstacle : obstacles) {
            if (obstacle[0] <= x && obstacle[1] <= y && (pos = convert(r, u, obstacle[0], obstacle[1])) != null && map[pos[0]][pos[1]])
                return false;
        }
        return true;
    }

    //判断某个点是否落在某个矩形内，是则返回它在第一个矩形中的等价位置。否则返回空。
    private int[] convert(int r, int u, int x, int y) {
        int a = (x - 1) / r;
        int b = (y - 1) / u;
        int max = Math.max(a, b);
        x -= max * r;
        y -= max * u;
        if (x < 0 || y < 0) return null;
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        System.out.println(new LeetCodeLCP3().robot("URR", new int[][]{{2, 2}}, 3, 2));
    }
}
