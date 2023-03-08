package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{
    private String body;
    private List<Tag> child;
    public PairedTag(String tag, Map<String, String> attributes, String body, List<Tag> child) {
        super(tag, attributes);
        this.body = body;
        this.child = child;
    }

    public String toString() {
        String result = "";
        String tag = super.getTag();
        Map<String, String> attributes = super.getAttributes();
        result = "<" + tag;
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            result += " " + entry.getKey() + "=\"" + entry.getValue() + "\"";
        }
        result += ">";
        if (!child.isEmpty()) {
            for (Tag childParams : child) {
                Map<String, String> childMap = childParams.getAttributes();
                String childTag = childParams.getTag();
                result += "<" + childTag;
                for (Map.Entry<String, String> childEntry : childMap.entrySet()) {
                    result += " " + childEntry.getKey() + "=\"" + childEntry.getValue() + "\"";
                }
                result += ">";
            }
        }
        result += body + "</" + tag + ">";
        System.out.println(result);
        return result;
    }
}
// END
