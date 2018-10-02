package architectual_patterns.mvc.example2;

public class MyModel {
    private int count = 0;
    private boolean isAlive = false;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
