package gof.creational.abstract_factory.factories;

import gof.creational.abstract_factory.ui.UIButton;
import gof.creational.abstract_factory.ui.UIImage;
import gof.creational.abstract_factory.ui.WinButton;

public class WinFactory implements UIFactory{

    @Override
    public UIButton createButton() {
        return new WinButton();
    }

    @Override
    public UIImage createImage() {
        return () -> System.out.println("Windows Image");
    }
}
