package gof.behavior.visitor.example1;

import gof.behavior.visitor.example1.elements.IntegerElement;
import gof.behavior.visitor.example1.elements.StringElement;
import gof.behavior.visitor.example1.visitors.AddTenVisitor;
import gof.behavior.visitor.example1.visitors.CleanVisitor;
import gof.behavior.visitor.example1.visitors.Visitor;

public class VisitorTest {
    public static void main(String[] args) {
        StringElement string1 = new StringElement();
        string1.setText("Bubu ");
        IntegerElement int1 = new IntegerElement();
        int1.setNum(9);

        System.out.println(string1.getText());
        System.out.println(int1.getNum());

        Visitor addVisitor = new AddTenVisitor();
        Visitor visitor2 = new CleanVisitor();

        //add visiting
        string1.accept(addVisitor);
        int1.accept(addVisitor);

        System.out.println(string1.getText());
        System.out.println(int1.getNum());

        //clean visiting
        string1.accept(visitor2);
        int1.accept(visitor2);

        System.out.println(string1.getText());
        System.out.println(int1.getNum());
    }
}
