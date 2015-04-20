package LinkedIn;

import java.util.ArrayList;

/**
 * Created by Trace_route on 11/5/14.
 */
public class PermutationOnArray {
    public static void main(String[] args){
        String[] a = {"a","b","c"};
        ArrayList<String[]> res = permutation(a);
        for(String[] s:res){
            for(String str:s)
            System.out.print(str+" ");
            System.out.println();
        }
    }
    public static ArrayList<String[]> permutation(String[] s){
        ArrayList<String[]> res = new ArrayList<String[]>();
        if(s == null || s.length < 1) return res;
        helper(s,res,0);
        return res;
    }
    public static void helper(String[] s, ArrayList<String[]> res, int pos){
        //base
        if(pos == s.length){
            res.add(s.clone());
        }
        //recursive
        for(int i =pos;i<s.length;i++){
            swap(s,pos,i);
            helper(s,res,pos+1);
            swap(s,pos,i);
        }
    }

    static ArrayList<String[]> permutations(String[] a) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        permutation(a, 0, ret);
        return ret;
    }

    public static void permutation(String[] arr, int pos, ArrayList<String[]> list){
        if(arr.length - pos == 1){
            list.add(arr.clone());

            //     System.out.println(arr[0] + arr[1] +arr[2] );

        }else{
            for(int i = pos; i < arr.length; i++){
                swap(arr, pos, i);
                permutation(arr, pos+1, list);
                swap(arr, pos, i);
            }
        }
    }

    public static void swap(String[] arr, int pos1, int pos2){
        String h = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = h;
    }
}
