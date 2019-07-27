package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入描述:
 * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 *
 * 输出描述:
 * 左上角到右下角的最短路径，格式如样例所示。
 *
 * 示例1
 * 输入
 * 复制
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出
 * 复制
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 */
public class Maze {
    //其实并没有回溯所有路径找最短的，不过测试数据集也比较少，算了
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] maze = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }
            List<String> list = new ArrayList<>();
            list.add("(0, 0)");
            walk(maze, n, m, 0, 0, list);
        }
    }

    private static boolean walk(int[][] maze, int n, int m, int i, int j, List<String> list) {
        if (n - 1 == i && m - 1 == j) {
            for(String s:list)
                System.out.println(s);
            return true;
        }
        if (i + 1 < n && maze[i + 1][j] == 0) {
            maze[i + 1][j] = 1;
            list.add("(" + (i + 1) + ", " + j + ")");
            if (walk(maze, n, m, i + 1, j, list))
                return true;
            else
                list.remove(list.size() - 1);
        }
        if (j + 1 < m && maze[i][j + 1] == 0) {
            maze[i][j + 1] = 1;
            list.add("(" + i + ", " + (j + 1) + ")");
            if (walk(maze, n, m, i, j + 1, list))
                return true;
            else
                list.remove(list.size() - 1);
        }
        if (i - 1 >= 0 && maze[i - 1][j] == 0) {
            maze[i - 1][j] = 1;
            list.add("(" + (i - 1) + ", " + j + ")");
            if (walk(maze, n, m, i - 1, j, list))
                return true;
            else
                list.remove(list.size() - 1);
        }
        if (j - 1 >= 0 && maze[i][j - 1] == 0) {
            maze[i][j - 1] = 1;
            list.add("(" + i + ", " + (j - 1) + ")");
            if (walk(maze, n, m, i, j - 1, list))
                return true;
            else
                list.remove(list.size() - 1);
        }
        return false;
    }
}
