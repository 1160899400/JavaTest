package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hongzhi Liu  liu13407134075@gmail.com
 * @date 2019/1/7 9:52
 */
public class ModifyInt implements Runnable {
    public volatile boolean d = false;
    public volatile int a = 3;
    public Lock lock = new ReentrantLock();
    public final Condition readCondition = lock.newCondition();

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        try {
            a = 7;
            d = true;
            readCondition.signal();
        } finally {

            lock.unlock();
        }
    }
}
