package exercise;

import java.util.Map;
import java.util.List;
//import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends  Tag {
    Map<String, String> attributes;
    String bodyTag;
    List<Tag> childTags;
    public PairedTag(String nameTag, Map<String, String> attributes, String bodyTag, List<Tag> childTags) {
        super(nameTag);
        this.attributes = attributes;
        this.bodyTag = bodyTag;
        this.childTags = childTags;
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
        str.append(bodyTag);
        for (var tag : childTags) {
            str.append(tag.toString());
        }
        str.append("<").append("/").append(nameTag).append(">");
        return str.toString();
    }
}
// END
