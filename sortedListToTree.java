package LinkedIn;

/**
 * Created by Trace_route on 12/12/14.
 */
public class sortedListToTree {
    public static TreeNode convert(ListNode head){
        if(head ==null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head, fast = head,pre = head;
        while (fast.next!=null && fast.next.next!=null){
            pre= slow;
            slow = slow.next;
            fast=fast.next.next;
        }
        fast = slow.next;
        slow.next =null;
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;
        root.left = convert(head);
        root.right = convert(fast);
        return root;
    }
    public static TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length ==0) return null;
        return helper(num,0,num.length-1);
    }
    public static TreeNode helper(int[] num, int low, int high){
        if(low>high) return null;
        int mid = low+(high-low)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num,low,mid-1);
        root.right = helper(num,mid+1,high);
        return root;
    }
    public static void print(TreeNode root){
        if(root==null) return;
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;b.next=c;
        int[] num = {1,2,3};
//        TreeNode root = convert(a);
        TreeNode root = sortedArrayToBST(num);
        print(root);
    }

}
