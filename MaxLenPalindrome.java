package LinkedIn;

/**
 * Created by Trace_route on 11/5/14.
 */
public class MaxLenPalindrome {
    //recursive
    public static int MaxPalindrome(int[] array){
        if(array == null) return 0;
        int n = array.length;
//        int[][] dp = new int[n+1][n+1];
        return helper1(array,0,array.length-1);
    }
    public static int helper1(int[] array, int i, int j){
        //base
        if(j<=i) return j -i + 1;
        if(array[i] == array[j]) return 2+helper1(array,i+1,j-1);
        else return Math.max(helper1(array,i+1,j),helper1(array,i,j-1));
    }
    //dp recursive

    public static int maxPalindromeSubsequence(int[] array){
        if(array == null) return 0;
        int n = array.length;
        int[][] dp = new int[n+1][n+1];
        return helper(array,0,array.length-1,dp);
    }
    public static int helper(int[] array, int i, int j, int[][] dp){
        if(j<=i) return j-i+1;
        if(dp[i][j]!=0) return dp[i][j];
        if(array[i]==array[j]) dp[i][j]= 2+helper(array,i+1,j-1,dp);
        else dp[i][j] = Math.max(helper(array,i+1,j,dp),helper(array,i,j-1,dp));
        return dp[i][j];
    }
    //dp iterative
    public static int maxPalindromeSubSeqDpIterative(int[] array){
        if(array ==null) return 0;
        int n = array.length;
        int[][] dp = new int[n+1][n+1];
        for(int i =0;i<n+1;i++)
            dp[i][i] = 1;

        for(int i = n-1;i>0;i--){
            for(int j = i+1;j<=n;j++){
                if(array[i-1]==array[j-1]) dp[i][j] = 2+dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
            }
        }
        for(int i =0;i<dp.length;i++){
            System.out.println();
            for(int j =0;j<dp[0].length;j++)
                System.out.print(dp[i][j] +" ");
        }
        return dp[1][n];
    }
    public static void main(String[] args) {
//        int arr[] = new int[] { 1,3,1,2,3,3};
        int arr[] = new int[] { 1,3,1,2,3,3};
        int n = arr.length;
        int[][] DP = new int[n + 1][n + 1];
        int[][] backPointers = new int[n + 1][n + 1];
        for (int i = 1; i < DP.length; i++) {
            DP[i][i] = 1;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                if (arr[i - 1] == arr[j - 1]) {
                    DP[i][j] = 2 + DP[i + 1][j - 1];
                    backPointers[i][j] = 1;
                } else {
                    if (DP[i][j - 1] > DP[i + 1][j]) {
                        DP[i][j] = DP[i][j - 1];
                    } else {
                        DP[i][j] = DP[i + 1][j];
                    }
                }
            }
        }

        for(int i =0;i<DP.length;i++){
            System.out.println();
            for(int j =0;j<DP[0].length;j++)
                System.out.print(DP[i][j] +" ");
        }
        System.out.println("max palindrome length " + DP[1][n]);
        System.out.println("././././././.");
        System.out.println(maxPalindromeSubsequence(arr));
        System.out.println(maxPalindromeSubSeqDpIterative(arr));
        System.out.println(MaxPalindrome(arr));
    }
}
