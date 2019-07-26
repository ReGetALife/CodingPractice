package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 * public static String MarkNum(String pInStr)
 * {
 *
 * return null;
 * }
 * 注意：输入数据可能有多行
 * 输入描述:
 * 输入一个字符串
 *
 * 输出描述:
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 *
 * 示例1
 * 输入
 * 复制
 * Jkdi234klowe90a3
 * 输出
 * 复制
 * Jkdi*234*klowe*90*a*3*
 */
public class RepresentNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            StringBuilder sb = new StringBuilder(scanner.nextLine());
            boolean flag = true;
            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i)>='0'&&sb.charAt(i)<='9'&&flag){
                    sb.insert(i,'*');
                    flag=false;
                }
                else if(!flag&&(sb.charAt(i)<'0'||sb.charAt(i)>'9')){
                    sb.insert(i,'*');
                    flag=true;
                }
                else if(i==sb.length()-1&&sb.charAt(i)>='0'&&sb.charAt(i)<='9'){
                    sb.append('*');
                    break;
                }
            }
            System.out.println(sb);
        }
    }
}
