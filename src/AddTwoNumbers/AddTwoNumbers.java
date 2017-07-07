package AddTwoNumbers;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        int count = 0;
        if(l1.val + l2.val + count >= 10){
            result = new ListNode(l1.val + l2.val + count - 10);
            count = 1;
        } else {
            result = new ListNode(l1.val + l2.val + count);
            count = 0;
        }
        ListNode tail = result;//地址绑定
        /**
         * 这里会有很多种情况，可能l1和l2的长度不一致，也可能会有满十进位的情况
         */
        while(l1.next != null || l2.next != null || count != 0){
            l1 = l1.next != null ? l1.next:new ListNode(0);
            l2 = l2.next != null ? l2.next:new ListNode(0);
            if(l1.val + l2.val + count >= 10){
                tail.next = new ListNode(l1.val + l2.val + count - 10);
                count = 1;
            } else {
                tail.next = new ListNode(l1.val + l2.val + count);
                count = 0;
            }
            tail = tail.next;//由于和result地址绑定了，tail的next会加到result后面
        }
        return result;
    }

    //单链表倒转
    public ListNode reverse(ListNode head){
        ListNode p1,p2 = null;//p1记录头信息，p2作为返回值
        p1 = head;
        while (head.next != null){
            p2 = head.next;
            head.next = p2.next;//断链
            p2.next = p1;//倒转
            p1 = p2;//记录新的头信息
        }
        return p2;
    }

    /**
     * 官方揭发
     */
    public ListNode addTwoNumbersOfficial(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * 最高用户票数
     */
    public ListNode addTwoNumbersMostVoted(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

}
