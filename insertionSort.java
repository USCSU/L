package LinkedIn;

/**
 * Created by Trace_route on 12/12/14.
 */
public class insertionSort {
    public static ListNode insertion(ListNode head){
        if(head == null||head.next==null) return head;
        ListNode temp = head, cur = head.next;
        while(cur!=null){
            temp = head;
            while(temp!=null){
                if(temp.val>cur.val){
                    int value = cur.val;
                    cur.val = temp.val;
                    temp.val = value;
                }
                temp=temp.next;
            }
            cur=cur.next;
        }
        return head;
    }
    public static ListNode insertSort(ListNode head){
        if(head == null||head.next == null) return head;
        ListNode cur = head.next;
        while(cur!=null){
            ListNode temp = head;
            while(temp!=cur){
                if(temp.val > cur.val){
                    int val = cur.val;
                    cur.val = temp.val;
                    temp.val = val;
                }
                temp = temp.next;
            }
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(6);
        ListNode e = new ListNode(0);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(3);
        a.next = b;b.next = c;c.next = d;d.next =e;e.next=f;f.next =g;g.next=h;
        ListNode head = insertSort(a);
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
