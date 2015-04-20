package LinkedIn;

import java.math.BigInteger;

/**
 * Created by Trace_route on 11/6/14.
 */
public class NonAjacentBigInteger {
    public static void main(String[] agrs){
        System.out.println(generate(1,2,3,4));
    }
    public static int generate(int n1, int n2, int n3, int n4){
        final int MOD = (int)Math.pow(10,9)+7;
        int[][][][] dp1 = new int[n1+1][n2+1][n3+1][n4+1];
        int[][][][] dp2 = new int[n1+1][n2+1][n3+1][n4+1];
        int[][][][] dp3 = new int[n1+1][n2+1][n3+1][n4+1];
        int[][][][] dp4 = new int[n1+1][n2+1][n3+1][n4+1];
        dp1[1][0][0][0] = 1;
        dp2[0][1][0][0] = 1;
        dp3[0][0][1][0] = 1;
        dp4[0][0][0][1] = 1;
        for(int i =0;i<n1+1;i++){
            for(int j =0;j<n2+1;j++){
                for(int k =0;k<n3+1;k++){
                    for(int l =0;l<n4+1;l++){
                        if(i+j+k+l > 1){
                            if(i>0)dp1[i][j][k][l] = dp2[i-1][j][k][l] + dp3[i-1][j][k][l] + dp4[i-1][j][k][l];
                            if(j>0)dp2[i][j][k][l] = dp1[i][j-1][k][l] + dp3[i][j-1][k][l] + dp4[i][j-1][k][l];
                            if(k>0)dp3[i][j][k][l] = dp1[i][j][k-1][l] + dp2[i][j][k-1][l] + dp4[i][j][k-1][l];
                            if(l>0)dp4[i][j][k][l] = dp1[i][j][k][l-1] + dp2[i][j][k][l-1] + dp3[i][j][k][l-1];
                        }
                    }
                }
            }
        }
        return dp1[n1][n2][n3][n4] +dp2[n1][n2][n3][n4] +dp3[n1][n2][n3][n4] +dp4[n1][n2][n3][n4];
    }

}
