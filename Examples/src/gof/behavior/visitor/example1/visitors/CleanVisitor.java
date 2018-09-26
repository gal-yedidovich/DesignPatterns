package gof.behavior.visitor.example1.visitors;

import gof.behavior.visitor.example1.elements.IntegerElement;
import gof.behavior.visitor.example1.elements.StringElement;

public class CleanVisitor implements Visitor {
    @Override
    public void visit(StringElement e) {
        e.setText("clean");
    }

    @Override
    public void visit(IntegerElement e) {
        e.setNum(0);
    }
}
