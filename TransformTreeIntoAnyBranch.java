package LinkedIn;

import java.util.LinkedList;

class MultiTree{
    int val;
    LinkedList<MultiTree> children;
    public MultiTree(int val){
        this.val = val;
        children = new LinkedList<MultiTree>();
    }
}
public class TransformTreeIntoAnyBranch {
    public static MultiTree transform(MultiTree root, int n){
        if(root == null || root.children.size() ==0) return root;
        LinkedList<MultiTree> bfs = new LinkedList<MultiTree>();
        bfs.add(root);
        int index = 0;
        while(index<bfs.size()){
            bfs.addAll(bfs.get(index).children);
            index++;
        }
        for(MultiTree node:bfs)
            node.children.clear();
        for(int low =0, high =1, mark = high;high<bfs.size();high++){
            if(high - mark == n){
                low++;
                mark = high;
            }
            bfs.get(low).children.add(bfs.get(high));
        }
        return bfs.get(0);
    }
    public static  MultiTree transformTreeIntoNTree(MultiTree root, int n){
        if(root ==null || root.children.size() ==0) return root;
        LinkedList<MultiTree> bfs = new LinkedList<MultiTree>();
        bfs.add(root);
        int index = 0;
        while(index<bfs.size()){
            bfs.addAll(bfs.get(index).children);
            index++;
        }
        for(MultiTree node: bfs){
            node.children.clear();
        }
        for(int low = 0, high =1, mark = high;high<bfs.size();high++){
            if(high -mark == n){
                low++;
                mark = high;
            }
            bfs.get(low).children.add(bfs.get(high));
        }

        return bfs.get(0);
    }

    public static void printTree(MultiTree root){
        if(root == null) return;
        System.out.print(root.val + " ");
        for(MultiTree node:root.children){
            printTree(node);
        }

    }

    public static void main(String[] args){
        MultiTree a = new MultiTree(1);
        MultiTree b = new MultiTree(2);
        MultiTree c = new MultiTree(3);
        MultiTree d = new MultiTree(4);
        MultiTree e = new MultiTree(5);
        MultiTree f = new MultiTree(6);
        MultiTree g = new MultiTree(7);
        MultiTree h = new MultiTree(8);
        MultiTree i = new MultiTree(9);
        MultiTree j = new MultiTree(10);
        MultiTree k = new MultiTree(11);
        MultiTree l = new MultiTree(12);
        a.children.add(b);
        a.children.add(c);
        a.children.add(d);
        b.children.add(e);
        c.children.add(f);
        c.children.add(g);
        d.children.add(h);
        h.children.add(i);
        i.children.add(j);
        i.children.add(k);
        k.children.add(l);
        printTree(a);
        System.out.println();
        printTree(transformTreeIntoNTree(a, 2));
        System.out.println();
        printTree(transform(a, 2));
    }
}
