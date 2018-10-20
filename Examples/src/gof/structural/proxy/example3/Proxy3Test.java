package gof.structural.proxy.example3;

public class Proxy3Test {
    public static void main(String[] args) {
        Subject real = new RealSubject(); //usually we won't reveal this implementation.

        real.saveData("direct access");
        System.out.println(real.requestData());


        Proxy proxy = new Proxy(); //we reveal this only proxy implementation to enforce our logic.
        proxy.saveData("un-authorized");
        System.out.println(proxy.requestData());

        proxy.setUsername("Bubu");
        proxy.setPass("123");
        proxy.saveData("OK!");
        System.out.println(proxy.requestData());
    }
}
