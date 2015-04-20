package LinkedIn;

/**
 * Created by Trace_route on 11/22/14.
 */
public class ReverseWordsRecursively {
    public static String reverseWord(String s){
        if(s == null || s.length()<1) return s;
        char[] chars = s.toCharArray();
        reverseHelper(chars,0,chars.length-1);
        return String.valueOf(chars);
    }
    public static void reverseHelper(char[] s, int low, int high){
        if(low>high) return;
        char temp = s[high];
        s[high] = s[low];
        s[low] = temp;
        reverseHelper(s,low+1,high-1);
    }
    public static void main(String[] args){
        System.out.print( reverseWord("t"));
    }
}
