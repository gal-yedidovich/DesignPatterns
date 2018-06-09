package gof.creational.abstract_factory.factories;

import gof.creational.abstract_factory.ui.UIButton;
import gof.creational.abstract_factory.ui.UIImage;
import gof.creational.abstract_factory.ui.UIView;

public interface UIFactory {
    default UIView createView(String name) {
        switch (name.toLowerCase()) {
            case "button":
            case "btn":
                return createButton();
            case "image":
            case "img":
                return createImage();
            default:
                return null;
        }
    }

    UIButton createButton();

    UIImage createImage();
}
