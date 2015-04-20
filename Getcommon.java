package LinkedIn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Trace_route on 11/17/14.
 */
public class Getcommon {
    public static int CommonCharOfStrings(String[] strings){
        if(strings == null || strings.length<2) return 0;
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        for(String s: strings){
            HashSet<Character> set = new HashSet<Character>();
            for(int i =0;i<s.length();i++){
                char c = s.charAt(i);
                if(!set.contains(c)){
                    set.add(c);
                    map.put(c,map.containsKey(c)?map.get(c)+1:1 );
                }
            }
        }

        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            Character c = (Character)it.next();
            if(map.get(c) == strings.length){
                System.out.println(c);
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        String[] strings = {"aghkafgklt","dfghako","qwemnaarkf"};
        System.out.println(CommonCharOfStrings(strings));
    }
}
