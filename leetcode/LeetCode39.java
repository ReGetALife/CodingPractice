package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode39 {
    private final List<List<Integer>> ans = new ArrayList<>();
    private int target;
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        recursion(new ArrayList<>(),0,0);
        return ans;
    }

    private void recursion(List<Integer> list, int pos, int sum) {
        if (sum == target) {
            ans.add(list);
        } else if (sum < target) {
            for (int i = pos; i < candidates.length; i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                recursion(newList, i, sum + candidates[i]);
            }
        }
    }
}
