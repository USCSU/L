package LinkedIn;

import java.util.*;

/**
 * Created by Trace_route on 11/4/14.
 */
public class validTriangle {
    // use elem repeatedly, no duplicate val invovled
    public static ArrayList<ArrayList<Integer>> valid(int[] edges){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(edges == null || edges.length <3) return res;
        Arrays.sort(edges);
        int n = edges.length;
        for(int i =0;i<n;i++){
            int k =i;
            for(int j =i;j<n;j++){
                while(n>k && edges[i]+edges[j] > edges[k]){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(edges[i]);
                    temp.add(edges[j]);
                    temp.add(edges[k]);
                    k++;
                    res.add(temp);

                }

            }
        }
        return res;
    }
    //use elem repeatedly, duplicate val invovled
    // 1. Use hash to eliminate duplicate combination
    //2. pr-process array
    public static ArrayList<ArrayList<Integer>> validTriangle(int[] list){
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        if(list == null || list.length < 3) return new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<list.length;i++){
            int k =i;
            for(int j =i;j<list.length;j++){
                while(list.length>k && list[i]+list[j]>list[k]){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(list[i]);
                    temp.add(list[j]);
                    temp.add(list[k]);
                    set.add(temp);
                    k++;
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(set);
    }
    //use elem repeatedly, duplicate val invovled
    //2. pre-process array
//    public  static ArrayList<ArrayList<Integer>> validTriangleWithDuplicate(int[] list){
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        if(list == null) return res;
//        int slow =0, fast = slow+1;
//    }

    public static int validTriangleNumber(int[] list){
        if(list == null) return 0;
        int ans=0;
        for(int i =0;i<list.length;i++){
            int k =i;
            for(int j =i;j<list.length;j++){
                while(list.length>k && list[i]+list[j]>list[k]){

                    k++;
                }
                ans+=k-j;
            }
        }
        return ans;
    }
    public static int validTriangleUniqueUse(int[] list){
        if(list == null || list.length <3) return 0;
        int ans = 0;
        for(int i =0;i<list.length-2;i++){
            int k = i+2;
            for(int j = i+1;j<list.length ;j++){
                while(list.length>k && list[i]+list[j] > list[k])
                    k++;
                ans += k - j-1;
            }
        }
        return ans;
    }
    public static int ValidUniqueUse(int[] list){
        if(list == null || list.length < 3) return 0;
        int ans = 0;
        Arrays.sort(list);
        for(int i =0;i<list.length -2;i++){
            int k = i+2;
            for(int j = i+1;j<list.length;j++){
                while(k<list.length && list[i]+list[j] > list[k])
                    k++;
                ans+= k-j-1;
            }
        }
        return ans;
    }
    public static int ValidRePeatedUse(int[] list){
        if(list == null || list.length <3) return 0;
        int ans = 0;
        Arrays.sort(list);
        for(int i =0;i<list.length;i++){
            int k =i;
            for(int j=i;j<list.length;j++){
                while(k < list.length && list[i]+list[j]>list[k]){
                    k++;
                }
                ans += k-j;
            }
        }
        return ans;
    }
    //brute force as standard
    public static ArrayList<ArrayList<Integer>> validTriangleBruteForce(int[] array){
        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        Arrays.sort(array);
        int n = array.length;
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                for(int k =0;k<n;k++){
                    if(array[i]+array[j] > array[k] && array[i]+array[k] > array[j] && array[k]+array[j] > array[i]){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(array[i]);
                        temp.add(array[j]);
                        temp.add(array[k]);
                        Collections.sort(temp);
                        res.add(temp);
                    }
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(res);
    }



    public static void main(String[] args){
        int[] edges = {2,3,4,5,6,7};
        int[] list =  {10, 21, 22, 100, 101, 200, 300};
        System.out.println(validTriangleUniqueUse(edges));
        System.out.println(validTriangleNumber(edges));
        System.out.println(validTriangleBruteForce(edges));


    }
}
