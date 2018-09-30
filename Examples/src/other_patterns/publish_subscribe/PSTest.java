package other_patterns.publish_subscribe;

public class PSTest {
    public static void main(String[] args) {
        Subscriber s1 = msg -> System.out.println("subscriber 1, " + msg);
        Subscriber s3 = msg -> System.out.println("subscriber 3, " + msg);
        Subscriber s2 = msg -> System.out.println("subscriber 2, " + msg);

        Broker.instance.registerToChannel1(s1);
        Broker.instance.registerToChannel1(s2);
        Broker.instance.registerToChannel2(s3);

        Broker.instance.sendMessage1("Bubu");
        Broker.instance.sendMessage2("Groot");
    }
}
