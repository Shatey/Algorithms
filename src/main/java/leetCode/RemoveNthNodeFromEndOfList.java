package leetCode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
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


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
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
