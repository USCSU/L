package LinkedIn;

/**
 * Created by Trace_route on 11/22/14.
 */
public class findRepeatedValMoreThanHalfTime {
    static int findCandidate(int a[], int size)
    {
        int maj_index = 0, count = 1;
        int i;
        for(i = 1; i < size; i++)
        {
            if(a[maj_index] == a[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    maj_index = i;
                    count = 1;
                }
            }
        }
        return a[maj_index];
    }

    /* Function to check if the candidate occurs more than n/2 times */
    static boolean isMajority(int a[], int size, int cand)
    {
        int i, count = 0;
        for (i = 0; i < size; i++)
            if(a[i] == cand)
                count++;
        if (count > size/2)
            return true;
        else
            return false;
    }
    public static int findCan(int[] array){
        int candidte = array[0], counter =1;
        for(int i =1;i<array.length;i++){
            if(array[i] == candidte)
                counter++;
            else
                counter--;
            if(counter==0){
                candidte = array[i];
                counter=1;
            }
        }
         counter =0;
        for(int i =0;i<array.length;i++){
            if(candidte==array[i]) counter++;
        }
        return counter>array.length/2?candidte:-1;
    }
    public static void main(String[] args){
//        int[] array = {2,1,3,2,2};
        int[] array = {1,2,1,2,1,2,2};
        System.out.print(findCan(array));
    }
}
