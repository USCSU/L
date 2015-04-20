package LinkedIn;

import java.util.Stack;

/**
 * Created by Trace_route on 11/6/14.
 */
public class maxStack extends Stack<Integer> {
//    Stack<Integer> s;
//    public maxStack(){
//        s = new Stack<Integer>();
//    }
//    public void push(int val){
//        if(val > s.peek()){
//            s.push(val);
//        }
//        super.push(val);
//    }
//    public Integer pop(){
//        if(super.empty()) return Integer.MIN_VALUE;
//        if(peek() == s.peek()){
//            s.pop();
//        }
//        return super.pop();
//    }
//    public Integer peekMax(){
//        return s.peek();
//    }
//    public Integer popMax(){
//        Stack<Integer> temp = new Stack<Integer>();
//        while(super.peek()<s.peek()){
//            temp.push(super.pop());
//        }
//        s.pop();
//        int res = super.pop();
//        while(!temp.isEmpty()){
//            super.push(temp.pop());
//        }
//        return res;
//    }
Stack<Integer> s2;
    public maxStack(){
        s2 = new Stack<Integer>();
    }
    public void push(int i){
        if(i>=max())
            s2.push(i);
        super.push(i);
    }
    public Integer pop(){
        if(super.size() ==0) return Integer.MIN_VALUE;
        int peek = super.pop();
        if(peek == max())
            s2.pop();
        return peek;
    }
    private Integer max(){
        if(s2.isEmpty()) return Integer.MIN_VALUE;
        return s2.peek();
    }
    public Integer peekMax(){
        return max();
    }
    public Integer popMax(){
        if(super.size() ==0) return Integer.MIN_VALUE;

        int max = s2.pop();
        Stack<Integer> temp = new Stack<Integer>();
        while(super.peek()!=max){
            temp.push(super.pop());
        }
        super.pop();
        while(!temp.isEmpty())
            super.push(temp.pop());
        return max;

    }
    public static void main(String[] args){
        maxStack s = new maxStack();
        int[] array = {15,15,3,4,5,3,2,6};
        for(int i:array)
            s.push(i);
        System.out.println(s);
        System.out.println(s.s2);

        System.out.println(s.peekMax());
        System.out.println(s.popMax());
        System.out.println(s);
        System.out.println(s.s2);

    }

}
