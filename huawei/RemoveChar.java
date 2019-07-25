package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 *
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 *
 * 示例1
 * 输入
 * 复制
 * abcdd
 * 输出
 * 复制
 * dd
 */
public class RemoveChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {//计数
            StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < stringBuilder.length(); i++) {
                char c = stringBuilder.charAt(i);
                if (map.containsKey(c))
                    map.put(c, map.get(c) + 1);
                else map.put(c, 1);
            }
            int lest = 100;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {//找最小
                lest = lest > entry.getValue() ? entry.getValue() : lest;
            }
            Set<Character> set = new HashSet<>();
            for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {//将最小加入集合
                char k = characterIntegerEntry.getKey();
                if (map.get(k) == lest)
                    set.add(k);
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < stringBuilder.length(); i++) {
                char c = stringBuilder.charAt(i);
                if (!set.contains(c))
                    ans.append(c);
            }
            System.out.println(ans.toString());
        }
    }
}
