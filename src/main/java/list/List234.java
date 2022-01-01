package list;

public class List234 {
    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean result = traverse(right.next);
        result = result && (right.val == left.val);
        left = left.next;
        return result;
    }
}
