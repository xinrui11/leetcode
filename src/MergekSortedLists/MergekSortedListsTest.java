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

    private ListNode[] generateListNodes(){
        ListNode l = new ListNode(1);
        l.next = new ListNode(3);
        ListNode p = new ListNode(2);
        p.next = new ListNode(4);
        ListNode[] lists = new ListNode[]{l,p};
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