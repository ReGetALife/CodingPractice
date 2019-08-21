package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode22 {
    //检验括号是否合法时可以使用栈，反过来，每个出栈入栈序列都对应一个合法的括号组合，递归遍历所有出栈入栈序列
    private final List<String> list = new ArrayList<>();
    private int n;
    public List<String> generateParenthesis(int n) {
        this.n= n;
        recursion("",0,0);
        return list;
    }
    private void recursion(String s,int in,int out){
        if(out==n){
            list.add(s);
            return;
        }
        if(in<n){
            recursion(s+"(", in+1,out);
        }
        if(out<in){
            recursion(s+")", in,out+1);
        }
    }
}
