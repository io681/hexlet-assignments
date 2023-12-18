package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String text;

    public ReversedSequence(String text) {
        this.text = text;
    }

    @Override
    public int length() {
        return this.text.length();
    }

    @Override
    public char charAt(int index) {
        if (index < 0 || index >= this.text.length()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return this.text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int length = this.text.length();
        return new ReversedSequence(this.text.substring(length - end, length - start));
    }
    @Override
    public String toString() {
        StringBuilder reversed = new StringBuilder(text);
        return reversed.reverse().toString();
    }
}
// END
