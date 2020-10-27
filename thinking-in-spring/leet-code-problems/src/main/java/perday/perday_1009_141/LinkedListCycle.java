package perday.perday_1009_141;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head){
        List<ListNode> list = new ArrayList<>();
        while (head != null){
            if (list.contains(head)){
                return false;
            }
            list.add(head);
            head = head.next;
        }
        return true;
    }

    public boolean hasCycle1(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        do {
            if (fast == null ||fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        return true;
    }
}