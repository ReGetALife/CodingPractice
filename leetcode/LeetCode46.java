package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//回溯法：通过交换和回溯得到所有排列
//字典序法：通过字典排序的规律，得到所有排列，结束标识是由升序变成了倒序
//递归法：固定一个然后求其余的全排列，求全排列长度为1时终止
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> fixed = new ArrayList<>();
        List<Integer> nums1 = new ArrayList<>();
        for (int i : nums) {
            nums1.add(i);
        }
        recusion(res, fixed, nums1);
        return res;
    }

    //递归法
    private void recusion(List<List<Integer>> res, List<Integer> fixed, List<Integer> nums) {
        if (nums.size() > 1) {
            for (int i = 0; i < nums.size(); i++) {
                List<Integer> temp = new ArrayList<>(nums);
                List<Integer> tempFixed = new ArrayList<>(fixed);
                tempFixed.add(nums.get(i));
                temp.remove(i);
                recusion(res, tempFixed, temp);
            }
        }
        if (nums.size() == 1) {
            fixed.add(nums.get(0));
            res.add(fixed);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new LeetCode46().permute(nums));
    }
}
