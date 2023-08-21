package random.revise.challenge;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

import java.util.List;

public class SockMerchant {

    public static void main(String[] args) throws IOException {
        int n = 9;
        List<Integer> ar = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int result = sockMerchant(n, ar);
    }

     /* Complete the 'sockMerchant' function below.
            *
            * The function is expected to return an INTEGER.
            * The function accepts following parameters:
            *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        List<Integer> integerList =   ar.stream().distinct().collect(Collectors.toList());

        long pair =  integerList.stream().map(item -> {
            int x = (int) ar.stream().filter(a -> a.intValue() == item.intValue()).count();
            return x/2;
        }).reduce(0, Integer::sum);

        return (int) pair;
    }




}
