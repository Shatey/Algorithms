package leetCodeTest;

import leetCode.DeleteNodeInLinkedList;
import org.junit.jupiter.api.Test;

public class DeleteNodeInLinkedListTest {

    @Test
    void test() {
        var node1 = new DeleteNodeInLinkedList.ListNode(4);
        var node2 = new DeleteNodeInLinkedList.ListNode(5);
        var node3 = new DeleteNodeInLinkedList.ListNode(1);
        var node4 = new DeleteNodeInLinkedList.ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        DeleteNodeInLinkedList.deleteNode(node2);
        System.out.println(node1);
    }
}
