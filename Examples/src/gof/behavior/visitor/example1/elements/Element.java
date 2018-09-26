package gof.behavior.visitor.example1.elements;

import gof.behavior.visitor.example1.visitors.Visitor;

public interface Element {
    void accept(Visitor visitor);
}
