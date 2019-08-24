package tk.solidays.algorithm.leetcode;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode42 {
    public int trap(int[] height) {
        if (height.length < 2)
            return 0;
        int maxPos = 0;
        int max = 0;
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxPos = i;
            }
        }
        //从左到最高
        max = height[0];
        for (int i = 0; i < maxPos; i++) {
            if (height[i] > max)
                max = height[i];
            else if (height[i] < max)
                ans += (max - height[i]);
        }
        //从右到最高
        max = height[height.length - 1];
        for (int i = height.length - 1; i >= maxPos; i--) {
            if (height[i] > max)
                max = height[i];
            else if (height[i] < max)
                ans += (max - height[i]);
        }
        return ans;
    }
}
