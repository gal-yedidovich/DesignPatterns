package gof.structural.proxy.example3;

public class Proxy implements Subject {
    private String username, pass;
    private Subject subject = new RealSubject();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private boolean validUser() {
        return "Bubu".equals(username) && "123".equals(pass);
    }

    @Override
    public void saveData(String data) {
        if(validUser()) subject.saveData(data);
    }

    @Override
    public String requestData() {
        if(validUser()) return subject.requestData();
        else return null; //or throw an exception.
    }
}
