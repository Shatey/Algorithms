package leetCodeTest;

import leetCode.PalindromeLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeLinkedListTest {

    @Test
    void test() {
        var node4 = new PalindromeLinkedList.ListNode(1);
        var node3 = new PalindromeLinkedList.ListNode(2, node4);
        var node2 = new PalindromeLinkedList.ListNode(2, node3);
        var node1 = new PalindromeLinkedList.ListNode(1, node2);
        assertTrue(PalindromeLinkedList.isPalindrome(node1));
        var node5 = new PalindromeLinkedList.ListNode(1);
        var node6 = new PalindromeLinkedList.ListNode(2, node5);
        assertFalse(PalindromeLinkedList.isPalindrome(node6));
    }
}
