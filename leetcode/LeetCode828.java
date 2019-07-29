package tk.solidays.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode828 {
    public int uniqueLetterString(String S) {
        if (S.length() == 0)
            return 0;
        //字符最后出现位置
        int[] ascii = new int[128];
        for (int i = 0; i < ascii.length; i++) {
            ascii[i] = -1;
        }
        //字符最后出现位置的上一位置
        int[] ascii2 = Arrays.copyOf(ascii,ascii.length);
        //以第i个字符为结尾的子串的独特字符数之和
        int[] uniq = new int[S.length()];
        uniq[0] = 1;
        ascii[S.charAt(0)] = 0;
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            //首次出现
            if (ascii[c] == -1) {
                ascii[c] = i;
                uniq[i] = uniq[i - 1] + i + 1;
            } else {
                //之前的序列中只有一个该字符
                if(ascii2[c]==-1){
                    uniq[i] = uniq[i - 1] + i + 1 - 2*(ascii[c] + 1);
                    ascii2[c]=ascii[c];
                    ascii[c]=i;
                }
                //之前的序列中已经出现过
                else {
                    //先假设所有子串迭代后都因为新元素增加了1个特殊字符，然后其实有的是减少了1，有的不变
                    uniq[i] = uniq[i - 1] + i + 1 - 2*(ascii[c] -ascii2[c]) - (ascii2[c]+1);
                    ascii2[c]=ascii[c];
                    ascii[c]=i;
                }
            }
        }
        int sum = 0;
        for (int i1 : uniq) {
            sum += i1;
            System.out.print(i1 + " ");
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("-- >" + new LeetCode828().uniqueLetterString("abc"));
        System.out.println("-- >" + new LeetCode828().uniqueLetterString("abcd"));
        System.out.println("-- >" + new LeetCode828().uniqueLetterString("aba"));
        System.out.println("-- >" + new LeetCode828().uniqueLetterString("abdcd"));
        System.out.println("-- >" + new LeetCode828().uniqueLetterString("ababab"));
        System.out.println("-- >" + new LeetCode828().uniqueLetterString("ababababababab"));
        System.out.println("-- >" + new LeetCode828().uniqueLetterString("aaa"));
    }
}
