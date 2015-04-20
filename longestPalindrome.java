package LinkedIn;

/**
 * Created by Trace_route on 12/14/14.
 */
public class longestPalindrome {
    public static String longestPalindrome(String s) {
        if(s == null || s.length()<2) return s;
        String ret = "";
        for(int i =0;i<s.length();i++){
            String temp = compare(getPalindrome(s,i-1,i+1),getPalindrome(s,i,i+1));
            ret = compare(temp,ret);
        }
        return ret;
    }
    public static String compare(String s1, String s2){
        if(s1 == null) return s2;
        if(s2 == null) return s1;
        return s1.length()>s2.length()?s1:s2;
    }
    public static String getPalindrome(String s, int low, int high){
        while(low>=0&&high<=s.length()-1){
            if(s.charAt(low)==s.charAt(high)){
                low--;
                high++;
            }
        }
        return s.substring(low+1,high);
    }
    public static void main(String[] args){

    }
}
