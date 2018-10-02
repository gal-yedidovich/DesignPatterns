package gof.structural.proxy.example1;

/**
 * Created by Gal on 8/30/2017.
 */
class ProxyImage implements Image {

    private String fileName;
    private Image img;

    ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void displayImage() {
        if (img == null)
            img = new RealImage(fileName);
        img.displayImage();
    }
}
