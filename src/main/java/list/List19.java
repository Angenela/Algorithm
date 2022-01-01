package list;

public class List19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode search = search(dummy, n + 1);
        search.next = search.next.next;

        return dummy.next;
    }

    public ListNode search(ListNode head, int n) {
        ListNode i = head;
        ListNode j = head;
        for (int k = 0; k < n; k++) j = j.next;

        while (j != null) {
            i = i.next;
            j = j.next;
        }

        return i;
    }
}
