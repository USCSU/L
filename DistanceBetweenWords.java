package LinkedIn;

/**
 * Created by Garvin on 10/21/2014.
 */
public class DistanceBetweenWords {
    public static int minDisBetweenWordsHelper(String[] list, String a, String b){
        if(list == null || list.length <2) return -1;
        int min = Integer.MAX_VALUE;
        int posA = -1, posB = -1;
        for(int i =0;i<list.length;i++){
            if(list[i].equals(a)){
                posA = i;
                if(posB != -1){
                    if(posB - posA < 0) min = -1;
                    else
                        min = Math.min(min, posB - posA);
                }
            }
           else if(list[i].equals(b)){
                posB =i;
                if(posA != -1){
                    if(posB - posA < 0) min = -1;
                    else
                    min = Math.min(min, posB - posA);
                }
            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
    public static int minDis(String s, String a, String b){
        if(s ==null||s.isEmpty()) return -1;
        String[] list = s.split(" ");

        return minDistance(list,a,b);
    }
    public static int minDistance(String[] list, String a, String b){
        if(list == null|| list.length < 2) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int posA = -1, posB = -1;
        for(int i =0;i<list.length;i++){
            if(list[i].equals(a)){
                posA = i;
                if(posB!=-1){
                    min = Math.min(min,posB-posA);
                }
            }
            else if(list[i].equals(b)){
                posB = i;
                if(posA !=-1){
                    min = Math.min(min,posB -posA);
                }
            }
        }
        return min ;
    }
    //only output positive distance val
    public static int wordDistance(String s, String word1, String word2) {
        //error checking
        if(s == null || word1 == null || word2 == null || s.length()<2) return -1;
        String[] strings = s.split(" ");

        return wordDistanceHelper(strings,word1,word2);
    }
    public static int wordDistanceHelper(String[] strings, String word1 , String word2){
        int posA = -1, posB =-1;
        int min = Integer.MAX_VALUE;
        for(int i =0;i< strings.length;i++){
            String cur = strings[i];
            if(cur.equals(word1)){
                posA = i;
                if(posB !=-1){
                    min = Math.min(min,Math.abs(posA - posB));
                }
            }
            if(cur.equals(word2)){
                posB = i;
                if(posA !=-1){
                    min = Math.min(min, Math.abs(posA-posB));
                }
            }
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
    public static void main(String[] args){
        String s = "hello how are you";
        System.out.println(wordDistance(s,"hello","you"));
        String s1= "hello how are hello you";
        System.out.println(wordDistance(s1,"hello","you"));
        String s2= "you are hello";
        System.out.println(wordDistance(s2,"hello","you"));
        String s3= "hello how are hello";
        System.out.println(wordDistance(s3,"hello","you"));

    }
}
