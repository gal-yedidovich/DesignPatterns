package gof.behavior.visitor.example2.Expressions;

import gof.behavior.visitor.example2.visitors.Visitor;

public class Addition implements Expression {
    private Expression left, right;

    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
