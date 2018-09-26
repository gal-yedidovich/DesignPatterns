package gof.behavior.visitor.example1.elements;

import gof.behavior.visitor.example1.visitors.Visitor;

public class StringElement implements Element {
    private String text = "";

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
