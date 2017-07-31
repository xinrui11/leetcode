package RemoveNthNodeFromEndofList;

public class RemoveNthNodeFromEndofList {
    //my solution,use two pass
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode next = head;
        while(next != null){
            length++;
            next = next.next;
        }
        if(length < n){
            return null;
        }
        int count = length - n + 1;
        ListNode p = head;
        ListNode q = head.next;
        if(count == 1){
            return q;
        }
        for(int i = 1; i < count; i++){
            if(i == count - 1){
                p.next = q.next;
            }
            p = p.next;
            q = q.next;
        }
        return head;
    }

    /** offcial solution **/
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;//use next to substitute head
        int length  = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        length -= n;
        first = dummy;
        while (length > 0) {
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    //In one pass
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //! ListNode first = head;
        //! ListNode second = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i = 1; i <= n + 1; i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

}
