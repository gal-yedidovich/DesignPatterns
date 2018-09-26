package gof.behavior.visitor.example2.Expressions;

import gof.behavior.visitor.example2.visitors.Visitor;

public interface Expression {
    void accept(Visitor visitor);
}
