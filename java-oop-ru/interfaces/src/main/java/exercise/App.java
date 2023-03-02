package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> aparts, int n) {
        return aparts.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(n)
                .map(x -> x.toString())
                .collect(Collectors.toList());
    }
}
// END
