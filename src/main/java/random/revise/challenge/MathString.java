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
public class MathString {

    public static void main(String[] args){

        List<String> str = Arrays.asList("aba","baba","aba","xzxb");
        List<String> query = Arrays.asList("aba","xzxb","ab");
        matchingStrings(str, query);
        System.out.println( matchingStrings(str, query));
    }
    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here

          List<Long> listLong = queries.stream().map(  i -> strings.stream().filter(str -> str.equals(i)).count() ).toList();

          // Java 11
          return  listLong.stream().map( l -> {
               return l.intValue();
          }).collect(toList());

          // Java 16
        /*return  listLong.stream().map( l -> {
            return l.intValue();
        })toList();*/

    }


}
