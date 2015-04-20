package LinkedIn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Trace_route on 12/15/14.
 */
public class mergeKListNode {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null||lists.size() ==0) return null;
        Comparator<ListNode> cmp = new Comparator<ListNode>(){
          public int compare(ListNode n1, ListNode n2){
              return n1.val-n2.val;
          }
        };
        PriorityQueue<ListNode> q= new PriorityQueue<ListNode>(cmp);
        for(ListNode node:lists){
            if(node!=null)
                q.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(!q.isEmpty()){
            ListNode cur = q.poll();
            p.next = cur;
            if(cur.next!=null);
                q.add(cur.next);
            p = p.next;

        }
        return dummy.next;
    }
}
