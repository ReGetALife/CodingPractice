package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/03ba8aeeef73400ca7a37a5f3370fe68?f=discussion
 * 来源：牛客网
 * <p>
 * 输入描述:
 * 先输入字典中单词的个数n，再输入n个单词作为字典单词。
 * 再输入一个单词，查找其在字典中兄弟单词的个数m
 * 再输入数字k
 * <p>
 * 输出描述:
 * 根据输入，输出查找到的兄弟单词的个数m
 * 然后输出查找到的兄弟单词的第k个单词。
 * <p>
 * 示例1
 * 输入
 * 3	abc	bca	cab	abc	1
 * 输出
 * 2
 * bca
 * <p>
 * 1.输出不是一行，而是两行，分别是数量及对应的单词。
 * 2.如果无法输出第k个单词则不输出
 */
public class BrotherWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String[] dic = new String[n];
            for (int i = 0; i < n; i++) {
                dic[i] = scanner.next();
            }
            Arrays.sort(dic);
            String word = scanner.next();
            int k = scanner.nextInt();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!word.equals(dic[i])) {
                    char[] wordSorted = word.toCharArray();
                    Arrays.sort(wordSorted);
                    char[] iSorted = dic[i].toCharArray();
                    Arrays.sort(iSorted);
                    if (new String(wordSorted).equals(new String(iSorted)))
                        list.add(dic[i]);
                }
            }

            System.out.println(list.size());
            if (list.size() > 0 && k <= list.size())
                System.out.println(list.get(k - 1));

        }
    }
}
