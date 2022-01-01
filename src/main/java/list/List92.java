package list;

public class List92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1, head);

        // 不反转的前部分
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) pre = pre.next;

        // 反转的开始节点
        ListNode leftNode = pre.next;

        // 反转的尾节点
        ListNode rightNode = leftNode;
        for (int i = left; i < right; i++) rightNode = rightNode.next;

        // 不反转的后部分
        ListNode tail = rightNode.next;

        // 截断反转的部分链表
        pre.next = null;
        rightNode.next = null;

        // 反转
        ListNode reverse = reverse(leftNode);

        // 接上不反转的部分
        pre.next = reverse;
        leftNode.next = tail;

        return dummy.next;
    }

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
