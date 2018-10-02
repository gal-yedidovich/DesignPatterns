package gof.structural.proxy.example1;

/**
 * Created by Gal on 8/30/2017.
 */
public class RealImage implements Image {
    private String fileName;

    RealImage(String name) {
        fileName = name;
        loadImage();
    }

    private void loadImage() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void displayImage() {
        System.out.println("Showing real image with fileName " + fileName);
    }
}
