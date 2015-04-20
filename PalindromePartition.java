package LinkedIn;

import java.util.ArrayList;

/**
 * Created by Trace_route on 12/12/14.
 */
public class PalindromePartition {
    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        if(s == null) return ret;
        helper(ret,new ArrayList<String>(),s);
        return ret;
    }
    public static void helper(ArrayList<ArrayList<String>> ret, ArrayList<String> runner,String s){
        if(s.isEmpty()){
            ret.add(new ArrayList<String>(runner));
//            runner.remove(runner.size()-1);
            return;
        }
        for(int i =1;i<=s.length();i++){
            if(validPalindrome(s.substring(0,i))){
                runner.add(s.substring(0,i));
                helper(ret,runner,s.substring(i));
                runner.remove(runner.size()-1);
            }
        }
    }
    public static boolean validPalindrome(String s){
        if(s ==null) return false;
        int low =0,high=s.length()-1;
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)) return false;
            low++;
            high--;
        }
        return true;
    }
    public static void main(String[] args){
        String s = "aab";
        System.out.println(partition(s));
    }
}
