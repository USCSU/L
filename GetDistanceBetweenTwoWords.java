package LinkedIn;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Trace_route on 11/2/14.
 */
public class GetDistanceBetweenTwoWords {
    public static int minDistance(List<String> list, String A, String B){
        if(list == null || list.size() < 2) return -1;
        int min =Integer.MAX_VALUE;
        int posA = -1, posB = -1;
        for(int i = 0;i<list.size();i++){
            String s = list.get(i);
            if(s.equals(A)){
                posA = i;
                if(posB !=-1){
                    min = Math.min(posA - posB, min);
                }
            }
            if(s.equals(B)){
                posB = i;
                if(posA != -1)
                    min = Math.min(posB - posA, min);
            }
        }
        return min == Integer.MIN_VALUE?-1:min;
    }
    public static void main(String[] args){
        String[] list = {"the", "quick", "brown", "fox", "quick"};
        List<String> list1 = Arrays.asList(list);
        System.out.println(minDistance(list1,"quick","the"));
        System.out.println(minDistance(list1,"the","fox"));
    }


}
