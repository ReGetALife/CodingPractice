package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode17 {
    private final List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return list;
        recursion("", digits);
        return list;
    }

    private void recursion(String s, String digits) {
        if (digits.length() == 0) {
            list.add(s);
        } else {
            char c = digits.charAt(0);
            if (c == '2') {
                recursion(s + "a", digits.substring(1));
                recursion(s + "b", digits.substring(1));
                recursion(s + "c", digits.substring(1));
            } else if (c == '3') {
                recursion(s + "d", digits.substring(1));
                recursion(s + "e", digits.substring(1));
                recursion(s + "f", digits.substring(1));
            } else if (c == '4') {
                recursion(s + "g", digits.substring(1));
                recursion(s + "h", digits.substring(1));
                recursion(s + "i", digits.substring(1));
            } else if (c == '5') {
                recursion(s + "j", digits.substring(1));
                recursion(s + "k", digits.substring(1));
                recursion(s + "l", digits.substring(1));
            } else if (c == '6') {
                recursion(s + "m", digits.substring(1));
                recursion(s + "n", digits.substring(1));
                recursion(s + "o", digits.substring(1));
            } else if (c == '7') {
                recursion(s + "p", digits.substring(1));
                recursion(s + "q", digits.substring(1));
                recursion(s + "r", digits.substring(1));
                recursion(s + "s", digits.substring(1));
            } else if (c == '8') {
                recursion(s + "t", digits.substring(1));
                recursion(s + "u", digits.substring(1));
                recursion(s + "v", digits.substring(1));
            } else if (c == '9') {
                recursion(s + "w", digits.substring(1));
                recursion(s + "x", digits.substring(1));
                recursion(s + "y", digits.substring(1));
                recursion(s + "z", digits.substring(1));
            }
        }
    }
}
