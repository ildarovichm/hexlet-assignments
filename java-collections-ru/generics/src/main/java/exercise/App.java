package exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.*;

public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> bookToCompare) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book : books) {
            if (book.entrySet().containsAll(bookToCompare.entrySet())) {
                result.add(book);
            }
        }
        return result;
    }
}

