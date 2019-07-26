package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 *
 *
 *
 * 输入描述:
 * 输入一个字符串
 *
 * 输出描述:
 * 返回有效密码串的最大长度
 *
 * 示例1
 * 输入
 * 复制
 * ABBA
 * 输出
 * 复制
 * 4
 */
public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            //插入#预处理，回文串变为奇数长度
            StringBuilder sb = new StringBuilder("#");
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i)).append("#");
            }
            int pos = 0;//最大处理位置的回文对称轴
            int maxRight = 0;//最大处理位置
            int[] r = new int[sb.length()];//回文半径
            int maxR = 0;
            for (int i = 0; i < sb.length(); i++) {
                int left = i, right = i;
                if (i < maxRight) {//存在已经计算的部分
                    int mirror = 2 * pos - i;
                    if (i + r[mirror] < maxRight) {//回文串较短
                        r[i] = r[mirror];
                        continue;
                    } else {//回文串较长
                        right = maxRight;
                        left = 2 * i - right;
                    }
                }
                //重新计算
                while (left - 1 >= 0 && right + 1 < sb.length()) {
                    if (sb.charAt(left - 1) == sb.charAt(right + 1)) {
                        left--;
                        right++;
                        if (right > maxRight) {
                            maxRight = right;
                            pos = i;
                        }
                    } else break;
                }
                r[i] = right - i + 1;
                maxR = r[i] > maxR ? r[i] : maxR;
            }
            System.out.println(maxR - 1);
        }
    }
}
