package LinkedIn;

import java.util.ArrayList;
import java.util.LinkedList;


public class PermutationSeq {

    public static String getPermutation(int n, int k) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int mod = 1;
        for(int i =1;i<=n;i++){
            digits.add(i);
            mod*=i;
        }
        k--;
        StringBuilder s = new StringBuilder();
        for(int i =0;i<n;i++){
            mod/=(n-i);
            System.out.println(mod);
            int index = k/mod;
            s.append(digits.get(index));
            k=k%mod;
            digits.remove(index);
        }
        return s.toString();
    }

    public static String getPerm(int n, int k){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int mod = 1;
        for(int i =1;i<=n;i++){
            res.add(i);
            mod*=i;
        }
        k--;//Why k-- is so important;
        if(k>mod) return "ERROR:K is too large";
        StringBuffer sb = new StringBuffer();
        for(int i =n;i>0;i--){
            mod/=i;
            int index = k/mod;
            sb.append(res.get(index));
            k%=mod;
            res.remove(index);
        }
        return sb.toString();

    }
    public static void main(String[] args){

        System.out.println(getPermutation(3,6));
        System.out.println(getPerm(3,6));
    }
}
