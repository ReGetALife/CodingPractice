package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
 *
 *
 *
 * 输入描述:
 * 输入待截取的字符串及长度
 *
 * 输出描述:
 * 截取后的字符串
 *
 * 示例1
 * 输入
 * 复制
 * 我ABC汉DEF
 * 6
 * 输出
 * 复制
 * 我ABC
 */
public class SubstringByBites {
    public static void main(String[] args){
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        try{
            while (scanner.hasNext()) {
                byte[] bytes = scanner.next().getBytes();
                int n = Integer.parseInt(scanner.next());
                if (n > bytes.length)
                    n = bytes.length;
                if(n<0){
                    n=0;
                }
                String string = new String(bytes, 0, n);
                if (string.length() > 0 && string.charAt(string.length() - 1) == '�')
                    string = string.substring(0, string.length() - 1);
                System.out.println(string);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
