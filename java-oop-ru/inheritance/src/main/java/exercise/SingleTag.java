package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {
    Map<String, String> attributes;
    SingleTag(String nameTag, Map<String, String> attributes) {
        super(nameTag);
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("<").append(nameTag).append(" ");
        for (var element : attributes.entrySet()) {
            str.append(element.getKey()).append("=").append("\"")
                    .append(element.getValue()).append("\"").append(" ");
        }
        str.deleteCharAt(str.length() - 1);
        str.append(">");
        return str.toString();
    }
}
// END
