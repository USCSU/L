package LinkedIn;

/**
 * Created by Trace_route on 12/14/14.
 */
public class addNumber {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        int val1 = 0, val2 = 0,carry =0;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(l1!=null || l2!=null || carry!=0){
            val1 = l1==null?0:l1.val;
            val2 = l2==null?0:l2.val;
            int sum = val1+val2+carry;
            p.next = new ListNode(sum%10);
            p =p.next;
            carry = sum/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return dummy.next;

    }
    public static void main(String[] args){
            ListNode a = new ListNode(2);
            a.next = new ListNode(4);
            a.next.next = new ListNode(3);
        ListNode b = new ListNode(5);
            b.next = new ListNode(6);
            b.next.next = new ListNode(4);
        ListNode head = addTwoNumbers(a,b);
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
