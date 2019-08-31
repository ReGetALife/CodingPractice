package tk.solidays.algorithm.leetcode;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode84 {
    /*
     * 利用单调栈得到某个元素左边的最近的比它小的元素，
     * 同时出栈的时候也隐含了接下来要入栈的元素比现在要出栈的元素小，
     * 这样就得到了要出栈的元素能向两边扩张的宽度
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int t;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            if (stack.size() <= 1) {
                stack.push(i);
            } else {
                if (heights[i] < heights[stack.peek()]) {
                    while (stack.peek() >= 0 && heights[stack.peek()] > heights[i]) {
                        t = stack.pop();
                        max = Math.max(max, heights[t] * (i - stack.peek() - 1));
                    }
                }
                stack.push(i);
            }
        }
        int n = heights.length;
        while (stack.size() > 1) {
            t = stack.pop();
            max = Math.max(max, heights[t] * (n - stack.peek() - 1));
        }
        return max;
    }
}
