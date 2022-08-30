package leetCodeTest;

import leetCode.MergeTwoSortedLists;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeTwoSortedListsTest {

    @Test
    void test() {
        var first3 = new MergeTwoSortedLists.ListNode(4);
        var first2 = new MergeTwoSortedLists.ListNode(2, first3);
        var first1 = new MergeTwoSortedLists.ListNode(1, first2);
        var second3 = new MergeTwoSortedLists.ListNode(4);
        var second2 = new MergeTwoSortedLists.ListNode(3, second3);
        var second1 = new MergeTwoSortedLists.ListNode(1, second2);
        var target6 = new MergeTwoSortedLists.ListNode(4);
        var target5 = new MergeTwoSortedLists.ListNode(4, target6);
        var target4 = new MergeTwoSortedLists.ListNode(3, target5);
        var target3 = new MergeTwoSortedLists.ListNode(2, target4);
        var target2 = new MergeTwoSortedLists.ListNode(1, target3);
        var target1 = new MergeTwoSortedLists.ListNode(1, target2);
        var res = MergeTwoSortedLists.mergeTwoLists(first1, second1);
        while (target1.next != null && res.next != null) {
            assertEquals(target1.val, res.val);
            target1 = target1.next;
            res = res.next;
        }
    }
}
