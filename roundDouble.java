package LinkedIn;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Trace_route on 11/18/14.
 */
public class roundDouble {
    public static double round(double digit, int dots){
        if(dots<0) throw new IllegalArgumentException();
        long fac = (long)Math.pow(10,dots);
        digit*=fac;
        double tmp = Math.round(digit);
        return (double)tmp/fac;
    }
    public static double roundBigDicemal(double digit, int dots){
        if(dots<0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(digit);
        bd = bd.setScale(dots, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public static void main(String[] args){
        System.out.println(Math.round(4.4));
        System.out.println(Math.round(4.5));
        System.out.println(Math.ceil(4.4));
        System.out.println(Math.floor(4.4));
        System.out.println(round(34.123456,4));
        System.out.println(roundBigDicemal(34.123456,4));

    }
}
