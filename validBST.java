package LinkedIn;

/**
 * Created by Trace_route on 12/12/14.
 */
public class validBST {
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
    public static boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE-1L, Integer.MAX_VALUE+1L);
    }

    public static boolean helper(TreeNode root, long min, long max){
        if (root==null) return true;
        if (root.val<=min || root.val>=max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
    public static void main(String[] args)
    {
        int[] num = {2147483647};
        TreeNode root = sortedArrayToBST(num);
        System.out.println(isValidBST(root));
    }
}
