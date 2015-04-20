package LinkedIn;

//public interface FirstCommonAncestor {
//
//    /**
//     * Given two nodes of a tree,
//     * method should return the deepest common ancestor of those nodes.
//     *. 1point3acres.com/bbs
//     *          A
//     *         / \
//     *        B   C
//     *       / \
//     *      D   E.
//     *         / \
//     *        G   F
//     *
//     *  commonAncestor(D, F) = B
//     *  commonAncestor(C, G) = A.
//     *  commonAncestor(E, B) = B.
//     */-google 1point3acres
//    Node commonAncestor(Node one, Node two);
//}
//
//class Node {
//
//    final Node parent;
//    final Node left;
//    final Node right;
//
//
//    public Node(Node parent, Node left, Node right) {
//        this.parent = parent;
//        this.left = left;
//        this.right = right;
//    }
//
//    bool isRoot() {
//
//        return parent == null;
//    }
//}
class  Node{
    int val;
     Node parent;
     Node left;
     Node right;
    public Node(int val){
        this.val = val;
        parent = null;
        left = null;
        right = null;
    }
    public Node(Node parent, Node left, Node right){
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    boolean isRoot(){
        return parent ==null;
    }

}
public class FindCommonAncester {
    public static void main(String[] args){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.parent = null;
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        e.right = f;
        b.parent = a;
        c.parent =a;
        d.parent =b;
        e.parent =b;
        g.parent = e;
        f.parent = e;
        System.out.println((char)(commonNode(a,d,f).val-1 +'a'));
        System.out.println((char)(commonNode(a,c,g).val-1+'a'));
        System.out.println((char)(commonNode(a,e,b).val-1+'a'));
    }
    public static Node commonNode(Node root, Node x, Node y ){
        Node n1 = x, n2 = y;
        int dis1 = 0, dis2 = 0;
        while(n1!=root){
            dis1++;
            n1=n1.parent;
        }
        while(n2!=root){
            dis2++;
            n2=n2.parent;
        }
        if(dis1 < dis2)
            return helper1(root,x,y,dis1,dis2);
        else
            return helper1(root,y,x,dis2,dis1);
    }
    public static Node helper1(Node root, Node x, Node y , int dis1, int dis2){
        int dis = dis2 - dis1;
        while(dis-->0){
            y = y.parent;
        }
        while(!x.equals(y)){
            x = x.parent;
            y = y.parent;
        }
        return x;
    }
    public static Node commonAncester(Node root, Node x, Node y){
        Node n1 = x, n2 = y;
        int dis1 = 0,dis2 =0;
        while(n1!=root){
            dis1++;
            n1=n1.parent;
        }
        while(n2 !=root){
            dis2++;
            n2=n2.parent;
        }
        if(dis1<dis2)
        return helper(root,x,y,dis1,dis2);
        return helper(root,y,x,dis2,dis1);
    }
    public static Node helper(Node root, Node n1, Node n2, int dis1, int dis2){
//        System.out.println( (char)(n1.val + 'a'));
//        System.out.println( (char)(n2.val + 'a'));
        System.out.println("--------");
        int diff = dis2 - dis1;
        while(diff>0){
            n2 = n2.parent;
            diff--;
        }
        while(!n1.equals(n2)){
            n1 = n1.parent;
            n2 = n2.parent;
        }
        return n1;
    }
}
