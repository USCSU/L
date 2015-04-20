package LinkedIn;

/**
 * Created by Trace_route on 11/5/14.
 */
public class tansformTree {
    public static TreeNode flipTree(TreeNode root){
        if(root ==null) return null;
        if(root.left == null || root.right ==null) return root;
        TreeNode newRoot = flipTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right =null;
        return newRoot;
    }
    public static TreeNode flipTree1(TreeNode root){
        if(root == null) return null;
        if(root.left == null || root.right == null) return root;
        TreeNode newRoot = flipTree1(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left =null;
        root.right = null;
        return newRoot;
    }
    public static TreeNode arrayToBST(int[] array, int low, int high){
        if(low >= high) return null;
        int mid = (low+high)/2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = arrayToBST(array,0, mid-1);
        node.right = arrayToBST(array,mid+1,0);
        return node;
    }
    public static void printBST(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        printBST(root.left);
        printBST(root.right);
    }
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        a.left = b;
        a.right = c;
        b.left =d;
        b.right =e;
        d.left = f;
        d.right = g;
        printBST(a);
        System.out.println();
        printBST(flipTree1(a));
    }
}
