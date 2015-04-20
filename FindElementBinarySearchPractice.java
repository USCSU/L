package LinkedIn;

/**
 * Created by Trace_route on 11/15/14.
 */
public class FindElementBinarySearchPractice {
    // find element in rotated array, no repeated val
    public static int findTargetinRotatedArray(int[] array, int target){
        if(array == null || array.length < 1) return -1;
        return findTargetinRotatedArrayHelper(array, target, 0, array.length - 1);
    }
    public static int findTargetinRotatedArrayHelper(int[] array, int target, int low, int high){
        if(low > high) return -1;
        int mid = low + (high-low)/2;
        if(array[mid] == target)
            return mid; //found
        if(array[low] < array[mid]){ // left side is normally ordered
            if(array[mid] >= target && array[low] <= target ){ //search left
                return findTargetinRotatedArrayHelper(array,target,low, mid-1);
            }else{//search right
                return findTargetinRotatedArrayHelper(array,target,mid+1,high);
            }
        }else{ // right side is normally ordered
            if(array[mid] <= target && target <= array[high]){//search right
                return findTargetinRotatedArrayHelper(array,target,mid+1, high);
            }else{//search left
                return findTargetinRotatedArrayHelper(array,target,low, mid-1);
            }
        }
    }
    public static int findTargetInRepeatedArray(int[] array, int target){
        if(array == null || array.length < 1) return -1;
        return findTargetInRepeatedArrayHelper(array, target, 0, array.length - 1);
    }
    public static int findTargetInRepeatedArrayHelper(int[] array, int target, int low, int high){
        //base
        if(low > high) return -1;
        int mid = low+ (high- low) /2;
        if(target == array[mid]) return mid;
        if(array[low]<array[mid]){ // left side is normally ordered
            if(target >= array[low] && target <= array[mid]){ // search left
                return findTargetInRepeatedArrayHelper(array,target,low,mid-1);
            }else{//search right
                return findTargetInRepeatedArrayHelper(array,target,mid+1,high);
            }
        }else if(array[low]>array[mid]){ // right side is normally ordered
            if(target >= array[mid] && target<=array[high]) // search right
                return findTargetInRepeatedArrayHelper(array,target,mid+1,high);
            else //search left
                return findTargetInRepeatedArrayHelper(array,target,low, mid-1);
        }else{//undetermined, check right side first.
            if(array[mid]!=array[high])
                return findTargetInRepeatedArrayHelper(array,target,mid+1,high);
            else {
                //search left first
                int res = findTargetInRepeatedArrayHelper(array, target, low, mid - 1);
                if (res == -1) {
                    return findTargetInRepeatedArrayHelper(array, target, mid + 1, high);
                }
                return res;
            }
        }
    }
    //find min in rotated array
    public static int findMin(int[] array){
        if(array == null || array.length < 1) return -1;
        return findMinHelper(array,0,array.length-1);
    }
    public static int findMinHelper(int[] array,int low, int high){
        if(low > high) return array[high];
        if(array[low] < array[high]) return array[low];
        int mid = low+(high - low) /2;
        if(array[mid] >= array[low])
            return findMinHelper(array,mid+1, high);
        else
            return findMinHelper(array,low,mid);
    }
    public static int findMinIterative(int[] array){
        if(array == null || array.length < 1) return -1;
        int low = 0, high = array.length-1;
        while(low<high){
            if(array[low] < array[high]) return array[low];
            int mid = low+(high-low)/2;
            if(array[mid] >= array[low]){ // low > high && mid > low --> search right
                low = mid+1;
            }else{ //low > high && mid < low
                high = mid;
            }
        }
        return array[high];
    }
    public static int findMinInRepeatedArray(int[] array){
        if(array == null || array.length < 1) return -1;
        return findMinInRepeatedArrayHelper(array,0, array.length-1);
    }
    public static int findMinInRepeatedArrayHelper(int[] array, int low, int high){
        if(low > high) return array[high];
        if(array[low] < array[high]) return array[low];
        int mid = low + (high - low) /2;
        if(array[low] < array[mid]){ //low >= high && low < mid //search right
            return findMinInRepeatedArrayHelper(array,mid+1,high);
        }else if(array[low] > array[mid]){ // low >= high && low > mid; search left
            return findMinInRepeatedArrayHelper(array,low,mid);
        }else{ //low == mid && low >=high
            return findMinInRepeatedArrayHelper(array, low+1, high);
        }
    }
    public static void main(String[] args){
        int[] array = {6,6,6,6,7,1,2,2,2,3,4,4,4,4,5};
        int[] t = {4,5,6,7,0,2};
        int[] test = {2,1};
        int[] test1 = {11,2,5,8,9,10};
//        System.out.println(findTargetinRotatedArray(t,0));
//        System.out.println(findTargetInRepeatedArray(array,6));
//        System.out.println(findTargetInRepeatedArray(array,7));
//        System.out.println(findTargetInRepeatedArray(array,5));
//        System.out.println(findTargetInRepeatedArray(array,3));
//        System.out.println(findMin(t));
//        System.out.println(findMin(test));
//        System.out.println(findMin(test1));
//        System.out.println(findMinIterative(t));
//        System.out.println(findMinIterative(test));
//        System.out.println(findMinIterative(test1));
//        System.out.println(findTargetinRotatedArray(test,1));
//        System.out.println(findTargetinRotatedArray(test1,8));
                System.out.println(findMinInRepeatedArray(array));
    }
}
