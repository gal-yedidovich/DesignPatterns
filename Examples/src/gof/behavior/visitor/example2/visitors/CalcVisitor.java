package gof.behavior.visitor.example2.visitors;

import gof.behavior.visitor.example2.Expressions.Addition;
import gof.behavior.visitor.example2.Expressions.Literal;

public class CalcVisitor implements Visitor {
    private double result;

    @Override
    public void visit(Literal literal) {
        result = literal.getNum();
    }

    @Override
    public void visit(Addition addition) {
        var tempR = 0;
        addition.getLeft().accept(this);
        tempR += this.result;
        addition.getRight().accept(this);
        this.result += tempR;
    }

    public double getResult() {
        return result;
    }
}
