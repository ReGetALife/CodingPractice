package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 *
 *
 *
 * 处理：
 *
 *
 *
 * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 * （其实是记录了所有记录，但是只输出最后8条==
 *
 *
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 *
 *
 *
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 *
 *
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 *
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 *
 * 示例1
 * 输入
 * 复制
 * E:\V1R2\product\fpgadrive.c   1325
 * 输出
 * 复制
 * fpgadrive.c 1325 1
 */
public class SimpleWrongRecord {
    public static void main(String[] args) {
        List<String> position = new ArrayList<>();
        int[] count = new int[1000];
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] strs = string.split(" ");
            String name;
            if (strs[0].contains("\\")) {
                name = strs[0].substring(strs[0].lastIndexOf("\\") + 1);
            } else name = strs[0];
            if (name.length() > 16) {
                name = name.substring(name.length() - 16);
            }
            String p = name + " " + strs[strs.length - 1];
            if (position.contains(p)) {
                count[position.indexOf(p)]++;
            } else {
                position.add(p);
                count[position.indexOf(p)] = 1;
            }
        }
        if (position.size() > 8) {
            for (int i = position.size() - 8; i < position.size(); i++) {
                System.out.println(position.get(i) + " " + count[i]);
            }
        } else {
            for (int i = 0; i < position.size(); i++) {
                System.out.println(position.get(i) + " " + count[i]);
            }
        }

    }
}
