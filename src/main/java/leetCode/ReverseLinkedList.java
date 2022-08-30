package leetCode;

public class ReverseLinkedList {

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/560/

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
        public int val;
        public ListNode next;

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
