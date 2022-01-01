package list;

public class List21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头结点，比较好操作
        // 不过这属于空间换时间
        ListNode vir = new ListNode(-1);
        ListNode p = vir;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while (p1 != null && p2 != null) {
            // 哪个小就先接上哪个
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }

            p = p.next;
        }

        // 因为可能还会有剩的
        if (p1 != null)
            p.next = p1;

        if (p2 != null)
            p.next = p2;

        return vir.next;
    }
}
