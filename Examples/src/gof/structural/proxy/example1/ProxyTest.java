package gof.structural.proxy.example1;

/**
 * Created by Gal on 8/30/2017.
 */
public class ProxyTest {
    public static void main(String[] args) {
        ProxyImage img1 = new ProxyImage("Gal image");
        ProxyImage img2 = new ProxyImage("Beach image");
        img1.displayImage();
        img1.displayImage();
        img2.displayImage();
        img1.displayImage();
        img2.displayImage();

        //using factory to create proxy object
        Image img3 = Image.createImage("Bubu image");
        img3.displayImage();
        img3.displayImage();

        Image img4 = Image.createImage("Groot image");
        img4.displayImage();
    }
}
