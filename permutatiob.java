package LinkedIn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Garvin on 10/21/2014.
 */
public class permutatiob {
    public static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> array){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(array==null||array.size()<1) return res;
        return  helper(array);
    }
    public static ArrayList<ArrayList<Integer>> helper(ArrayList<Integer> array){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(array ==null) return res;
        if(array.isEmpty()){
            res.add(array);
            return res;
        }
        int num = array.get(0);
        ArrayList<ArrayList<Integer>> others = helper(new ArrayList<Integer>(array.subList(1,array.size())));
        for(ArrayList<Integer> item:others){
            for(int i =0;i<=item.size();i++){
                res.add(insertAt(item,i,num));
            }
        }
        return res;
    }
    public static ArrayList<Integer> insertAt(ArrayList<Integer> list, int index, int num){
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.addAll(list.subList(0, index));
        res.add(num);
        res.addAll(list.subList(index,list.size()));
        return res;
    }
    public static ArrayList<ArrayList<Integer>> UniqPermutation(ArrayList<Integer> array){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(array==null||array.size()<1) return res;
        return  new ArrayList<ArrayList<Integer>>(helper1(array));
    }
    public static HashSet<ArrayList<Integer>> helper1(ArrayList<Integer> array){
        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        if(array ==null) return res;
        if(array.isEmpty()){
            res.add(array);
            return res;
        }
        int num = array.get(0);
        HashSet<ArrayList<Integer>> others = helper1(new ArrayList<Integer>(array.subList(1,array.size())));
        for(ArrayList<Integer> item:others){
            for(int i =0;i<=item.size();i++){
                res.add(insertAt(item,i,num));
            }
        }
        return res;
    }
    public static ArrayList<ArrayList<Integer>> Permutatation(ArrayList<Integer> list){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(list == null || list.size() < 2) return res;
        return PermutationHelper(list,0);
    }
    public static ArrayList<ArrayList<Integer>>  PermutationHelper(ArrayList<Integer> list, int index){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //error checking
        if(list == null) return res;
        //base
        if(index == list.size()){
            res.add(new ArrayList<Integer>(list.subList(index,list.size())));
            return res;
        }
        //recurisve
        int item = list.get(index);
        ArrayList<ArrayList<Integer>> rest = PermutationHelper(list,index+1);
        for(ArrayList<Integer> sublist:rest){
            for(int i =0;i<=sublist.size();i++){

                res.add(insertAt(sublist,i,item));
            }
        }
        return res;
    }



    public static ArrayList<ArrayList<Integer>> PermutatationUniq(ArrayList<Integer> list){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(list == null || list.size() < 2) return res;
        return new ArrayList<ArrayList<Integer>>(PermutationHelperUiq(list,0));
    }
    public static HashSet<ArrayList<Integer>>  PermutationHelperUiq(ArrayList<Integer> list, int index){
        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        //error checking
        if(list == null) return res;
        //base
        if(index == list.size()){
            res.add(new ArrayList<Integer>(list.subList(index,list.size())));
            return res;
        }
        //recurisve
        int item = list.get(index);
        ArrayList<ArrayList<Integer>> rest = PermutationHelper(list,index+1);
        for(ArrayList<Integer> sublist:rest){
            for(int i =0;i<=sublist.size();i++){

                res.add(insertAt(sublist,i,item));
            }
        }
        return res;
    }


    public static void main(String[] args){
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(1);
        res.add(1);
        res.add(3);
        System.out.println(Permutatation(res));
        System.out.println(PermutatationUniq(res));
//        System.out.println(UniqPermutation(res));
    }

}
