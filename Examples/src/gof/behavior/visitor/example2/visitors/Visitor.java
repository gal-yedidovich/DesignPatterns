package gof.behavior.visitor.example2.visitors;

import gof.behavior.visitor.example2.Expressions.Addition;
import gof.behavior.visitor.example2.Expressions.Literal;

public interface Visitor {
    void visit(Literal literal);

    void visit(Addition addition);
}
