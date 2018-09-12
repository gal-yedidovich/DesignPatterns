package gof.creational.singleton;

/**
 * Created by Gal on 8/23/2017.
 */
public class MySingy {
    private int number;

    private MySingy() {
        number = 0;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //*/
    private static MySingy instance = new MySingy();

    public static MySingy getInstance() {
        return instance;
    }
    /* /
    public static final MySingy instance = new MySingy();
    //*/

}
