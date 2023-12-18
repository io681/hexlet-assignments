package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    TagInterface element;
    String valueText;

    public LabelTag(String valueText, TagInterface elements) {
        this.element = elements;
        this.valueText = valueText;
    }

    @Override
    public String render() {
        return "<label>" + this.valueText + this.element.render() + "</label>";
    }
}
// END
