package gof.creational.abstract_factory.ui;

public class OSXButton implements UIButton {
    @Override
    public void draw() {
        System.out.println("OSX button");
    }

    @Override
    public void click() {
        System.out.println("OSX click");
    }
}
