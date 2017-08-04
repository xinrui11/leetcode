package SwapNodesinPairs;

import pub.ListNode;

/**
 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list,
 only nodes itself can be changed.
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode res = head.next;
        ListNode pre = head.next;
        ListNode now = head;
        now.next = pre.next;
        pre.next = now;
        head = pre.next.next;
        if(head != null){
            recursive(pre.next,head,head.next);
        }
        return res;
    }

    private void recursive(ListNode pre,ListNode now,ListNode end){
        if(pre!=null&&now!=null&&end!=null){
            pre.next = end;
            now.next = end.next;
            end.next = now;
            if(now.next != null){
                recursive(now,now.next,now.next.next);
            }
        }
    }

    /**-------------formal solution-------------**/
    public ListNode swapPairs2(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        //the key is swap from the end
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

}
