package gof.structural.proxy.example3;

public class RealSubject implements Subject {
    private String data;

    @Override
    public void saveData(String data) {
        this.data = data;
    }

    @Override
    public String requestData() {
        return data;
    }
}
