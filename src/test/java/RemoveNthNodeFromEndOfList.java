import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    @Test
    void test() {
        var node5 = new ListNode(5);
        var node4 = new ListNode(4, node5);
        var node3 = new ListNode(3, node4);
        var node2 = new ListNode(2, node3);
        var node1 = new ListNode(1, node2);
        System.out.println(removeNthFromEnd(node1, 2));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        var currentNode = head;
        while (currentNode != null) {
            list.add(currentNode);
            currentNode = currentNode.next;
        }
        var targetPos = list.size() - n;
        if (targetPos == 0 ) {
            head = head.next == null ? null : head.next;
        } else if (targetPos == list.size() - 1) {
            var prev = list.get(targetPos - 1);
            prev.next = null;
        } else {
            var prev = list.get(targetPos - 1);
            prev.next = list.get(targetPos).next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
