package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * 题目描述
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 *        如，输入： Type   输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 *      如，输入： BabA   输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 *      如，输入： By?e   输出： Be?y
 *
 * 示例1
 * 输入
 * 复制
 * A Famous Saying: Much Ado About Nothing (2012/8).
 * 输出
 * 复制
 * A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class SortString {
    //桶排序
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            List[] lists = new List[26];//存放字母
            List<Integer> index = new ArrayList<>();//存放其他字符
            for (int i = 0; i < string.length(); i++) {
                int pos = Character.toUpperCase(string.charAt(i)) - 65;//计算桶下标
                if(pos>=0&&pos<26){
                    if(lists[pos]==null){
                        lists[pos]=new ArrayList<Character>();
                    }
                    lists[pos].add(string.charAt(i));
                }
                else {
                    index.add(i);
                }
            }
            List<Character> list = new ArrayList<>();
            for (List list1 : lists) {
                if (list1 != null) {
                    list.addAll(list1);
                }
            }
            //加入其他字符
            for (Integer index1 : index) {
                list.add(index1, string.charAt(index1));
            }
            char[] chars = new char[list.size()];
            for (int i = 0; i < list.size(); i++) {
                chars[i]=list.get(i);
            }
            System.out.println(new String(chars));
        }
    }
}
