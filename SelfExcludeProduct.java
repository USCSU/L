package LinkedIn;

//Implement a method which takes an integer array and returns an integer array (of equal size) in
//        * which each element is the product of every number in the input array with the exception of the
//        * number at that index.
//        *
//        * Example:. more info on 1point3acres.com
//        *   [3, 1, 4, 2] => [8, 24, 6, 12]
//        */
//public int[] selfExcludingProduct(int[] input) {
//        // implementation...
//        }
//

public class SelfExcludeProduct {
    public static int[] selfExcludingProduct(int[] input){
        if(input == null || input.length ==0) return input;
        int size = input.length;
        int[] output = new int[size];
        for(int i = 0;i<size;i++)
            output[i] = 1;
        int left = 1, right =1;
        for(int i= 0, j = size -1;i<size;i++,j=size-1-i){
            output[i] *= left;
            left*=input[i];
            output[j]*=right;
            right*=input[j];
        }
        return output;
    }
    public static void main(String[] args) {
        int[] array = {3, 1, 4, 2};
        int[] output = selfExcludingProduct(array);
        for (int i : output)
            System.out.print(i + " ");
    }
}
