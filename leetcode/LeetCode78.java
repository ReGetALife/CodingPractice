package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode78 {
    /* 回溯法，从一个空数组开始，把当前数组加入答案，然后通过遍历方式，递归将之后的某个元素加入数组中，递归调用完后再将这个元素移除。以此得到所有子集。
     * 原理是假设得到一个集合，然后依次从还没有在集合中的元素中取一个元素就可以依次得到一个新集合。
     * [],
     * [1],
     * [1,2],
     * [1,2,3],
     * [1,3],
     * [2],
     * [2,3],
     * [3]
     */
    /* 迭代法，集合A的所有子集里都加上一个b元素，然后再加上原先A的所有子集，就能得到集合A并{b}的所有子集（假设b不属于A）。
     * [],
     * [1],
     * [2],
     * [1,2],
     * [3],
     * [1,3],
     * [2,3],
     * [1,2,3]
     */
    /*
     * 二进制位法，对于子集中包含的父集合元素，只有存在和不存在两种可能，可以对应二进制中的0和1，由此也可以推出n元素的集合拥有2的n次方个子集。
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for(int i = 0;i<nums.length;i++){
            int tempLen = lists.size();
            for (int j =0;j<tempLen;j++){
                List<Integer> list =new ArrayList<>(lists.get(j));
                list.add(nums[i]);
                lists.add(list);
            }
        }
        return lists;
    }

}
