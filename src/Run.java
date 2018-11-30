import annotation.AnnotationTest;
import basic.BasicTest;
import designpattern.factory.test.FactoryTest;
import designpattern.proxy.ProxyTest;
import intf.Test;
import reflection.ReflectionTest;
import thread.ThreadTest;

import java.util.ArrayList;
import java.util.List;

public class Run {

    private Test test;

    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
//        System.out.println(Integer.MAX_VALUE);

//        new Executor().execute();


        Run run = new Run();
//         run.threadTest();
//        run.test2();
//        run.runFactoryTest();
//        run.runProxyTest();
//        run.runReflectionTest();

//        ThreadTest threadTest = new ThreadTest();
//        threadTest.runTest();

        List<Integer> a = new ArrayList(1);
        a.add(new Integer(3));
        a.add(new Integer(10));
        System.out.println(a.toString());


//        System.out.println(System.getProperty("java.library.path"));

    }

    /**
     * 测试多线程下生产者消费者问题
     */
    private void test1() {
//        Consumer consumer = new Consumer();
//        Thread threadConsumer = new Thread(consumer);
//        threadConsumer.start();

    }

    private void test2() {
        BasicTest basicTest = new BasicTest();
        basicTest.runTest();
    }

    /**
     * 测试注解
     */
    private void runAnnotationTest(){
        test = new AnnotationTest();
        test.runTest();
    }


    /**
     * 测试工厂模式
     */
    private void runFactoryTest(){
        Test factoryTest = new FactoryTest();
        factoryTest.runTest();

    }

    /**
     * 测试代理模式
     */
    private void runProxyTest(){
        Test proxyTest = new ProxyTest();
        proxyTest.runTest();
    }

    /**
     * 测试反射机制
     */
    private void runReflectionTest(){
        ReflectionTest reflectionTest = new ReflectionTest();
        reflectionTest.runTest();
    }
}
