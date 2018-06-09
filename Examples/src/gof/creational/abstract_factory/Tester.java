package gof.creational.abstract_factory;

import gof.creational.abstract_factory.factories.OSXFactory;
import gof.creational.abstract_factory.factories.UIFactory;
import gof.creational.abstract_factory.factories.WinFactory;
import gof.creational.abstract_factory.ui.UIButton;
import gof.creational.abstract_factory.ui.UIImage;

import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        UIFactory factory = getFactory();

        factory.createView("img").draw();

        UIButton btn = factory.createButton();

        btn.draw();
        btn.click();

        UIImage img = factory.createImage();
        img.draw();
    }

    static UIFactory getFactory() {
        if (new Random().nextBoolean()) return new WinFactory();
        else return new OSXFactory();
    }
}
