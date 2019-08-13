package tk.solidays.algorithm.leetcode;

import java.util.Arrays;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * [-1,5,3,4,0]
 */
public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        //给链表加上头指针
        ListNode top = new ListNode(0);
        top.next = head;
        ListNode start = head;
        ListNode previous1, current1, previous2, current2;
        int length = 0, interval = 1, count1, count2, i, j;
        while (start != null) {
            start = start.next;
            length++;
        }
        while (interval < length) {
            start = top;
            //两两合并，(a+1)/b + 1实现向上取整
            for (i = 0; i < (length + 1) / (2 * interval) + 1; i++) {
                previous1 = start;
                if (start == null)
                    break;
                previous2 = previous1;
                for (j = 0; j < interval; j++) {
                    if (previous2.next != null)
                        previous2 = previous2.next;
                }
                current1 = previous1.next;
                current2 = previous2.next;
                for (count1 = 0, count2 = 0; current1 != null && current2 != null && count1 < interval && count2 < interval; ) {
                    if (current1.val < current2.val) {
                        previous1 = current1;
                        current1 = current1.next;
                        count1++;
                    } else {
                        previous2.next = current2.next;
                        previous1.next = current2;
                        previous1 = current2;
                        previous1.next = current1;
                        current2 = previous2.next;
                        count2++;
                    }
                }
                if (count1 == interval) {
                    start = previous2;
                    while (count2 < interval) {
                        count2++;
                        if (start != null)
                            start = start.next;
                    }
                } else if (count2 == interval) {
                    start = previous2;
                } else if (current2 == null)/*只可能是current2为空*/ {
                    break;
                }
            }
            interval = interval << 1;
        }
        return top.next;
    }

}
