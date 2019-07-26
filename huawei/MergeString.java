package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 按照指定规则对输入的字符串进行处理。
 *
 * 详细描述：
 *
 * 将输入的两个字符串合并。
 *
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 *
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 *
 *
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
 *
 * 输入描述:
 * 输入两个字符串
 *
 * 输出描述:
 * 输出转化后的结果
 *
 * 示例1
 * 输入
 * 复制
 * dec fab
 * 输出
 * 复制
 * 5D37BF
 */
public class MergeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            StringBuilder stringBuilder = new StringBuilder(scanner.next()).append(scanner.next());
            char[] all = stringBuilder.toString().toCharArray();
            char[] odd = new char[(all.length + 1) / 2];//下标为0,2,4
            char[] even = new char[all.length / 2];//下标为1.3.5
            for (int i = 0; i < all.length; i++) {
                if (i % 2 == 0) {
                    odd[i / 2] = all[i];
                } else even[i / 2] = all[i];
            }
            String helper1 = "0123456789abcdefABCDEF";
            String helper2 = "084C2A6E195D3B7F5D3B7F";
            Arrays.sort(odd);
            Arrays.sort(even);
            for (int i = 0; i < odd.length; i++) {
                all[i * 2] = odd[i];
            }
            for (int i = 0; i < even.length; i++) {
                all[i * 2 + 1] = even[i];
            }
            StringBuilder stringBuilder1 = new StringBuilder(new String(all));
            for (int i = 0; i < stringBuilder1.length(); i++) {
                int ind = helper1.indexOf(stringBuilder1.charAt(i));
                if (ind >= 0)
                    stringBuilder1.setCharAt(i, helper2.charAt(ind));
            }
            System.out.println(stringBuilder1.toString());
        }
    }
}
