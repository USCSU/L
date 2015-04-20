package LinkedIn;

/**
 * Created by Trace_route on 12/15/14.
 */
public class nQueen {
    int total;
    public int totalNQueens(int n) {
        if(n<1) return 0;
        int[] columns = new int[n];
        total =0;
        helper(columns,n,0);
        return total;
    }
    public void helper(int[] columns, int n, int row){
        //base
        if(row == n){
            total++;
            return;
        }
        //fill in each row's array
        for(int i =0;i<n;i++){
            if(valid(columns,row,i)){
                columns[row] = i;
                helper(columns,n,row+1);
                columns[row]=-1;
            }
        }
    }
    public boolean valid(int[] columns, int row, int col){
        for(int i =0;i<row;i++){
            if(col == columns[i]) return false;
            if(Math.abs(col-columns[i]) == Math.abs(i-row)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.print(new nQueen().totalNQueens(6));
    }

}
