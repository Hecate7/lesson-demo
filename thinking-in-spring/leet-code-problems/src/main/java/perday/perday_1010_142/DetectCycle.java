package perday.perday_1010_142;

import common.ListNode;

public class DetectCycle {
    public static void main(String[] args) {
        DetectCycle cycle = new DetectCycle();
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = head;
        System.out.println(cycle.detectCycle(head));
    }

    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null || fast.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
