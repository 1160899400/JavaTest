import annotation.AnnotationTest;
import basic.Animal;
import basic.Dog;
import designpattern.proxy.ProxyTest;
import intf.Test;
import reflection.ReflectionTest;

public class Run {

    private Test test;

    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
//        System.out.println(Integer.MAX_VALUE);

//        new Executor().execute();
//        thread.Test1 test1 = new thread.Test1();
//        test1.show();

        Run run = new Run();
//         run.test1();
//        run.test2();
        run.runProxyTest();
//        run.runReflectionTest();

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
        Animal dog = new Dog();
        System.out.println(dog.getClass());
        System.out.println(Animal.class.getName());
    }

    /**
     * 测试注解
     */
    private void runAnnotationTest(){
        test = new AnnotationTest();
        test.runTest();
    }


    /**
     * 测试代理
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
