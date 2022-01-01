package list;


public class List206 {
    ListNode reverse(ListNode a) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = a;

        while (cur != null) {
            nxt = cur.next;
            // 逐个结点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = nxt;
        }

        // 返回反转后的头结点
        return pre;
    }
}
