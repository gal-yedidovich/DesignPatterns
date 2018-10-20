package gof.structural.proxy.example2;

/**
 * Created by Gal on 8/30/2017.
 */
class Driver {
    private int age;

    public Driver(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
