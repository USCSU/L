package LinkedIn;

import java.util.ArrayList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}
public class PrintTreeVertically {
    static int min=0, max =0;
    public static void findMaxMin(int cur, TreeNode node){
        if(node == null) return;
        if(cur < min) min = cur;
        if(cur>max) max = cur;
        findMaxMin(cur-1,node.left);
        findMaxMin(cur+1,node.right);
    }
    public static void printNode(int cur_no, int root_no, TreeNode node){
        if(node == null) return;
        if(cur_no == root_no)
            System.out.print(node.val+" ");
        printNode(cur_no,root_no-1,node.left);
        printNode(cur_no,root_no +1, node.right);
    }
    public static void printTreeVertically(TreeNode root){
        findMaxMin(0,root);
        for(int i = min;i<=max;i++){
            printNode(i,0,root);
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> getAllPaths(TreeNode root){
        if(root == null) throw new IllegalArgumentException();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        helper(ret,new ArrayList<Integer>(),root);
        return ret;
    }
    public static void helper(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> temp, TreeNode root){
        //base
        temp.add(root.val);
        if(root.left==null && root.right==null){
            ret.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        //recursive
//        temp.add(root.val);
        if(root.left!=null)
        helper(ret,temp,root.left);
        if(root.right!=null)
        helper(ret,temp,root.right);
        temp.remove(temp.size()-1);
    }
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        f.right = h;
        g.right = i;
        printTreeVertically(a);
        System.out.println(getAllPaths(a));
    }
}
