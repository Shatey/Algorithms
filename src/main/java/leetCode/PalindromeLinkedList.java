package leetCode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        var res = true;
        var mid = head;
        var fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            mid = mid.next;
            fastNode = fastNode.next.next;
        }
        mid = reverseList(mid);
        while (mid != null) {
            if (head.val != mid.val) {
                res = false;
                break;
            }
            mid = mid.next;
            head = head.next;
        }
        return res;
    }

    public static ListNode reverseList(ListNode head) {
        return swap(null, head);
    }

    private static ListNode swap(ListNode previous, ListNode current) {
        if (current != null) {
            ListNode tmp = current.next;
            current.next = previous;
            previous = swap(current, tmp);
        }
        return previous;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
