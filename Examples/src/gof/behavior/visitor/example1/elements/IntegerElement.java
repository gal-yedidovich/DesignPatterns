package gof.behavior.visitor.example1.elements;

import gof.behavior.visitor.example1.visitors.Visitor;

public class IntegerElement implements Element {
    private int num;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
