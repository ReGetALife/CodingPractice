package tk.solidays.algorithm.leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode155 {
    class MinStack {
        private Queue<Integer> queue;
        private Stack<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            queue = new PriorityQueue<>();
            stack = new Stack<>();
        }

        public void push(int x) {
            queue.offer(x);
            stack.push(x);
        }

        public void pop() {
            queue.remove(stack.pop());
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return queue.peek() != null ? queue.peek() : 0;
        }
    }
}
