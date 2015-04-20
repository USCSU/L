package LinkedIn;

/**
 * Created by Trace_route on 11/4/14.
 */
public class EditDistance {
    public static int distanceBetweenTwoWordsRecusive(String word1, String word2){
        if(word1==null || word2 == null ) return -1;
        return helper(word1,0,word2,0);

    }
    public static int helper(String word1, int index1, String word2, int index2){
        if(index1 == word1.length()) return word2.length()- index2;
        if(index2 == word2.length()) return word1.length()-index1;
        int val =0;
        if(word1.charAt(index1) != word2.charAt(index2))
            val = 1;
        int insertion = helper(word1,index1+1, word2,index2);
        int deletion = helper(word1, index1, word2, index2 + 1);
        int raplace = helper(word1, index1 + 1, word2, index2 + 1);
        return Math.min(val+raplace, Math.min(insertion,deletion)+1);
    }
    public static int distanceBetweenTwoWords(String word1, String word2){
        int m = word1.length(),n=word2.length();
        int[][] edit = new int[m+1][n+1];

        for(int i =0;i<=m;i++){
            for(int j =0;j<=n;j++){
                edit[0][j] = j;
                edit[i][0] = i;
                if(i!=0 && j!=0){
                    int r_op = word1.charAt(i-1) == word2.charAt(j-1)?edit[i-1][j-1]:edit[i-1][j-1]+1;//replace
                    edit[i][j] = Math.min(r_op,Math.min(edit[i-1][j]+1, edit[i][j-1]+1)); //insertion and deletion
                }
            }
        }

        for(int i =0;i<=n;i++){
            System.out.println();
            for(int j=0;j<=m;j++){
                System.out.print(edit[j][i]+" ");
            }
        }
        return edit[m][n];
    }
    public static int distanceRollingArray(String word1, String word2){
        if(word1 == null || word2 ==null) return -1;
        int m = word1.length(), n = word2.length();
        int[] pre = new int[n+1];
        int[] cur = new int[n+1];
        for(int i =0;i<=n;i++){
            pre[i] = i;
        }
        for(int i =1;i<m+1;i++){
            cur[0] = i;
            for(int j = 1;j<n+1;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    cur[j] = pre[j-1];
                else{
                    cur[j] = Math.min(pre[j],pre[j-1]); //i-1,j-1; i-1,j
                    cur[j] = Math.min(cur[j],cur[j-1])+1; // i,j-1
                }
            }
            int[] t = pre;
            pre=cur;
            cur = t;
        }
        return pre[n];

    }
    public static int editDistance(String word1, String word2){
        if(word1 == null || word2==null) return -1;
        int m = word1.length(), n = word2.length();
        int[] pre = new int[n+1];
        int[] cur = new int[n+1];
        for(int i =0;i<n;i++){
            pre[i] = i;
        }
        for(int i = 1;i<=m;i++){
            cur[0] = i;
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) ==word2.charAt(j-1) ) cur[j] = pre[j-1];//i,j = i-1,j-1
                else{
                    cur[j] = Math.min(Math.min(pre[j-1],pre[j]),cur[j-1])+1; //i-1,j-1|i,j-1|i-1,j +1
                }
            }
            int[] t = pre;
            pre = cur;
            cur = t;
        }
        return pre[n];

    }
    public static void main(String[] args){
        System.out.println(distanceBetweenTwoWordsRecusive("strin787878g", "strngs"));
        System.out.println(distanceBetweenTwoWords("strin787878g", "strngs"));
        System.out.println(editDistance("strin787878g", "strngs"));
    }
}
