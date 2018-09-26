package gof.behavior.visitor.example2.Expressions;

import gof.behavior.visitor.example2.visitors.Visitor;

public class Literal implements Expression {
    private double num;

    public Literal(double num) {
        this.num = num;
    }

    public double getNum() {
        return num;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
