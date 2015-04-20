package LinkedIn;

/**
 * Created by Trace_route on 11/23/14.
 */
public class base62{
    public static void main(String[] args){
        System.out.println(convert(Integer.MAX_VALUE));
    }
    public static String convert(int id){
        StringBuffer sb = new StringBuffer();
        while(id>0){

           int remainder = id%62;
            id/=62;
            sb.insert(0,remainder);
            sb.insert(0," ");
        }
        return sb.toString();
    }
}
