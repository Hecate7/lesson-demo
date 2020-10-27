package perday.perday_1013_24;

import common.ListNode;

public class SwapNodeInPairs {
    public static void main(String[] args) {
        SwapNodeInPairs swapNodeInPairs =  new SwapNodeInPairs();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        swapNodeInPairs.swapPairs(head);
    }

    public ListNode swapPairs(ListNode head){
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode tmp = head;

        while (tmp.next != null && tmp.next.next != null){
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            tmp = node1;
        }

        return dummyHead.next;
    }
}
