package tk.solidays.algorithm.leetcode;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode43 {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int[] result = new int[220];
        int length = 0;
        int carry = 0;
        for (int pos1 = num1.length() - 1; pos1 >= 0; ) {
            length = num1.length() - pos1 - 1;
            int pos2 = num2.length() - 1;
            for (; pos2 >= 0; ) {
                int stepResult = (num1.charAt(pos1) - 48) * (num2.charAt(pos2) - 48) + carry + result[length];
                result[length] = stepResult % 10;
                pos2--;
                length++;
                carry = stepResult / 10;
            }
            while (carry != 0) {
                int stepResult = carry + result[length];
                result[length] = stepResult % 10;
                length++;
                carry /= 10;
            }
            pos1--;
        }
        //将result转化为字符
        for (int i = 0; i < length; i++) {
            result[i] = result[i] + 48;
        }
        String s = new String(result, 0, length);
        StringBuilder stringBuilder = new StringBuilder(s);
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println('9' - 48);
        System.out.println(new LeetCode43().multiply("0", "1"));
        System.out.println(new LeetCode43().multiply("10", "1"));
        System.out.println(new LeetCode43().multiply("123", "456"));
    }
}
