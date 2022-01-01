package list;

import java.util.PriorityQueue;

public class List23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minQueue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        // 因为是有序链表，最小值在头节点，所以先加头结点就好
        for (ListNode list : lists){
            if(list != null) minQueue.add(list);
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (!minQueue.isEmpty()) {
            ListNode poll = minQueue.poll();
            temp.next = poll;
            // 如果poll有后续节点，那么就放进堆中
            if (poll.next != null)
                minQueue.add(poll.next);
            temp = temp.next;
        }

        return dummy.next;
    }
}
