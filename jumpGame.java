package LinkedIn;

/**
 * Created by Trace_route on 12/14/14.
 */
public class jumpGame {
    public static boolean jumpI(int[] num){
        if(num == null || num.length ==0) return false;
        int max = 0;
        for(int i =0;i<num.length;i++){
            if(max >num.length-2) return true;
            if(max <=i && num[i] ==0) return false;
            max = Math.max(max,i+num[i]);
        }
        return false;
    }
    public static int jumpII(int[] num){
        if(num == null || num.length ==0) return 0;
        return 1;
    }

    public static  int jump(int[] A) {
        int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = Math.max(curr, i+A[i]);
            if(curr>=A.length-1) break;
        }

        return ret;
    }
    public static void main(String[] args){
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

}
