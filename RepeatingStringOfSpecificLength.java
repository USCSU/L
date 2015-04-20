package LinkedIn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Trace_route on 11/6/14.
 */

public class RepeatingStringOfSpecificLength {
    public static void printRepeatingStrings(String inputString, int sequenceLength) {
        if (inputString.isEmpty() || sequenceLength <= 0 || sequenceLength >= inputString.length()) {
            System.out.println("Invalid input");
        } else {
            int i = 0;
            int j = i + sequenceLength;
            Set<String> tempSet = new HashSet<String>();
            Set<String> repeatingSequences = new TreeSet<String>();
            while (j <= inputString.length()) {

                if (!tempSet.add(inputString.substring(i, j))) {
                    repeatingSequences.add(inputString.substring(i, j));
                }
                i++;
                j = i + sequenceLength;
            }
            for (String str : repeatingSequences) {
                System.out.print(str+" ");
            }
        }
        System.out.println();
    }
    public static ArrayList<String> getRepeatedStringWithLength(String input, int len){
        ArrayList<String> res = new ArrayList<String>();
        if(input == null ||input.length()<0|| len > input.length() ) return res;
        int i =0, j = i+len;
        HashSet<String> set = new HashSet<String>();
        while(j<=input.length()){
            String s = input.substring(i,j);
            if(set.contains(s)){
               res.add(s);
            }else{
               set.add(s);
            }
            i++;
            j = i+len;
        }
        return res;
    }
    public static void main(String[] args) {
        printRepeatingStrings("ABABC", 2);
        printRepeatingStrings("AAA", 2);

        printRepeatingStrings("ABABBABBZEDZEDZE", 3);
        printRepeatingStrings("AAGATCCGTCCCCCCAAGATCCGTC", 10);
        System.out.println(getRepeatedStringWithLength("ABABC",2));
        System.out.println(getRepeatedStringWithLength("ABABBABBZEDZEDZE", 3));
        System.out.println(getRepeatedStringWithLength("AAGATCCGTCCCCCCAAGATCCGTC", 10));
        System.out.println(getRepeatedStringWithLength("AAA",2));
    }
}
