package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 输入描述:
 * 输入一行字符串，可以有空格
 *
 * 输出描述:
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 *
 * 示例1
 * 输入
 * 复制
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 输出
 * 复制
 * 26
 * 3
 * 10
 * 12
 */
public class CountChar3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int alpha = 0;
            int num = 0;
            int space = 0;
            int others = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c>='a'&&c<='z'){
                    alpha++;
                }
                else if(c>='A'&&c<='Z'){
                    alpha++;
                }
                else if(c>='0'&&c<='9'){
                    num++;
                }
                else if(c==' '){
                    space++;
                }
                else{
                    others++;
                }
            }
            System.out.println(alpha);
            System.out.println(space);
            System.out.println(num);
            System.out.println(others);
        }
    }
}
