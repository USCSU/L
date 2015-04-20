package LinkedIn;

import java.util.ArrayList;

/**
 * Created by Trace_route on 11/6/14.
 */
public class CanIWin {
    public static boolean win(int num, int total) {
        if(num*(1+num)/2 < total) return false;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(num-->0){
            list.add(num);
        }
        return winHelper(list,total);
    }
    public static boolean winHelper(ArrayList<Integer> list, int target){
        //base
        if(list.isEmpty()) return false;
        for(int i =0; i<list.size();i++){
            int val = list.get(i);
            if(val >= target) return true;
            list.remove(i);
            if(!winHelper(list,target-val)) return true;
            list.add(i,val);
        }
        return false;
    }
    public static boolean canIWin(int num, int total){
        if((1+num)*num/2 < total) return false;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(num-->0){
            list.add(num);
        }
        return helper(list,total);
    }
    public static boolean helper(ArrayList<Integer> list, int target){
        boolean res = false;
        //base
        if(list.isEmpty()) return false;
        for(int i =0;i<list.size();i++){
            int val = list.get(i);
            if(val>=target) return true;
            list.remove(i);
            if(!helper(list,target-val)) return true;
            list.add(i,val);

        }
        return res;
    }
    public static void main(String[] args){
        System.out.println("+++"+canIWin(3, 3));

        System.out.println("+++"+canIWin(3, 4));
        System.out.println("+++"+canIWin(3, 5));
        System.out.println("+++"+canIWin(3, 6));
        System.out.println("+++"+canIWin(3, 8));
    }
}
