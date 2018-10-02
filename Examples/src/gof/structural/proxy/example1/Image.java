package gof.structural.proxy.example1;

/**
 * Created by Gal on 8/30/2017.
 */
public interface Image {
    void displayImage();


    //static factory method to create proxy object
    static Image createImage(String fileName){
        return new ProxyImage(fileName);
    }
}
