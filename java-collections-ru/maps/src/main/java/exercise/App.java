package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
public class App {
    public static Map getWordCount(String str) {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        int count = 0;
        String[] pairs = str.split(" ");
        for (int i = 0; i < pairs.length; i++) {
            myMap.put(pairs[i], 0);
        }
        Map<String, Integer> occurrences = new HashMap<String, Integer>();

        for ( String word : pairs ) {
            Integer oldCount = occurrences.get(word);
            if ( oldCount == null ) {
                oldCount = 0;
            }
            occurrences.put(word, oldCount + 1);
        }
        return occurrences;
    }

    public static String toString(Map<String, Integer> rMap) {
        String result = "{";
        if (rMap.size() > 1) {
            result = "{\n";
            for (Map.Entry<String, Integer> entry : rMap.entrySet()) {
                result = "\n" + result + "  " + entry.getKey() + ": " + entry.getValue() + "\n";
            }
        } else {
            result += "}";
            return result;
        }

        result = result + "}";
        return result;
    }
}

//END
