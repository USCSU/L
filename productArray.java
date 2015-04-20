package LinkedIn;

/**
 * Created by Garvin on 10/21/2014.
 */
public class productArray {
    public static void productArray(int[] a){
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] res = new int[len];
        left[0] = 1;
        right[len-1] =1;
        for(int i =1;i<len;i++){
            left[i] = a[i-1]*left[i-1];
            System.out.print(left[i] +" ");
        }
        System.out.println("-----------------------");
        for(int i = len-2;i>=0;i--){
            right[i] = a[i+1]*right[i+1];
            System.out.print(right[i] +" ");
        }
        System.out.println("-----------------------");
        for(int i =0;i<len;i++) {
            res[i] = left[i] * right[i];
            System.out.print(res[i] +" ");
        }
        System.out.println("-----------------------");


    }
    public static void productArray1(int[] a){
        int[] output = new int[a.length];
        for(int i =0;i<output.length;i++)
            output[i] = 1;
        int N = a.length;
        int leftProduct = 1, rightProduct =1;
        for(int i = 0,j = N-1;i < N;i++)
        {
            output[i] *= leftProduct;
            leftProduct *= a[i];
            output[j-i] *= rightProduct;
            rightProduct *= a[j-i];
            for(int k =0;k<output.length;k++)
                System.out.print(output[k] +" ");
            System.out.println();
        }
        for(int i =0;i<output.length;i++)
            System.out.print(output[i] +" ");
    }
    public static int[] productSelf(int[] array){
        int[] output = new int[array.length];
        if(array == null || array.length < 1) return output;
        for(int i =0;i<array.length;i++)
            output[i] = 1;
        int leftProduct = 1, rightProduct = 1;
        int n = output.length;
        for(int i =0, j = n-1;i<n;i++){
            output[i]*=leftProduct;
            leftProduct*=array[i];
            output[j-i]*=rightProduct;
            rightProduct*=array[j-i];
        }
        for(int i =0;i<output.length;i++)
            System.out.print(output[i] +" ");
        return output;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
//        productArray(a);
        productSelf(a);
        System.out.println();
//        productArray1(a);
    }
}
