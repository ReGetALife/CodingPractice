package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 *
 * 输入: ")("
 * 输出: [""]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//通过对每个括号进行删除或者保留操作，进行枚举，复杂度为2^n
//预处理得出最少需要删除多少个括号，然后进行剪枝。对最后的结果进行合法性判断。
public class LeetCode301 {
    private Set<String> ans = new HashSet<>();
    private String s;
    int left=0, right=0;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        init(s);
        if (s.length() > 0) recursion(0, 0, 0, new StringBuilder());
        return new ArrayList<>(ans);
    }

    private void recursion(int pos, int removedLeft, int removedRight, StringBuilder current) {
        //如果不满足则剪枝
        if (pos > 0 && (removedLeft > left || removedRight > right))
            return;
        //如果达到末尾则验证合法性并加入答案
        if (pos == s.length()) {
            checkAndAddToAns(current.toString());
            return;
        }
        //否则继续递归
        if (s.charAt(pos) == '(') {
            recursion(pos + 1, removedLeft + 1, removedRight, current);
            current.append('(');
            recursion(pos + 1, removedLeft, removedRight, current);
            current.replace(current.length() - 1, current.length(), "");
        } else if (s.charAt(pos) == ')') {
            recursion(pos + 1, removedLeft, removedRight + 1, current);
            current.append(')');
            recursion(pos + 1, removedLeft, removedRight, current);
            current.replace(current.length() - 1, current.length(), "");
        } else {
            current.append(s.charAt(pos));
            recursion(pos + 1, removedLeft, removedRight, current);
            current.replace(current.length() - 1, current.length(), "");
        }
    }

    private void checkAndAddToAns(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0)
                return;
        }
        if (count == 0)
            ans.add(s);
    }

    //初始化总共删去的括号数
    private void init(String s) {
        int left = 0, right = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (flag) {
                    this.right += right - left;
                    left = 0;
                    right = 0;
                    flag = false;
                }
                left++;
            } else if (s.charAt(i) == ')') {
                right++;
            }
            if (right > left) {
                flag = true;
            }
        }
        //可能最后一段是右括号多，右括号结尾
        if (right > left)
            this.right += right - left;
        else
            this.left += left - right;
    }

    public static void main(String[] args) {
//        System.out.println(new LeetCode301().removeInvalidParentheses("()())()"));
        System.out.println(new LeetCode301().removeInvalidParentheses("(a)())()"));
    }
}
