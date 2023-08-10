package random.revise.challenge;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Stream<String> stream1 = Arrays.stream(names1);
        Stream<String> stream2 = Arrays.stream(names2);
        Stream<String> totalStream = Stream.concat(stream1, stream2);
        List<String> listNames = totalStream.distinct().collect(Collectors.toList());

        return listNames.toArray(String[]::new);

    }

    public static void main(String[] args) {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}


   /* Note
   List<String> list = List.of("x","y","z");
    String[] arrayBeforeJDK11 = list.toArray(new String[0]);
    String[] arrayAfterJDK11 = list.toArray(String[]::new); // similar to Stream.toArray

    */