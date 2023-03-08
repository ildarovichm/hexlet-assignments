package exercise;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    private String tag;
    private Map<String, String> attributes;

    public Tag(String tag, Map<String, String> attributes) {
        this.tag = tag;
        this.attributes = attributes;
    }

    public String toString() {
        String result = "";
        result = "<" + tag;
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            result += " " + entry.getKey() + "=\"" + entry.getValue() + "\"";
        }
        result += ">";
        return result;
    }

    public String getTag() {
        return this.tag;
    }

    public Map<String, String> getAttributes() {
        return this.attributes;
    }


}
// END
