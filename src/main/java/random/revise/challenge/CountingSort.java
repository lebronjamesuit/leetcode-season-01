package random.revise.challenge;

import java.util.Arrays;
import java.util.List;


public class CountingSort {
    public static void main(String[] args){

        List<Integer> arr = Arrays.asList(1,1,3,2,1,8,9,1,5,5,5,5,5,12,3,3,5,51,2,4,5,44,55,66,88);
        List<Integer>  result  = countingSort(arr);
        for (int t: result  ) {
            System.out.println(t);
        }

    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Always return List<Integer> with 100 elements
        Integer[] initArr = new Integer[100];
        for (int i = 0; i < initArr.length ; i++) {
            initArr[i] = 0;
        }
        Integer [] arrayOfInt =  arr.toArray(new Integer [arr.size()] );
        for (int i = 0; i < arrayOfInt.length; i++) {
            initArr[arrayOfInt[i]] += 1  ;
        }
        return  Arrays.asList(initArr);
    }

}


/*
        Alternative Sorting
        Another sorting method, the counting sort, does not require comparison. Instead, you create an integer array whose index range covers the entire range of values in your array to sort. Each time a value occurs in the original array, you increment the counter at that index. At the end, run through your counting array, printing the value of each non-zero valued index that number of times.

        Example

        All of the values are in the range , so create an array of zeros, . The results of each iteration follow:

        i	arr[i]	result
        0	1	[0, 1, 0, 0]
        1	1	[0, 2, 0, 0]
        2	3	[0, 2, 0, 1]
        3	2	[0, 2, 1, 1]
        4	1	[0, 3, 1, 1]
        The frequency array is . These values can be used to create the sorted array as well: .

        Note
        For this exercise, always return a frequency array with 100 elements. The example above shows only the first 4 elements, the remainder being zeros.

        Challenge
        Given a list of integers, count and return the number of times each value appears as an array of integers.

        Function Description

        Complete the countingSort function in the editor below.

        countingSort has the following parameter(s):

        arr[n]: an array of integers
        Returns

        int[100]: a frequency array*/