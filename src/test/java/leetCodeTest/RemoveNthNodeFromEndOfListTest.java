package leetCodeTest;

import leetCode.RemoveNthNodeFromEndOfList;
import org.junit.jupiter.api.Test;

public class RemoveNthNodeFromEndOfListTest {

    @Test
    void test() {
        var node5 = new RemoveNthNodeFromEndOfList.ListNode(5);
        var node4 = new RemoveNthNodeFromEndOfList.ListNode(4, node5);
        var node3 = new RemoveNthNodeFromEndOfList.ListNode(3, node4);
        var node2 = new RemoveNthNodeFromEndOfList.ListNode(2, node3);
        var node1 = new RemoveNthNodeFromEndOfList.ListNode(1, node2);
        System.out.println(RemoveNthNodeFromEndOfList.removeNthFromEnd(node1, 2));
    }
}
