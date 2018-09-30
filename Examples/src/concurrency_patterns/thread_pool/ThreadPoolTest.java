package concurrency_patterns.thread_pool;

/**
 * Thread Pool Test
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        try (ThreadPool pool = new ThreadPool()) {

            for (int i = 0; i < 140; i++) {
                final int num = i;
                pool.async(() -> {
                    try {
                        System.out.println("working " + num);
                        Thread.sleep(200);
                        System.out.println(num + " kill");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }

            for (int i = 0; i < 10; i++) {
                final int num = i;
                pool.async(() -> {
                    try {
                        System.err.println("Big working " + num);
                        Thread.sleep(1000);
                        System.err.println("Big " + num + " kill");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

                Thread.sleep(500);
            }

            for (int i = 0; i < 10; i++) {
                Thread.sleep(300);
                System.out.println("hi " + i);
            }

            Thread.sleep(1500);
            pool.async(() -> System.out.println("job 1"));
            Thread.sleep(500);
            pool.async(() -> System.out.println("job 2"));
            Thread.sleep(400);
            pool.async(() -> System.out.println("job 3"));
//            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
