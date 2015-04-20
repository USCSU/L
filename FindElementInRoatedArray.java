package LinkedIn;

/**
 * Created by Trace_route on 11/2/14.
 */
public class FindElementInRoatedArray {
    //find min in rotated array
    public static int findMinInRotatedArray(int[] num){
        if(num == null || num.length <1) return -1; // no element in array
        int low = 0, high = num.length-1;
        while(low<high){
            if(num[low] < num[high]) //normal order then return small val
                return num[low];
            int mid = low + (high- low)/2;
            if(num[mid] >= num[low]) // low > high && mid > low, then the val must be on right
                low = mid +1;
            else high = mid; //low > high && mid < low, then the val must be on left;
        }
        return num[low]; // low must be the smallest val;
    }
    public static int findMax(int[] num) {
        int start=0,end=num.length-1;

        while (start<end) {
            if (num[start]<num[end])
                return num[end];

            int mid = (start+end)/2;

            if (num[mid]>num[start]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return num[end];
    }
    //find min "INDEX" in rotated repeated array
    public static int findMinInRotatedArrayRepeated(int[] num){
        int low =0, high = num.length -1;
        while(low <high){
            if(num[low]<num[high])
                return low;
            int mid = low + (high-low)/2;
            if(num[mid] > num[low]) //low >= high && mid > low, then small val must be on right
                low = mid+1;
            else if(num[mid] < num[low]) //low >= high && mid <low, then small val must be on left
                high = mid;
            else //mid == low && low >= high
//                low = low +1;
                low = mid;
        }
        return low;
    }
    //find target "INDEX" in rotated array
    public static int findTargetInRotatedArray(int[] num, int target){
        if(num == null || num.length <1) return -1;
        return findTargetInRotatedArrayHelper(num, target,0,num.length-1);
    }
    public static int findTargetInRotatedArrayHelper(int[] num, int target, int low, int high){
        int mid = low + (high-low)/2;
        if(low > high) return -1; //no found
        if(num[mid] == target) return mid; //found
        if(num[mid] > num[low]){ //left side is normal ordered: eg: 123
            if(target >= num[low] && target <= num[mid]){ //search left
                return findTargetInRotatedArrayHelper(num, target,low, mid-1);
            }else //search right
                return findTargetInRotatedArrayHelper(num, target,mid+1,high);

        }else{ //right side is normal ordered // mid < low eg: 312
            if(target >= num[mid] && target<=num[high]) // search right
                return findTargetInRotatedArrayHelper(num, target,mid+1,high);
            else
                return findTargetInRotatedArrayHelper(num, target,low, mid-1);
        }
    }
    //find target in rotated repeated array
    public static int findTargetInRotatedRepeatedArray(int[] num, int target){
        if(num == null || num.length <1) return -1;
        return findTargetInRotatedRepeatedArray(num,target,0,num.length-1);
    }
    public static int findTargetInRotatedRepeatedArray(int[] num, int target, int low, int high){
        if(low > high) return -1;
        int mid = low+ (high-low)/2;
        if(num[mid] == target) return mid;
        if(num[mid] > num[low]){//left side is in normal order
            if(target >=  num[low] && target <= num[mid])
                return findTargetInRotatedRepeatedArray(num,target,low, mid-1); //search left;
            else
                return findTargetInRotatedRepeatedArray(num, target,mid+1,high);//search right

        }else if(num[mid]<num[low]){ //right side is in normal order
            if(target >= num[mid] && target <= num[high])
                return findTargetInRotatedRepeatedArray(num, target,mid+1,high); //search right;
            else
                return findTargetInRotatedRepeatedArray(num,target,low, mid-1); //search left;

        }else{ //mid = low//check if right side is diff; or check both side
            if(num[mid]!=num[high])
                return findTargetInRotatedRepeatedArray(num, target,mid+1,high); //search right;
            //check both
            else {
                int result =  findTargetInRotatedRepeatedArray(num,target,low, mid-1); //search left;
                if(result == -1)
                     return findTargetInRotatedRepeatedArray(num,target,mid+1, high); //search left;
                else return result;
            }


        }
    }

    //find char
    public static char findCharInArray(char[] array, char c){
        if(array == null || array.length <1 )return '#'; // ERROR CODE
        int low = 0, high = array.length -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(array[mid] == c){
                if(mid < array.length -1) return array[mid+1];
                else return array[0];
            }
            if(array[mid] > c){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        if(low ==0 || low == array.length) return array[0];
        else return array[low];
    }
    public static void main(String[] args){
        int[] array = {6,6,6,6,7,1,2,2,2,3,4,4,4,4,5};
        int[] t = {4,5,6,7,0,2};
        int[] test = {1,2,3,4,5};
        int[] test1 = {11,2,5,8,9,10};
//        System.out.println(findMinInRotatedArray(t));
//        System.out.println(findMax(t));
//        System.out.println(findMinInRotatedArray(test));
//        System.out.println(findMax(test));
//        System.out.println(findMinInRotatedArray(test1));
//        System.out.println(findMax(test1));
//        System.out.println(findTargetInRotatedArray(t,6));
//        System.out.println(findTargetInRotatedArray(test,6));
//        System.out.println(findTargetInRotatedArray(test1,8));
//        System.out.println("------");
//        System.out.println(findTargetInRotatedRepeatedArray(array,2));
//        System.out.println(findTargetInRotatedRepeatedArray(array,5));
//        System.out.println(findTargetInRotatedRepeatedArray(array,7));
//        System.out.println(findTargetInRotatedRepeatedArray(array,3));
//        System.out.println(findTargetInRotatedRepeatedArray(array,4));
//        System.out.println("********");
//        char [] c1 = {'c', 'f', 'j', 'p', 'v'};
//        char [] c2 = {'c', 'f', 'k'};
//        System.out.println(findCharInArray(c1,'a'));
//        System.out.println(findCharInArray(c1,'c'));
//        System.out.println(findCharInArray(c1,'k'));
//        System.out.println(findCharInArray(c1,'z'));
//        System.out.println(findCharInArray(c2,'f'));
//        System.out.println(findCharInArray(c2,'c'));
//        System.out.println(findCharInArray(c2,'d'));
//        System.out.println(findIndexInRotatedArray(array,5));
//        System.out.println(findIndexInRotatedArray(array,2));
//        System.out.println(findIndexInRotatedArray(array,7));
//        System.out.println(findIndexInRotatedArray(array,3));
//        System.out.println(findIndexInRotatedArray(array,4));
        System.out.println(findMinInRotatedArrayRepeated(array));
    }
}
