package MergeTwoSortedLists;

/**
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while(l1 != null || l2 != null){
            if(l1 == null){
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
                continue;
            }
            if(l2 == null){
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
                continue;
            }
            if(l1.val < l2.val){
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            }
        }
        return res.next;
    }

    //recursive solution
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}
