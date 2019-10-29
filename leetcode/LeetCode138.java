package tk.solidays.algorithm.leetcode;

import java.util.HashMap;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的深拷贝。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：
 * {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
 * 节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
 *  
 * <p>
 * 提示：
 * <p>
 * 你必须返回给定头的拷贝作为对克隆列表的引用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode138 {
    //法一：将拷贝后的节点按位置存储在hashmap中，然后再处理指针。耗时2ms
    public Node copyRandomList(Node head) {
        HashMap<Integer, Node> map1 = new HashMap<>();
        HashMap<Node, Integer> map2 = new HashMap<>();
        HashMap<Integer, Node> ans = new HashMap<>();
        int i = 1;
        while (head != null) {
            map1.put(i, head);
            map2.put(head, i);
            ans.put(i, new Node(head.val, null, null));
            head = head.next;
            i++;
        }
        Node node;
        for (int j = 1; j < i; j++) {
            node = ans.get(j);
            node.next = j == i - 1 ? null : ans.get(j + 1);
            node.random = ans.getOrDefault(map2.getOrDefault(map1.get(j).random, null), null);
        }
        return ans.getOrDefault(1, null);
    }

    //法二：维护旧节点到新结点的映射
    //法三：通过把旧节点连到新结点的后面，无需map来维持映射，耗时1ms
    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        Node old = head, node;
        while (head != null) {
            node = new Node(head.val, null, null);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        head = old;
        while (old != null) {
            node = old.next;
            node.random = old.random == null ? null : old.random.next;
            old = node.next;
        }
        old = head.next;
        while (head != null) {
            node = head.next;
            head.next = node.next;
            head = head.next;
            if (head != null) node.next = head.next;
        }
        return old;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
