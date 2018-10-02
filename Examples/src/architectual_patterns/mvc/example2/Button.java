package architectual_patterns.mvc.example2;

public class Button extends View {
    private String text = "";

    void setText(String text) {
        this.text = text != null ? text : "";
    }

    @Override
    public void presentView() {
        StringBuilder sb = new StringBuilder("presenting button");
        if (!text.isEmpty()) sb.append("\n\twith text:").append(text);
        if (getListener() != null) sb.append("\n\twith click listener.");

        System.out.println(sb.append('\n'));
    }

    void click() {
        getListener().onClick(this);
    }
}
