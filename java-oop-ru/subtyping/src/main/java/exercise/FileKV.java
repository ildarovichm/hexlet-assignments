package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private Map<String, String> baseMap;
    private String path;

    public FileKV(String path, Map<String, String> baseMap) {
        String content = Utils.serialize(baseMap);
        Utils.writeFile(path, content);
        this.baseMap = baseMap;
        this.path = path;
    }
    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(path);
        Map<String, String> readMap = Utils.unserialize(content);
        for (Map.Entry<String, String> entry : baseMap.entrySet()) {
            readMap.put(entry.getKey(), entry.getValue());
        }
        readMap.put(key, value);
        content = Utils.serialize(readMap);
        Utils.writeFile(path, content);
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(path);
        Map<String, String> readMap = Utils.unserialize(content);
        readMap.remove(key);
        content = Utils.serialize(readMap);
        Utils.writeFile(path, content);
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(path);
        Map<String, String> readMap = Utils.unserialize(content);
        for (Map.Entry<String, String> entry : readMap.entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(path);
        Map<String, String> readMap = Utils.unserialize(content);
        return new HashMap<>(readMap);
    }
}
// END
