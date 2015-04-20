package LinkedIn;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by Trace_route on 11/5/14.
 */
public class NonAjacent {


        public static void main(String[] args) {
            int[] n = {1, 1, 1, 1};
            System.out.println(generate("", n[0] + n[1] + n[2] + n[3], n));
            int[] n1 = {1, 1, 1, 1};
            String[] list = {"a","b","c"};
            ArrayList<String[]> res = permutations(list);
            for(String[] t: res){
            System.out.println();
                for(String s: t){
                    System.out.print(s+" ");
                }
            }
            int[] array = {1,2,1,1};
            System.out.println(numSeq(array));
        }


    public static int numSeq(int[] array){
        return numSeqHelper(array[0], array[1],array[2],array[3]) ;
    }

    public static  int numSeqHelper(int n1, int n2, int n3, int n4){
        final int MOD = (int)Math.pow(10,9)+7;
        int[][][][] d1 = new int[n1+1][n2+1][n3+1][n4+1];
        int[][][][] d2 = new int[n1+1][n2+1][n3+1][n4+1];
        int[][][][] d3 = new int[n1+1][n2+1][n3+1][n4+1];
        int[][][][] d4 = new int[n1+1][n2+1][n3+1][n4+1];
        d1[1][0][0][0]=1;
        d2[0][1][0][0]=1;
        d3[0][0][1][0]=1;
        d4[0][0][0][1]=1;
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                for(int k=0;k<=n3;k++){
                    for(int l=0;l<=n4;l++){
                        if (i + j + k + l > 1) {
                            if(i>0)d1[i][j][k][l]=d2[i-1][j][k][l]+d3[i-1][j][k][l]+d4[i-1][j][k][l];// % MOD;
                            if(j>0)d2[i][j][k][l]=d1[i][j-1][k][l]+d3[i][j-1][k][l]+d4[i][j-1][k][l];// % MOD;
                            if(k>0)d3[i][j][k][l]=d2[i][j][k-1][l]+d1[i][j][k-1][l]+d4[i][j][k-1][l];// % MOD;
                            if(l>0)d4[i][j][k][l]=d2[i][j][k][l-1]+d3[i][j][k][l-1]+d1[i][j][k][l-1];// % MOD;
                        }
                    }
                }
            }
        }
        return d1[n1][n2][n3][n4]+d2[n1][n2][n3][n4]+d3[n1][n2][n3][n4]+d4[n1][n2][n3][n4];
    }
        public static int generate(String num, int maxLength, int[] n) {
            if (num.length() == maxLength) {
                return Integer.parseInt(new BigInteger(num).mod(new BigInteger("1000000007")).toString());
            }

            for (int i = 1; i<=  4; i++) {
                if (n[i - 1] > 0 && (num.isEmpty() || num.charAt(num.length() - 1) - '0' != i)) {
                    n[i - 1]--;
                    int res = generate(num + i, maxLength, n);
                    if (res != -1) return res;
                    n[i - 1]++;
                }
            }
            return -1;
        }
    static ArrayList<String[]> permutations(String[] a) {
        ArrayList<String[]> ret = new ArrayList<String[]>();
        permutation(a, 0, ret);
        return ret;
    }

    public static void permutation(String[] arr, int pos, ArrayList<String[]> list){
        if(arr.length - pos == 1){
            list.add(arr.clone());

            //     System.out.println(arr[0] + arr[1] +arr[2] );

        }else{
            for(int i = pos; i < arr.length; i++){
                swap(arr, pos, i);
                permutation(arr, pos+1, list);
                swap(arr, pos, i);
            }
        }
    }

    public static void swap(String[] arr, int pos1, int pos2){
        String h = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = h;
    }
    }