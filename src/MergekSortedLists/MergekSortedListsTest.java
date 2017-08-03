package MergekSortedLists;

import junit.framework.TestCase;
import org.junit.Test;

public class MergekSortedListsTest extends TestCase {
    @Test
    public void testmergeKLists() throws Exception {
        MergekSortedLists m = new MergekSortedLists();
        ListNode[] prototype = generateListNodes();
        System.out.println(ListNodeToString(prototype));
        System.out.println(ListNodeToString(m.mergeKLists(prototype)));
    }

    @Test
    public void testmergeKLists2() throws Exception {
        MergekSortedLists m = new MergekSortedLists();
        ListNode[] prototype = generateListNodes();
        System.out.println(ListNodeToString(prototype));
        System.out.println(ListNodeToString(m.mergeKLists2(prototype)));
    }

    private ListNode[] generateListNodes(){
        ListNode l = new ListNode(1);
        l.next = new ListNode(3);
        l.next.next = new ListNode(5);
        ListNode p = new ListNode(2);
        p.next = new ListNode(4);
        p.next.next = new ListNode(6);
        ListNode p3 = new ListNode(2);
        p3.next = new ListNode(4);
        p3.next.next = new ListNode(6);
        ListNode p4 = new ListNode(2);
        p4.next = new ListNode(4);
        p4.next.next = new ListNode(6);
        ListNode[] lists = new ListNode[]{l,p,p3,p4};
        return lists;
    }

    private String ListNodeToString(ListNode[] lists){
        String res = "";
        for(ListNode temp:lists){
            while(temp != null){
                res += temp.val;
                res += ",";
                temp = temp.next;
            }
        }
        return res;
    }

    private String ListNodeToString(ListNode lists){
        String res = "";
        while(lists != null){
            res += lists.val;
            res += ",";
            lists = lists.next;
        }
        return res;
    }

}