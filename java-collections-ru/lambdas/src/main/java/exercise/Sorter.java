package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter{
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(people -> people.get("gender").equals("male"))
                .sorted((people1, people2) -> people1.get("birthday").compareTo(people2.get("birthday")))
                .map(people -> people.get("name"))
                .collect(Collectors.toList());
    }
}
// END
