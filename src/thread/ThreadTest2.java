package thread;

import intf.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hongzhi Liu
 * @date 2019/1/7 9:49
 */
public class ThreadTest2 implements Test {
    private ModifyInt modifyInt;


    @Override
    public void runTest() {
        modifyInt = new ModifyInt();
        Thread threadDemo = new Thread(modifyInt);
        threadDemo.start();
        modifyInt.lock.lock();
        try {
            modifyInt.readCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            modifyInt.lock.unlock();
        }
        System.out.println(modifyInt.a);
    }
}
