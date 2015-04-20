package LinkedIn;

/**
 * Created by Trace_route on 11/3/14.
 */
public class IntegerToRoman {
    public static String intToRoman(int num) {
        String res= "";
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] value = {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1};
        for(int i =0;num!=0;i++){
            while(num >= value[i]){
                num-=value[i];
                res+=symbol[i];
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(intToRoman(499));
        System.out.println(romanToInt(intToRoman(429    )));
    }
    public static int trans(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default:return 0;
        }
    }
    public static int romanToInt(String s){
        int result = 0;
        for(int i =0;i<s.length();i++){
            if(i>0 && trans(s.charAt(i)) > trans(s.charAt(i-1)))
                result += (trans(s.charAt(i))- 2*trans(s.charAt(i-1)));
            else
                result+=trans(s.charAt(i));
        }
        return result;
    }
}
