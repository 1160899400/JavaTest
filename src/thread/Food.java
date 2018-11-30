package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Food implements Runnable {
    public volatile AtomicInteger FOOT_COUNT = new AtomicInteger(200);
    public boolean isFinish = false;
    public volatile int foot_count = 100;

    public void showFootCount() {
        System.out.println(foot_count);
    }

    public void decrease() {
//        FOOT_COUNT.decrementAndGet();
//        FOOT_COUNT.decrementAndGet();
        foot_count --;
    }

    public void increase() {
        FOOT_COUNT.incrementAndGet();
    }

    @Override
    public void run() {
//        FOOT_COUNT.decrementAndGet();
//        synchronized (this) {
        foot_count--;
//        }
//        System.out.println(FOOT_COUNT.get());
        System.out.println(foot_count);
    }
}
