package LinkedIn;


import LeetCode.ValidNumber;

public class JudgeStringIsNumber {
    public static boolean isNumber(String s){
        if(s == null) return false;
        s = s.trim();
        if(s.isEmpty()) return false;
        int index = 0;
        if(s.charAt(index) == '+' || s.charAt(index) == '-') index++;
        boolean dot = false;
        boolean num = false;
        boolean exp = false;
        while(index<s.length()){
            char c = s.charAt(index);
            if(c>='0' && c<='9'){
                num = true;
            }
            else if(c == '.'){
                if(dot||exp) return false;
                dot = true;
            }
            else if(c == 'e'){
                if(exp || !num) return false;
                exp = true;
                num = false;
            }else if(c =='+' || c=='-'){
                if(s.charAt(index-1)!='e') return false;
            }else return false;
            index++;
        }
        return num;
    }
    public static void main(String[] args){
        System.out.println(isNumber("3+"));
        System.out.println(validNumber("3+"));

    }
    //no exp and space
    public static boolean validNumber(String s){
        if(s ==null) return false;
        s = s.trim();
        if(s.isEmpty()) return false;
        int index = 0;
        if(s.charAt(index) == '+' || s.charAt(index)=='-') index++;
        boolean num = false;
        boolean dot= false;
        for(int i =index;i<s.length();i++){
            char c = s.charAt(i);
            if(c >='0' && c<='9')
                num = true;
            else if(c =='.'){
                if(dot) return false;
                dot = true;
            }else return false;
        }
        return num;

    }

}
