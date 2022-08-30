package leetCode;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = null;
        if (list1 != null || list2 != null) {
            if (list1 == null) {
                res = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                res = list1;
                list1 = list1.next;
            } else {
                if (list1.val <= list2.val) {
                    res = list1;
                    list1 = list1.next;
                } else {
                    res = list2;
                    list2 = list2.next;
                }
            }
            res.next = mergeTwoLists(list1, list2);
        }
        return res;
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
    }
}
