package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class SayNum {
    private static String[] single = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private static String[] ten = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static String[] ranges = {"hundred", "thousand", "million", "billion"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String s = Integer.valueOf(scanner.nextInt()).toString();
            int end = s.length() - 1;
            int range = 0;
            while (end - 3 >= 0) {
                end -= 3;
                range++;
            }
            say(s, 0, end, range);
            System.out.println();
        }
    }

    /**
     * 递归读数字
     *
     * @param s     字符串
     * @param begin 当前读的开始位置
     * @param end   当前读的结束位置，inclusive
     * @param range 百还是千还是百万还是十亿
     */
    private static void say(String s, int begin, int end, int range) {
        if (begin == end) {//个位
            if (s.charAt(begin) != '0')
                System.out.print(single[Character.getNumericValue(s.charAt(begin)) - 1] + " ");
        } else if (begin == end - 1) {//十位
            if (s.charAt(begin) > '1') {//十几
                System.out.print(tens[Character.getNumericValue(s.charAt(begin)) - 2] + " ");
                say(s, begin + 1, end, -1);
            } else//几十
                System.out.print(ten[Character.getNumericValue(s.charAt(end))] + " ");
        } else if (begin == end - 2) {//百位
            if (s.charAt(begin) != '0') {//百位非空
                say(s, begin, begin, 0);
                System.out.print(ranges[0] + " ");
            }
            if (s.charAt(begin + 1) == '0' && s.charAt(end) != '0') {//只有个位
                System.out.print("and ");
                say(s, end, end, -1);
            } else if (s.charAt(begin + 1) != '0') {//还有十位
                System.out.print("and ");
                say(s, begin + 1, end, -1);
            }
        }
        if (range > 0) {
            System.out.print(ranges[range] + " ");
            say(s, end + 1, end + 3, range - 1);
        }
    }
}
