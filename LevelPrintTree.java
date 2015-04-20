package LinkedIn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Trace_route on 11/2/14.
 */
public class LevelPrintTree {

    public static ArrayList<ArrayList<Integer>> printTreeByLevel(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int curLevel = 0;
        int nextLevel =0;
        q.add(root);
        curLevel++;
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            curLevel--;
            if(top!=null){
                temp.add(top.val);
                q.add(top.left);
                q.add(top.right);
                nextLevel+=2;
            }
            if(curLevel ==0){
                curLevel = nextLevel;
                nextLevel = 0;
                if(!temp.isEmpty())
                    res.add(temp);
                temp = new ArrayList<Integer>();
            }
        }

        return res;
    }
    static int min = 0, max =0;
    public static void printTreeVertically(TreeNode root){
        if(root ==null) return;
        findMinMax(root,0);
        for(int i = min;i<=max;i++){
            printNode(root,i,0);
            System.out.println();
        }
    }
    public static void findMinMax(TreeNode root, int cur){
        if(root == null) return;
        min = Math.min(cur,min);
        max = Math.max(cur, max);
        findMinMax(root.left, cur-1);
        findMinMax(root.right, cur+1);
    }
    public static void printNode(TreeNode root, int cur, int root_no){
        if(root == null) return;
        if(root_no == cur)
            System.out.print(root.val);
        printNode(root.left,cur,root_no-1);
        printNode(root.right,cur,root_no+1);
    }
    public static ArrayList<Integer> printNodeWtihArrayList(TreeNode root, int cur, int root_no){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root ==null) return res;
        if(root_no == cur){
            res.add(root.val);
        }
        res.addAll(printNodeWtihArrayList(root.left,cur,root_no-1));
        res.addAll(printNodeWtihArrayList(root.right, cur, root_no + 1));
        return res;
    }
    public static ArrayList<ArrayList<Integer>> printNodeVerticallyWithArray(TreeNode root, int root_no){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        findMinMax(root,root_no);
        for(int i = min;i<=max;i++){
            res.add(printNodeWtihArrayList(root,i,root_no));
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> printTreeFromBottomByLevel(TreeNode root){
        LinkedList<ArrayList<Integer>> res = new LinkedList<ArrayList<Integer>>();
        if(root == null) return new ArrayList<ArrayList<Integer>>(res);
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> collector = new ArrayList<Integer>();
        int curLevel = 0;
        int nextLevel =0;
        q.add(root);
        curLevel++;
        while(!q.isEmpty()){
            TreeNode top = q.poll();
            curLevel--;
            if(top!=null){
                collector.add(top.val);
                q.add(top.left);
                q.add(top.right);
                nextLevel+=2;
            }
            if(curLevel == 0){
                if(!collector.isEmpty())
                    res.addFirst(collector);
                collector = new ArrayList<Integer>();
                curLevel = nextLevel;
                nextLevel =0;
            }
        }
        return new ArrayList<ArrayList<Integer>>(res);
    }

    public static ArrayList<ArrayList<Integer>> printTreeByZigZag(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) return res;
        boolean zig = true;
        Stack<TreeNode> cur = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        cur.add(root);
        while(!cur.isEmpty()){
            TreeNode  top = cur.pop();
            if(top!=null){
                if(zig){
                   next.add(top.left);
                   next.add(top.right);
                }else{
                    next.add(top.right);
                    next.add(top.left);
                }
                temp.add(top.val);
            }
            if(cur.isEmpty()){
                zig=!zig;
                Stack<TreeNode> o = cur;
                cur = next;
                next = o;
                if(!temp.isEmpty()) res.add(temp);
                temp = new ArrayList<Integer>();
            }
        }
        return res;
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
//        printTreeVertically(a);
//        System.out.println(printNodeVerticallyWithArray(a,0));
//        System.out.println(printTreeByLevel(a));
//        System.out.println(printTreeFromBottomByLevel(a));
//        System.out.println(printTreeByZigZag(a));
    }
}
