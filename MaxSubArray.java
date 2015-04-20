package LinkedIn;

/**
 * Created by Trace_route on 11/1/14.
 */
public class MaxSubArray {
    public static int maxProductSubArray(int[] array){
        int min = array[0], max = array[0], result = array[0];
        for(int i =1;i<array.length;i++){
            int min_copy = min, max_copy = max;
            min = Math.min(Math.min(array[i], min_copy*array[i]),max_copy*array[i]);
            max = Math.max(Math.max(array[i], min_copy*array[i]),max_copy*array[i]);
            result = Math.max(max,result);
        }
        return result;
    }
    public static int MaxProduct(int[] array){
        int min = array[0], max = array[0],result = array[0];
        for(int i = 1;i<array.length;i++){
            int mn = min, mx = max;
            max = Math.max(array[i],Math.max(mn*array[i],mx*array[i]));
            min = Math.min(array[i],Math.min(mn*array[i],mx*array[i]));
            result = Math.max(max,result);
        }
        return result;
    }
    public static int[] getMaxSumIndexes(int[] array){
        int max = array[0], sum = array[0];
        int start = 0, end = 0;
        int tempStart =0, tempEnd =0;
        for(int i =1;i<array.length;i++){
            if(sum+array[i] > array[i]){
                sum = sum+array[i];
                tempEnd = i;
            }else{
                sum = array[i];
                tempStart = i;
            }

            if(max < sum){
                max = sum;
                end = tempEnd;
                start = tempStart;
            }

        }
        int[] res = new int[2];
        res[0] = start;
        res[1] = end;
        return res;
    }
    public static int sumSubArray(int[] array){
        if(array == null) return Integer.MIN_VALUE;
        int sum = array[0], max = array[0];
        for(int i = 1;i<array.length;i++){
            sum = Math.max(array[i] + sum, array[i]);
            max = Math.max(max,sum);
        }
        return max;
    }
    public static void main(String[] args){
        int[] array = {-2,1,-3,4,-1,2,1,-8,4,5,6,-1,10};
        int[] array1 = {-1,-2,-3,-4,-1};
//        System.out.println(getMaxSubArraySum(array));
        System.out.println(sumSubArray(array));
        System.out.println(sumSubArray(array1));
        int[] test = getMaxSumIndexes(array1);
        System.out.println(maxProductSubArray(array));
        System.out.println(maxProductSubArray(array1));
        System.out.println(test[0] + "--" + test[1]);
    }
}
