package tk.solidays.algorithm;

import java.io.BufferedInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static java.lang.System.in;

/**
 * 题目描述
 * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 *
 * 输出描述:
 * 输出合并后的键值对（多行）
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * 0 1
 * 0 2
 * 1 2
 * 3 4
 * 输出
 * 复制
 * 0 3
 * 1 2
 * 3 4
 */
public class HwCombineRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                int k = scanner.nextInt();
                int v = scanner.nextInt();
                if (map.containsKey(k))
                    map.put(k, v + map.get(k));
                else
                    map.put(k, v);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.print(entry.getKey() + " " + entry.getValue() + "\n");
            }
        }
    }
}
