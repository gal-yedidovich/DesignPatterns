package gof.creational.abstract_factory.ui;

public class WinButton implements UIButton {
    @Override
    public void draw() {
        System.out.println("Windows button");
    }

    @Override
    public void click() {
        System.out.println("Windows click");
    }
}
