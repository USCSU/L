package LinkedIn;

/**
 * Created by Trace_route on 11/18/14.
 */
public class minDifferent {
    public static int minDifference(int[] x, int[] y){
        if(x == null || y == null || x.length ==0 || y.length ==0) return Integer.MAX_VALUE;
        int index1 = 0, index2 =0;
        int min = Integer.MAX_VALUE;
        while(index1<x.length && index2<y.length){
            if(x[index1] < y[index2]) {
                min = Math.min(min, y[index2] - x[index1]);
                index1++;
            }else{
                min = Math.min(min,x[index1] - y[index2]);
                index2++;
            }
        }
        return min;
    }
    public static void main(String[] args){
        int[] x = {0, 1, 2, 3, 4};
        int[] y = {5, 6, 7, 8, 9};
        System.out.println(minDifference(x,y));
    }
}
