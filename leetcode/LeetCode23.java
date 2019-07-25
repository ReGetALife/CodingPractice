package tk.solidays.algorithm.leetcode;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        int interval = 1;
        while (interval < length) {
            for (int i = 0; i + interval < length; i += (interval * 2)) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval = interval << 1;
        }
        return length == 0 ? null : lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                temp = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null)
            temp.next = l2;
        if (l2 == null)
            temp.next = l1;
        return head.next;
    }
}
