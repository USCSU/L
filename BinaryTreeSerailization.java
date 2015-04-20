package LinkedIn;

import java.io.*;
import java.util.Scanner;

class curIndex{
    int val;
    public curIndex(){
        val =0;
    }
    public int advance(){
        return ++val;
    }
    public int getIndex(){
        return val;
    }
}
public class BinaryTreeSerailization {
    public static String BTSerial(TreeNode root){
        StringBuffer sb = new StringBuffer();
        if(root == null) {
            sb.append("#");
            return sb.toString();
        }
        sb.append(root.val);
        sb.append(BTSerial(root.left));
        sb.append(BTSerial(root.right));
        return sb.toString();
    }
    static int index =0;
    public static TreeNode BTDeserial(String s){
        if(s == null || s.isEmpty()) return null;
        if(index == s.length()) return null;
        char c = s.charAt(index);
        index++;
        if(c == '#') {
            return null;
        }
        TreeNode root = new TreeNode(c- '0');
        root.left = BTDeserial(s);
        root.right = BTDeserial(s);
        return root;
    }
    public static TreeNode deserailize(String s, curIndex cur){
        if(s == null || s.isEmpty()) return null;
        if(cur.getIndex() == s.length()) return null;
        char c = s.charAt(cur.getIndex());
        cur.advance();
        if(c == '#'){
            return  null;
        }
        TreeNode root = new TreeNode(c-'0');

        root.left = deserailize(s,cur);
        root.right = deserailize(s,cur);
        return root;

    }
    public static void preOrder(TreeNode root){
        if(root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static TreeNode deserialization(String s, curIndex i){
        if(s == null || s.isEmpty() || i.getIndex() < 0) return null;
        //base
        if(i.getIndex() == s.length()) return null;
        char c = s.charAt(i.getIndex());
        i.advance();
        if(c == '#') return null;
        TreeNode root = new TreeNode(c - '0');
        root.left = deserialization(s,i);
        root.right = deserialization(s, i);
        return root;
    }
    public static void serialization(TreeNode root, FileWriter w1, FileOutputStream w2, BufferedWriter w3){
        if(root == null){
            try {
                w1.write("+");
                return;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        try {
            w1.write(root.val);
            serialization(root.left, w1, w2, w3);
            serialization(root.right, w1, w2, w3);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static TreeNode deserialization(Scanner reader){
        if(reader == null) return null;
        String sample = reader.next();
        if(sample.equals("+")) return null;
        TreeNode root = new TreeNode( Integer.parseInt(sample));
        root.left = deserialization(reader);
        root.right = deserialization(reader);
        return root;
    }
    //Serialization Nov 21st 2014
    public static void serialization(TreeNode root, FileWriter writer){
        try {
            if(root == null){
                writer.write("#");
                return;
            }
            writer.write(root.val);
            serialization(root.left,writer);
            serialization(root.right,writer);
        }catch (Exception e){

        }
    }
    //deserialization Nov 21st 2014
    public static TreeNode deserialization1(Scanner reader){
        if(reader == null ) return null;
        String val = reader.next();
        if(val == null) return null;
        if(val == "#") return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialization1(reader);
        root.right = deserialization1(reader);
        return root;
    }
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(7);
        TreeNode e = new TreeNode(6);
        TreeNode f = new TreeNode(8);
        b.left = a;
        a.right = c;
        b.right = d;
        d.left = e;
        d.right = f;
        preOrder(b);
        String s = BTSerial(b);

        System.out.println("\n"+s);
        preOrder(deserailize(s, new curIndex()));
        System.out.println();
        preOrder(BTDeserial(s));

        System.out.println();
        preOrder(deserialization(s,new curIndex()));
    }
}
