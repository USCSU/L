package LinkedIn;

/**
 * Created by Trace_route on 11/3/14.
 */
public class Sqrt {
    public int sqrt(int x){
        long low = 0, high = x;
        while(low <= high){
            long mid = low + (high - low) /2;
            if(x<mid*mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }

        }
        return (int)high;
    }
}
