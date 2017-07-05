package AddTwoNumbers;

import junit.framework.TestCase;
import org.junit.Test;

public class AddTwoNumbersTest extends TestCase {
    @Test
    public void testReverse() throws Exception {
        ListNode head, tail;
        head = tail = new ListNode(0);
        for(int i=1; i<5; i++){
            ListNode p = new ListNode(i);
            tail.next = p;
            tail = p;
        }
        tail = head;
        outMessage(tail);

        AddTwoNumbers a = new AddTwoNumbers();
        head = a.reverse(head);

        outMessage(head);
    }

    @Test
    public void testAddTwoNumbers() throws Exception {
        AddTwoNumbers a = new AddTwoNumbers();
        ListNode p1, p2;
        p1 = p2 = new ListNode(0);
        for(int i=1; i<6; i++){
            ListNode p = new ListNode(i);
            p1.next = p;
            p1 = p;
        }
        p1 = p2;
        outMessage(p1);
        outMessage(p2);
        outMessage(a.addTwoNumbers(p1,p2));
    }

    private void outMessage(ListNode l){
        while(l != null){
            System.out.print(l.val+"  ");
            l = l.next;
        }
        System.out.println(" ");
    }

}