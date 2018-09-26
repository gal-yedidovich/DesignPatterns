package gof.behavior.visitor.example1.visitors;

import gof.behavior.visitor.example1.elements.IntegerElement;
import gof.behavior.visitor.example1.elements.StringElement;

public class AddTenVisitor implements Visitor {
    @Override
    public void visit(StringElement e) {
        e.setText(e.getText() + "Ten ");
    }

    @Override
    public void visit(IntegerElement e) {
        e.setNum(e.getNum() + 10);
    }
}
