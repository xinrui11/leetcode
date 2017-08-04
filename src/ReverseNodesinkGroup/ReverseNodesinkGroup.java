package ReverseNodesinkGroup;

import pub.ListNode;

/**
 Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

 You may not alter the values in the nodes, only nodes itself may be changed.

 Only constant memory is allowed.

 For example,
 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseNodesinkGroup {
    //my solution,is accepted
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2){
            return head;
        }
        //the key is reverse from the end to start
        ListNode end = getKNode(head,k);
        if(end != null){
            end.next = reverseKGroup(end.next, k);
            ListNode dummy = head;
            dummy = reverseListNode(dummy,k);
            return dummy;
        }
        return head;
    }

    private ListNode reverseListNode(ListNode node, int k){
        if(node == null){
            return node;
        }
        ListNode p;
        ListNode q;
        ListNode res = null;
        while(node != null && node.next != null && k > 1){
            p = node;
            q = node.next;
            p.next = q.next;
            if(res == null){
                q.next = p;
                res = q;
            } else {
                q.next = res;
                res = q;
            }
            k--;
        }
        return res;
    }

    private ListNode getKNode(ListNode node, int k){
        ListNode dummy = node;
        int count = 1;
        while(dummy != null){
            if(count == k){
                return dummy;
            }
            dummy = dummy.next;
            count++;
        }
        return null;
    }

    /**-----------highest voted solution,is a little better----------**/
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup2(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            /** this reverse solution is better than my **/
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
