package other_patterns.publish_subscribe;

import java.util.LinkedHashSet;
import java.util.Set;

public enum Broker {
    instance;

    private Set<Subscriber> channel1 = new LinkedHashSet<>();
    private Set<Subscriber> channel2 = new LinkedHashSet<>();

    public void registerToChannel1(Subscriber s) {
        channel1.add(s);
    }

    public void registerToChannel2(Subscriber s) {
        channel2.add(s);
    }

    public void sendMessage1(String msg) {
        for (Subscriber s : channel1) s.update(msg);
    }

    public void sendMessage2(String msg) {
        for (Subscriber s : channel2) s.update(msg);
    }
}
