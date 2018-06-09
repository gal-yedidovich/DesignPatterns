package gof.creational.abstract_factory.factories;

import gof.creational.abstract_factory.ui.OSXButton;
import gof.creational.abstract_factory.ui.UIButton;
import gof.creational.abstract_factory.ui.UIImage;

public class OSXFactory implements UIFactory{

    @Override
    public UIButton createButton() {
        return new OSXButton();
    }

    @Override
    public UIImage createImage() {
        return () -> System.out.println("OSX Image");
    }
}
