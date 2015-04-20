package LinkedIn;

import java.util.HashMap;

/**
 * Created by Trace_route on 11/22/14.
 */
public class minimumStringWindow {
    public static String getMinimumWindow(String s, String t){
        if(s == null || t==null) return "";
        HashMap<Character,Integer> needToFill = new HashMap<Character, Integer>();
        HashMap<Character,Integer> hasFound = new HashMap<Character, Integer>();
        int counter =0,start = -1, end = s.length(), low =0;
        //fill maps
        for(int i =0;i<t.length();i++){
            char c = t.charAt(i);
            if(needToFill.containsKey(c)){
                needToFill.put(c,needToFill.get(c)+1);
            }else{
                needToFill.put(c,1);
                hasFound.put(c,0);
            }
        }
        //get window
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(hasFound.containsKey(c) ){
                hasFound.put(c,hasFound.get(c)+1);
                if(hasFound.get(c) <= needToFill.get(c))
                counter++;
            }
            if(counter==t.length()){
                while(!hasFound.containsKey(s.charAt(low)) || hasFound.get(s.charAt(low)) > needToFill.get(s.charAt(low))){
                    if(hasFound.containsKey(s.charAt(low)) && hasFound.get(s.charAt(low)) > needToFill.get(s.charAt(low))){
                        hasFound.put(s.charAt(low),hasFound.get(s.charAt(low))-1);
                    }
                    low++;
                }
                if(i - low < end - start){
                    end = i;
                    start = low;
                }
            }
        }

        return start==-1?"":s.substring(start,end+1);
    }
    public static void main(String[] args){
        System.out.println(getMinimumWindow("ADOBECODEBANC","ABC"));
    }
}
