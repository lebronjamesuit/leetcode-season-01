package random.revise.challenge;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Unfairness {

    public static void main(String[] args) throws IOException {
        List<Integer> listNumbers = Arrays.asList(1,5,10,17,20,28,66,68,68,68,77,97,99,101,102);
        int k = 4;
       int small = maxMin(k, listNumbers);
        // Find minimum possible of fairness
        System.out.println("Smallest gap is " + small);
    }


    public static int maxMin(int k, List<Integer> listNumbers) {

        if(k<2 || k > listNumbers.size()) return 0;

        List<Integer> listSorted=  listNumbers.stream().sorted().collect(toList());
        Integer[] sortedArray = listSorted.toArray(new Integer[listNumbers.size()]);
        int smallestGap = Integer.MAX_VALUE;
        for (int i = 0; i <= sortedArray.length-k; i++) {
            Integer [] arrayNum = new Integer[k];
            arrayNum = Arrays.copyOfRange(sortedArray,i, (i+k));
            Arrays.stream(arrayNum).forEach(System.out::println);
            int max = Arrays.stream(arrayNum).max(Integer::compareTo).get().intValue();
            int min = Arrays.stream(arrayNum).min(Integer::compareTo).get().intValue();
            System.out.println("max: " + max);
            System.out.println("min: " + min);
            System.out.println("gap: " + (max-min));
            if(smallestGap > (max-min)){
                smallestGap = max -min;
            }
        }
        return smallestGap ;
    }
}

       /* You will be given a list of integers "listNumbers", , and "k" a single integer .
            You must create an array of length k from elements of
            such that its unfairness is minimized. Call that array "arrayNum"
            Unfairness of an array is calculated as Max( "arrayNum") - Min ("arrayNum")

        Note: return the minimum possible unfairness
          2<= k <= n
          n = listNumbers.size();

        */