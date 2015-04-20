package LinkedIn;

import java.util.ArrayList;

/**
 * Created by Trace_route on 11/4/14.
 */
public class GetMirrorTree {
    public static TreeNode mirror(TreeNode root){
        if(root == null) return null;
        TreeNode cur = new TreeNode(root.val);
        cur.left = mirror(root.right);
        cur.right = mirror(root.left);
        return cur;
    }
    public static TreeNode getBST(int[] array){
        int low = 0, high = array.length -1;
        return helper(array,low,high);
    }
    public static TreeNode helper(int[] array, int low, int high){
        if(low > high) return null;
        int mid = low + (high-low)/2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = helper(array,low,mid-1);
        root.right = helper(array,mid+1,high);
        return root;

    }
    public static void printTree(TreeNode root){
        if(root == null) return;
        printTree(root.left);
        System.out.print(" "+root.val);
        printTree(root.right);
    }

    public static void main(String[] args){

        int[] array = {1,2,3,4,5,6,7};
        TreeNode root = getBST(array);
        printTree(root);
        System.out.println("\n-----");
        printTree(mirror(root));
    }
}
