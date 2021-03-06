package gof_exercises.command_math;

public class NumberReceiver {
    private double mNumber;

    NumberReceiver() {
        this(0);
    }

    NumberReceiver(double mNumber) {
        this.mNumber = mNumber;
    }

    double getNumber() {
        return mNumber;
    }

    void setNumber(double mNumber) {
        this.mNumber = mNumber;
    }

    @Override
    public String toString() {
        return getNumber() + "";
    }
}
