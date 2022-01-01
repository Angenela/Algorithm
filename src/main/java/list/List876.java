package list;

public class List876 {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null)
            return slow;
        else
            return slow.next;
    }
}
