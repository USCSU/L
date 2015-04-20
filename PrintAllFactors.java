package LinkedIn;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by Garvin on 10/21/2014.
 */
public class PrintAllFactors {
    public static ArrayList<ArrayList<Integer>> getAllFactorCombinationTest(int num){
        return new ArrayList<ArrayList<Integer>>(helperTest(new ArrayList<Integer>(),1,num));
    }

    public static HashSet<ArrayList<Integer>> helperTest(ArrayList<Integer> collector, int cur, int num){
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        if(cur > num || cur<0) return set;
        if(cur == num){
            Collections.sort(collector);
            set.add(new ArrayList<Integer>(collector));
            return set;
        }
        for(int i =2;i<=num;i++){
            if(num%i == 0){
                collector.add(i);
                set.addAll(helperTest(collector, cur * i, num));
                collector.remove(collector.size()-1);
            }
        }
        return set;
    }
    public static ArrayList<ArrayList<Integer>> getAllFactorCombination(int num){
        return new ArrayList<ArrayList<Integer>>(helper(new ArrayList<Integer>(), num, 1));
    }
    public static HashSet<ArrayList<Integer>> helper(ArrayList<Integer> list, int num, int current){
        HashSet<ArrayList<Integer>> res = new HashSet<ArrayList<Integer>>();
        if(current>num || current< 0) return res;
        if(current == num ){
//            System.out.println(list);
//            Collections.sort(list);
            res.add(new ArrayList<Integer>(list));
            return res;
        }
        for(int i =2;i<=num-1;i++){
            if(num%i ==0) {
                list.add(i);
                res.addAll(helper(list, num, current*i ));
                list.remove(list.size()-1);
            }
        }
        return res;
    }
    public static void printFactors(int number, String parentFactors, int parentVal) {
        int newVal = parentVal;
        for (int i = number - 1; i >= 2; i--) {

            if (number % i == 0) {
                if (newVal > i) {
                    newVal = i;
                }
                if (number / i <= parentVal && i <= parentVal && number / i <= i) {
                    System.out.println(parentFactors + i + "*" + number / i);
                    newVal = number / i;
                }

                if (i <= parentVal) {
                    printFactors(number / i, parentFactors + i + "*", newVal);
                }
            }

        }

    }
    static  void printAllFactors(int num) {
        int factorCandidate;


        for(factorCandidate = 1; factorCandidate <= Math.sqrt(num); factorCandidate++) {
            if(num%factorCandidate == 0)
               System.out.println(factorCandidate +" *" +num/factorCandidate);
        }
    }





    public static void main(String[] args){
        printFactors(12,"",12);
        System.out.println(getAllFactorCombinationTest(12));
        System.out.println(getAllFactorCombination(12));
        printAllFactors(12);
    }

    static void primeFactors(int n)
    {
        // Print the number of 2s that divide n
        while (n%2 == 0)
        {
            System.out.println(2);
            n = n/2;
        }

        // n must be odd at this point.  So we can skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i = i+2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                System.out.println(i);
                n = n/i;
            }
        }

        // This condition is to handle the case whien n is a prime number
        // greater than 2
        if (n > 2)
            System.out.println(n);
    }
}
