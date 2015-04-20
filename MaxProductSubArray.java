package LinkedIn;

/**
 * Created by Trace_route on 11/1/14.
 */
public class MaxProductSubArray {
    public static int MaxProduct(int[] A){
        assert A.length > 0;
        int max = A[0], min = A[0], maxAns = A[0];
        for (int i = 1; i < A.length; i++) {
            int mx = max, mn = min;
            System.out.println("A[i]: "+A[i] +"    mx*A[i]:    "+mx*A[i]+ "    mn*A[i]: " + mn*A[i]);
            max = Math.max(Math.max(A[i], mx * A[i]), mn * A[i]);
            min = Math.min(Math.min(A[i], mx * A[i]), mn * A[i]);
            System.out.println(" -->max: "+ max + " min: "+min);
            maxAns = Math.max(max, maxAns);
        }
        return maxAns;
    }
    public static void main(String[] args){
        int[] array = {2,3,0,-2,-6};
//        int[] array = {-2,1,-3,0,-1,2,1};
        System.out.println(MaxProduct(array));
    }
}
