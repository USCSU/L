package LinkedIn;

/**
 * Created by Trace_route on 11/21/14.
 */
public class reverseString {
    public static String reverseStr(String s){
        if(s == null || s.length() <2) return s;
        StringBuffer sb = new StringBuffer();
        for(int i = s.length()-1;i>=0;i--){
            while(i >=0 && s.charAt(i) == ' ') i--;
            if(i<0) break;
            StringBuffer runner = new StringBuffer();
            if(sb.length()!=0) sb.append(" ");
            while(i>=0 && s.charAt(i)!=' ') runner.append(s.charAt(i--));
            sb.append(reverse(runner));
        }
        return sb.toString();
    }
    public static String reverse(StringBuffer chars){
        int low =0,  high = chars.length()-1;
        while(low < high){
            char temp = chars.charAt(low);
            chars.setCharAt(low,chars.charAt(high));
            chars.setCharAt(high,temp);
            low++; high--;
        }
        return chars.toString();
    }
    public static void main(String[] args){
        System.out.println(reverseStr("this is what   you    want "));
    }
}
