package tk.solidays.algorithm.leetcode;


/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode61 {
    //循环移动其实是把前length-k个元素接到链尾
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;//空链表
        int length = 0;
        ListNode end = null;
        ListNode newEnd = head;
        while (newEnd != null) {
            length++;
            end = newEnd;
            newEnd = newEnd.next;
        }
        k = k % length;
        if (k == 0) return head;//无需移动
        k = length - k;
        newEnd = head;
        while (k > 1) {//移动k-1次找到新链表尾
            newEnd = newEnd.next;
            k--;
        }
        end.next = head;
        head = newEnd.next;
        newEnd.next = null;
        return head;
    }
}
