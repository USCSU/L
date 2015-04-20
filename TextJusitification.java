package LinkedIn;

import java.util.ArrayList;

/**
 * Created by Trace_route on 11/7/14.
 */
public class TextJusitification {
    public static void main(String[] args){
        String[] strs= {"I'm","trying","to","solve","text","justification.","but","it's","too","boring","However,","We may have tom"};
        ArrayList<String> res = jusify(strs, 10);
        for(String s: res){
            System.out.println(s);
        }
        ArrayList<String> res1 = fullJustify(strs, 20);
        for(String s: res1){
            System.out.println(s);
        }
    }

    public static ArrayList<String> jusify(String[] words, int L){
        ArrayList<String> res = new ArrayList<String>();
         if(words ==null || words.length == 0) return res;
        int count = 0;
        int last = 0;
        for(int i =0;i<words.length;i++){
            if(count+words[i].length()+i-last > L){
                int space = 0;
                int extra = 0;
                if(i-last-1>0){
                    space = (L-count)/(i-last-1);
                    extra = (L-count)%(i-last-1);
                }
                StringBuffer sb = new StringBuffer();
                for(int j = last;j<i;j++){
                    sb.append(words[j]);
                    if(j<i-1){
                        for(int k =0;k<space;k++){
                            sb.append( " ");
                        }
                        if(extra-->0){
                            sb.append(" ");
                        }
                    }
                }
                for(int j = sb.length();j<L;j++)
                    sb.append(" ");
                res.add(sb.toString());
                last = i;
                count=0;
            }
            count+=words[i].length();
        }
        StringBuffer lastLine = new StringBuffer();
        for(int i = last;i<words.length;i++){
            lastLine.append(words[i]);
            if(lastLine.length()<L){
                lastLine.append(" ");
            }
        }
        for(int i = lastLine.length();i<L;i++)
            lastLine.append(" ");
        res.add(lastLine.toString());
        return res;
    }
    public static ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        if(words == null || words.length == 0) return res;
        int count = 0, last = 0;
        for(int i =0;i<words.length;i++){
            if(count + i-last + words[i].length() > L){
                int space = 0, extra =0;
                if(i-last-1>0){
                    space = (L- count)/(i-last-1);
                    extra = (L- count)%(i-last-1);
                }
                StringBuffer sb = new StringBuffer();
                for(int j = last;j<i;j++){
                    sb.append(words[j]);
                    if(j < i-1){
                        for(int k =0;k<space;k++)
                            sb.append(" ");
                        if(extra-->0)
                            sb.append(" ");
                    }
                }
                for (int j = sb.length();j<L;j++)
                    sb.append(" ");
                res.add(sb.toString());
                count=0;
                last = i;
            }
            count+=words[i].length();
        }
        StringBuffer lastLine = new StringBuffer();
        for(int i = last;i<words.length;i++){
            lastLine.append(words[i]);
            if(lastLine.length()<L)
                lastLine.append(" ");
        }
        for(int i = lastLine.length();i<L;i++)
            lastLine.append(" ");
        res.add(lastLine.toString());
        return res;
    }
}
