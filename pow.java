package LinkedIn;

/**
 * Created by Trace_route on 11/3/14.
 */
public class pow {
    public static double pow(float a, int b){
        if(b == 0) return 1;
        double half = pow(a,b/2);
        if((b&1) == 0)
            return half*half;
        if(b > 0)
            return half*half*a;
        else
            return half*half/a;

    }
    public static double pow1(float a, int b){
        if(b ==0) return 1;
        double half = pow1(a,b/2);
        if((b&1) == 0){
            return half*half;
        }else if(b>0){
            return half*half*a;
        }else{
            return half*half/a;
        }
    }
    public static double pow2(double x, int n) {
        if(n == 0)
            return 1;
        double half = pow2(x,n/2);
        if(n%2 == 0)
            return half*half;
        else if(n>0)
            return half*half*x;
        else
            return half*half/x;
    }
    public static void main(String[] args){
        System.out.println(pow1(10,-7));
    }
}
