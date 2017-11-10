package AddTwoNumbers;

/**
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 中文：给出两个表示两个非负整数的非空链表。数字以相反的顺序存储，它们的每个节点都包含一个数字。相加对应的两个数字，并将其作为链表返回。
 你可以假设这两个数字不包含任何前导零，除了第0个数字本身。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbersMySolution(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tail = res;
        boolean flag = false;
        while(l1 != null || l2 != null){
            int val = 0;
            if(l1 != null){
                val = val + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val = val + l2.val;
                l2 = l2.next;
            }
            if(flag){
                val++;
                flag = false;
            }
            if(val > 9){
                val = val - 10;
                flag = true;
            }
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        if(flag){
            tail.next = new ListNode(1);
        }
        return res.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result;
        int count = 0;
        //这里必须对第一次拿在循环外面，否则reault没有进行实例化，无法进行地址绑定，
        //官方解法巧妙的避开了这一点，将reault默认实例化为0，而最后返回的数据为reault.next
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

    //看了官方解法后优化的版本
    public ListNode addTwoNumbersOptimize(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        int count = 0;
        ListNode tail = result;
        while(l1 != null || l2 != null || count != 0){
            l1 = l1 != null ? l1:new ListNode(0);
            l2 = l2 != null ? l2:new ListNode(0);
            tail.next = new ListNode((l1.val + l2.val + count) % 10);
            count = l1.val + l2.val + count >= 10 ? 1 : 0;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        return result.next;
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
     * 官方解法
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
        if (carry > 0) {//如果加完之后carry还大于0则需进一位
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;//注意这里返回的是next
    }

    /**
     * 最高用户票数解法
     * 与官方解法思路类似
     */
    public ListNode addTwoNumbersHighestVoted(ListNode l1, ListNode l2) {
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
