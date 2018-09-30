package concurrency_patterns.dispatch_queue;

public class DPTest {
    public static void main(String[] args) throws InterruptedException {
        DispatchQueue queue = new DispatchQueue("my DP");

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            queue.add(() -> {
                for (int j = 0; j < 10; j++) System.out.println("Bubu is the king " + finalI + j);
            });
            if(i == 5) Thread.sleep(500);
        }
        Thread.sleep(1500);

        queue.add(() -> System.out.println("after sleep"));
        queue.kill();
    }
}
