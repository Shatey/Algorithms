package leetCodeTest;

import leetCode.ReverseLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseLinkedListTest {

    @Test
    void test() {
        var node5 = new ReverseLinkedList.ListNode(5);
        var node4 = new ReverseLinkedList.ListNode(4, node5);
        var node3 = new ReverseLinkedList.ListNode(3, node4);
        var node2 = new ReverseLinkedList.ListNode(2, node3);
        var node1 = new ReverseLinkedList.ListNode(1, node2);
        var nodeRes5 = new ReverseLinkedList.ListNode(1);
        var nodeRes4 = new ReverseLinkedList.ListNode(2, nodeRes5);
        var nodeRes3 = new ReverseLinkedList.ListNode(3, nodeRes4);
        var nodeRes2 = new ReverseLinkedList.ListNode(4, nodeRes3);
        var nodeRes1 = new ReverseLinkedList.ListNode(5, nodeRes2);
        var res = ReverseLinkedList.reverseList(node1);
        while (res.next != null && nodeRes1.next != null) {
            assertEquals(res.val, nodeRes1.val);
            nodeRes1 = nodeRes1.next;
            res = res.next;
        }
    }
}
