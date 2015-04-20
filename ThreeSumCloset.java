package LinkedIn;

/**
 * Created by Trace_route on 12/14/14.
 */
public class ThreeSumCloset {
    public static int threeSumClosest(int[] num, int target) {
        if(num == null || num.length <3) return -1;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<num.length;i++){
            int low = i+1, high = num.length-1;
            while(low<high){
                int sum = num[low]+num[i]+num[high];
                if(sum == target) return sum;
                else if(sum > target){
                    min = Math.min(min,Math.abs(sum-target));
                    high--;
                }else {
                    min = Math.min(min, Math.abs(sum - target));
                    low++;
                }
            }
        }
    return min;
    }
    public static void main(String[] args){
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }

}
