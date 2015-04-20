package LinkedIn;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        next = null;
    }
}
public class SortedListToBST {

    public static TreeNode helper(ListNode head){

        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode pre = slow;
        ListNode fast = head;
        while(fast!=null && fast.next !=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
//        System.out.println(pre.val);// pre: 3; slow:4
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;

        root.left = helper(head);
        root.right = helper(slow.next);
        return root;

    }
    public static void printTree(TreeNode root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(" "+root.val);
        printTree(root.right);
    }
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ListNode dummy = new ListNode(-1);
        ListNode mark = dummy;
        for (int i : array) {
            ListNode temp = new ListNode(i);
            mark.next = temp;
            mark = mark.next;
        }
        TreeNode root = helper(dummy.next);
        printTree(root);
    }
}
