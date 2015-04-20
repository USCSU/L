package LinkedIn;

/**
 * Created by Trace_route on 11/18/14.
 */
public class log {
    public static int integralPartOfLog( int n)
    {

        int ret = 0;

        while (n > 0) {
            n = n>>1;
            ret++;
        }

        return ret-1;
    }
    public static void main(String[] args){
        System.out.println(integralPartOfLog(8));
        System.out.println(7&6);
    }
}
