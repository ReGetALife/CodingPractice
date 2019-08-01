package tk.solidays.algorithm.leetcode;

public class LeetCode839 {
    //法一：把所有集合存在list中。一次加入一个字符串，考察字符串与其他集合是否有相似，相似则合并集合。
    //法二：比较一个字符串(下标为i)与它后面的字符串是否相同，相同则交换到数组的前面去（用k记录交换到第几个），当i和k重合则说明处理完了一个集合，count加一。
    public int numSimilarGroups(String[] A) {
        int count = 0;
        int k = 1;//当前集合最大下标的后一个下标
        for (int i = 0; i < A.length; i++) {
            if (i == k) {
                count++;
                k++;
            }
            for (int j = k; j < A.length; j++) {
                if (isSimilar(A[i], A[j])) {
                    String s = A[k];
                    A[k] = A[j];
                    A[j] = s;
                    k++;
                }
            }
        }
        return count + 1;
    }

    private boolean isSimilar(String s1, String s2) {
        int flag = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {//出现不同
                if (flag == -2)
                    return false;
                if (flag == -1)//首次不同
                    flag = i;
                else {
                    if (s1.charAt(i) != s2.charAt(flag) || s2.charAt(i) != s1.charAt(flag))//不同位置的字符没对应
                        return false;
                    else {
                        flag = -2;
                    }
                }
            }
        }
        return true;
    }
}
