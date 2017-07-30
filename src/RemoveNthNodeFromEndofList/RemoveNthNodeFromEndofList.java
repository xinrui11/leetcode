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
}
