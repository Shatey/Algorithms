import org.junit.jupiter.api.Test;

public class DeleteNodeInLinkedList {

//    https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/

    @Test
    void test() {
        var node1 = new ListNode(4);
        var node2 = new ListNode(5);
        var node3 = new ListNode(1);
        var node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNode(node2);
        System.out.println(node1);
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
