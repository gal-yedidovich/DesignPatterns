package gof.behavior.visitor.example2;

import gof.behavior.visitor.example2.Expressions.Addition;
import gof.behavior.visitor.example2.Expressions.Expression;
import gof.behavior.visitor.example2.Expressions.Literal;
import gof.behavior.visitor.example2.visitors.CalcVisitor;
import gof.behavior.visitor.example2.visitors.PrintVisitor;

public class Visitor2Test {
    public static void main(String[] args) {
        Expression expression = new Addition(
                new Addition(
                        new Literal(2),
                        new Literal(3)
                ),
                new Literal(4)
        );

        PrintVisitor visitor = new PrintVisitor();
        CalcVisitor visitor1 = new CalcVisitor();
        expression.accept(visitor);
        expression.accept(visitor1);

        System.out.println();
        System.out.println(visitor1.getResult());
    }
}
