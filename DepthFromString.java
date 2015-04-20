package LinkedIn;

import java.util.Stack;

/**
 * Created by Trace_route on 11/18/14.
 */
public class DepthFromString {
    public enum State {
        EXPECT_LEFT_CHILD, EXPECT_RIGHT_CHILD, EXPECT_RIGHT_BRACKET
    }

    public static int findDepth(char[] s) {
        if (s.length == 0 || s[0] != '(')
            return -1;
        Stack<Character> stack = new Stack<Character>();
        Stack<State> states = new Stack<State>();
        int i = 0;
        int maxDepth = 0;
        stack.push(s[i++]);
        states.push(State.EXPECT_LEFT_CHILD);
        while (!stack.isEmpty() && !states.isEmpty()) {
            if (i == s.length)
                break;
            State state = states.peek();
            char c = s[i];
            switch (state) {
                case EXPECT_LEFT_CHILD:
                case EXPECT_RIGHT_CHILD:
                    if (c != '(' && c != '0')
                        return -1;
                    stack.push(c);
                    if (c == '(') {
                        states.push(State.EXPECT_LEFT_CHILD);
                    } else if (c == '0') {
                        states.pop();
                        states.push(state == State.EXPECT_LEFT_CHILD ? State.EXPECT_RIGHT_CHILD
                                : State.EXPECT_RIGHT_BRACKET);
                    }
                    break;
                case EXPECT_RIGHT_BRACKET:
                    if (c != ')')
                        return -1;
                    states.pop();
                    char t = stack.peek();
                    while (t != '(')
                        t = stack.pop();
                    if (states.size() > 0) {
                        states.push(states.pop() == State.EXPECT_LEFT_CHILD ? State.EXPECT_RIGHT_CHILD
                                : State.EXPECT_RIGHT_BRACKET);
                    }
                    break;
            }
            maxDepth = Math.max(maxDepth, states.size());
            i++;
        }

        return i == s.length ? maxDepth - 1 : -1;
    }

    public static int getDepth(String s){
        if(s == null || s.length() ==0) return -1;
        Stack<Character> stack = new Stack<Character>();
        int depth= -1;
        int max = -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push('(');
                depth++;
                max = Math.max(max,depth);
            }else if(c ==')'){
                if(stack.size()<3) return -1;
                if(stack.peek()!='0') return -1;
                stack.pop();
                if(stack.peek()!='0') return -1;
                stack.pop();
                if(stack.peek()!='(') return -1;
                stack.pop();
                depth--;
                stack.push('0');
            }else if(c =='0'){
                stack.push('0');
            }else return -1;
        }
        if(stack.size() == 1) return max;
        else return -1;
    }
    static int find_depth(String s){
        int size = s.length();
        if(size == 0)	return -1;
        Stack<Character> ss = new Stack<Character>();
        int depth = -1;
        int maxDep = -1;
        for(int i = 0; i < size; i++){
            char c = s.charAt(i);
            if(c == '('){
                ss.push(c);
                depth++;
                maxDep = Math.max(maxDep, depth);
            }else if(c == ')'){
                if(ss.size() < 3)	return -1;
                if(ss.peek() != '0')	return -1;
                ss.pop();
                if(ss.peek() != '0')	return -1;
                ss.pop();
                if(ss.peek() != '(')	return -1;
                ss.pop();
                depth--;
                ss.push('0');
            }else if(c == '0'){
                ss.push(c);
            }else{
                return -1;
            }
        }
        if(ss.size() == 1)	return maxDep;
        return -1;
    }
    public static int getDepth1(String s){
        if(s == null||s.length() <1) return -1;
        int depth =-1, maxDepth =-1;
        Stack<Character> stack = new Stack<Character>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
                depth ++;
                maxDepth = Math.max(depth,maxDepth);
            }else if(c=='0'){
                stack.push('0');
            }else if(c==')'){
                if(stack.size()<3) return -1;
                if(stack.peek() != '0') return -1;
                    stack.pop();
                if(stack.peek() !='0') return -1;
                    stack.pop();
                if(stack.peek() != '(') return -1;
                    stack.pop();
                depth--;
                stack.push('0');

            }else return -1;
        }
        return stack.size() == 1?maxDepth:-1;
    }
    public static void main(String[] args) {
        String[] ss = { "(00)", "((00)0)", "((00)(00))", "((00)(0(00)))",
                "((00)(0(0(00))))", "x", "0", "()", "(0)", "(00)x", "(0p)",
                "((00)(0(00))))", "((00)(0(000)))", "((00)(0((00)0)))","(00)(00)(00)" };
//        for (String s : ss) {
//            int depth = findDepth(s.toCharArray());
//            System.out.println(s + ": " + depth);
//        }
//        System.out.println();
        for (String s : ss) {
            int depth = getDepth1(s);
            System.out.println(s + ": " + depth);
        }
    }
}
