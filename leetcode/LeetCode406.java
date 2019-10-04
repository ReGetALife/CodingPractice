package tk.solidays.algorithm.leetcode;

import java.util.*;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode406 {
    //法一：按照升序排序，然后直接确定最小的元素在数组中的绝对位置，再确定次小元素
    //执行用时 :68 m, 在所有 Java 提交中击败了42.69%的用户
    public int[][] reconstructQueue(int[][] people) {
        //(h,k)
        Arrays.sort(people, Comparator.comparingInt((int[] a) -> a[0]));
        int[][] ans = new int[people.length][];
        for (int[] person : people) {
            int p = person[1];
            int j = 0;
            while (p > 0) {
                if (ans[j] == null || ans[j][0] == person[0])
                    p--;
                j++;
            }
            while (ans[j] != null) j++;
            ans[j] = person;
        }
        return ans;
    }

    //法二：降序排序，从最大元素开始确定相对位置，在链表中插入，42毫秒
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people, (int[] a1, int[] a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a2[0] - a1[0]);//身高降序，身高相同则k升序
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) ans.add(person[1], person);
        return ans.toArray(people);
    }
}
