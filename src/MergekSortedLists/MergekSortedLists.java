package MergekSortedLists;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.asList;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */

public class MergekSortedLists {
    //my solution,TLE
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode dummy = res;
        while(!isNull(lists)){
            ListNode s = null;
            int smallest = 0;
            for(int i = 0; i<lists.length; i++){
                if(lists[i] != null){
                    if(s == null){
                        s = lists[i];
                        smallest = i;
                    }
                    if(s.val >= lists[i].val){
                        s = lists[i];
                        smallest = i;
                    }
                }
                if(s != null && i == lists.length - 1){
                    dummy.next = s;
                    dummy = dummy.next;
                    lists[smallest] = lists[smallest].next;
                }
            }
        }
        return res.next;
    }

    private boolean isNull(ListNode[] lists){
        for(ListNode t : lists){
            if (t != null)
                return false;
        }
        return true;
    }

    //my solution after optimize
    public ListNode mergeKListsOptimize(ListNode[] lists) {
        List<ListNode> ls = Arrays.asList(lists);
        return mergeKListsOptimize(lists.)
    }

    private ListNode merge(ListNode s, ListNode e, int start, int end, ListNode[] lists){

    }

    /** recursive solution **/
    public ListNode mergeKLists2(ListNode[] lists) {
        return partion(lists,0,lists.length-1);
    }
    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }

    /**
     I think my code's complexity is also O(nlogk) and not using heap or priority queue, n means the total elements and k means the size of list.

     The mergeTwoLists functiony in my code comes from the problem Merge Two Sorted Lists whose complexity obviously is O(n), n is the sum of length of l1 and l2.

     To put it simpler, assume the k is 2^x, So the progress of combination is like a full binary tree, from bottom to top. So on every level of tree, the combination complexity is n, beacause every level have all n numbers without repetition. The level of tree is x, ie logk. So the complexity is O(nlogk).

     for example, 8 ListNode, and the length of every ListNode is x1, x2,
     x3, x4, x5, x6, x7, x8, total is n.

     on level 3: x1+x2, x3+x4, x5+x6, x7+x8 sum: n

     on level 2: x1+x2+x3+x4, x5+x6+x7+x8 sum: n

     on level 1: x1+x2+x3+x4+x5+x6+x7+x8 sum: n

     total 3n, nlog8
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head=null;
        ListNode former=null;
        while (l1!=null&&l2!=null) {
            if (l1.val>l2.val) {
                if (former==null) former=l2; else former.next=l2;
                if (head==null) head=former; else former=former.next;
                l2=l2.next;
            } else {
                if (former==null) former=l1; else former.next=l1;
                if (head==null) head=former; else former=former.next;
                l1=l1.next;
            }
        }
        if (l2!=null) l1=l2;
        former.next=l1;
        return head;

    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size()==0) return null;
        if (lists.size()==1) return lists.get(0);
        if (lists.size()==2) return mergeTwoLists(lists.get(0), lists.get(1));
        return mergeTwoLists(mergeKLists(lists.subList(0, lists.size()/2)),
                mergeKLists(lists.subList(lists.size()/2, lists.size())));
    }

    /**
     * A java solution based on Priority Queue
     */
    public ListNode mergeKLists3(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

}
