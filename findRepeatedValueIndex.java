package LinkedIn;

/**
 * Created by Trace_route on 11/22/14.
 */
public class findRepeatedValueIndex {
    public static int[] getRange(int[] array, int val){
        int[] res = new int[2];
        int index = findTarget(array,0,array.length-1,val);
        if(index ==- 1){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int low = index-1;
        int high = index+1;
        while(low>=0&&array[low] == val) low--;
        while(high<array.length&&array[high] == val) high++;
        res[0] = low+1;
        res[1] = high-1;
        return res;
    }
    public static int findTarget(int[] array, int low, int high, int val){
        if(low > high) return -1;
        int mid = low+(high-low)/2;
        if(array[mid] == val){
            return mid;
        }
        //left side is normally ordered
        if(array[low] < array[mid]){
            if(val >= array[low] && val <=array[mid]){
                return findTarget(array,low,mid-1,val);
            }else{
                return findTarget(array,mid+1,high,val);
            }
        }else if(array[low]>array[mid]){//right side is normally ordered
            if(val >= array[mid] && val <=array[high]){
                return findTarget(array,mid+1,high,val);
            }else
                return findTarget(array,low,mid-1,val);

        }else{ //array[low] == array[mid] //check both if necessary
            if(array[mid] != array[high])
                return findTarget(array,mid+1,high,val);
            else{
                int res = findTarget(array,low,mid-1,val);
                return res==-1?findTarget(array,mid+1,high,val):res;
            }
        }
    }
    public static void main(String[] args){
        int[] array = {0,0,2,3,3,3,3,4,7,7,9};
        int[] res = getRange(array,0);
        System.out.print(res[0] + " -- "+res[1]);
    }
}
