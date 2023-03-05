package exercise;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> data = storage.toMap();
        Map<String, String> result = new HashMap<>();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }

        for (Map.Entry<String, String> entry : data.entrySet()) {
            storage.unset(entry.getKey());
            storage.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
