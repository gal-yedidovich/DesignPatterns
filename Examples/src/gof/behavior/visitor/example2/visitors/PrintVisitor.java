package gof.behavior.visitor.example2.visitors;

import gof.behavior.visitor.example2.Expressions.Addition;
import gof.behavior.visitor.example2.Expressions.Literal;

public class PrintVisitor implements Visitor {
    @Override
    public void visit(Literal literal) {
        System.out.print(literal.getNum());
    }

    @Override
    public void visit(Addition addition) {
        System.out.print("(");
        addition.getLeft().accept(this);
        System.out.print(" + ");
        addition.getRight().accept(this);
        System.out.print(")");
    }
}
