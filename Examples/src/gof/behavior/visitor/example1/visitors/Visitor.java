package gof.behavior.visitor.example1.visitors;

import gof.behavior.visitor.example1.elements.IntegerElement;
import gof.behavior.visitor.example1.elements.StringElement;

public interface Visitor {
    void visit(StringElement e);
    void visit(IntegerElement e);
}
