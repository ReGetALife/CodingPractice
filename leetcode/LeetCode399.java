package tk.solidays.algorithm.leetcode;

import java.util.*;

/**
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 *
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
 *
 * 基于上述例子，输入如下：
 *
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//基于Floyd算法，耗时 1ms 击败 100.00% 用户
public class LeetCode399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //找到所有的字符并编号
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        String a, b;
        for (List<String> equation : equations) {
            a = equation.get(0);
            b = equation.get(1);
            if (!map.containsKey(a)) map.put(a, index++);
            if (!map.containsKey(b)) map.put(b, index++);
        }
        double[][] cost = new double[index][index];
        //初始化邻接矩阵
        int i, j;
        for (int k = 0; k < equations.size(); k++) {
            i = map.get(equations.get(k).get(0));
            j = map.get(equations.get(k).get(1));
            cost[i][j] = values[k];
            cost[j][i] = 1 / values[k];
        }
        for (int k = 0; k < index; k++) cost[k][k] = 1;
        //遍历所有节点
        for (int k = 0; k < index; k++) {
            for (int l = 0; l < index; l++) {
                for (int m = 0; m < index; m++) {
                    if (cost[l][m] == 0 && cost[l][k] != 0 && cost[k][m] != 0) {
                        cost[l][m] = cost[l][k] * cost[k][m];
                        cost[m][l] = cost[k][l] * cost[m][k];
                    }
                }
            }
        }
        double[] ans = new double[queries.size()];
        for (int k = 0; k < queries.size(); k++) {
            a = queries.get(k).get(0);
            b = queries.get(k).get(1);
            if (map.containsKey(a) && map.containsKey(b)) {
                i = map.get(a);
                j = map.get(b);
                ans[k] = cost[i][j] == 0 ? -1 : cost[i][j];
            } else ans[k] = -1;
        }
        return ans;
    }
}
