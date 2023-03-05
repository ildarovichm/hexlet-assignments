package exercise;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {
    private Map<String, String> map;
    private Map<String, String> newMap = new HashMap<>();

    public InMemoryKV(Map<String, String> map) {
        this.map = map;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            newMap.put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void set(String key, String value) {
        newMap.put(key, value);
    }


    @Override
    public void unset(String key) {
        newMap.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        for (Map.Entry<String, String> entry : newMap.entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(newMap);
    }

}

// END
