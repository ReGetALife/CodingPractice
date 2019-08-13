package tk.solidays.algorithm.leetcode;

public class LeetCode206 {
    //迭代法，从头开始拆节点，让下一个节点反过来指向它
    //递归法，当前链表的反转链表等于头节点下一个节点的反转链表加上头节点
    private ListNode start;
    private ListNode end;

    public ListNode reverseList(ListNode head) {
        recurrence(head);
        return start;
    }

    private void recurrence(ListNode head) {
        if (head == null)
            start = null;
        else if (head.next == null) {
            end = head;
            start = head;
            end.next = null;
        } else {
            recurrence(head.next);
            //把头节点加到尾部
            end.next = head;
            end = head;
            end.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(10);
        a.next = b;
        b.next = c;
        c.next = null;
        ListNode ans = new LeetCode206().reverseList(a);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
