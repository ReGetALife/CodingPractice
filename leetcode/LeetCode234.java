package tk.solidays.algorithm.leetcode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
            slow = slow.next;
        }
        //将slow到fast之间的链表逆转
        ListNode currentHead = null;
        ListNode next;
        while (slow != null) {
            next = slow.next;
            slow.next = currentHead;
            currentHead = slow;
            slow = next;
        }
        //比较
        while (head != null && fast != null) {
            if (head.val != fast.val)
                return false;
            head = head.next;
            fast = fast.next;
        }
        return true;
    }
}
