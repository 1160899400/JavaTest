package thread;

import intf.Test;

public class ThreadTest implements Test {
    boolean isFinish = false;
    @Override
    public void runTest(){
        Food food = new Food();
//        Thread thread1 = new Thread(food);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
//                while (!isFinish){
//                    food.decrease();
//                    System.out.println("thread decrease execute: " + food.FOOT_COUNT);
//                }
                for (int i = 0; i < 10000; i++) {
                    food.decrease();
                }
//                try {
//                    Thread.sleep(800);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(food.foot_count);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    food.decrease();
                }
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("interrupted");
                }
            }
        });
        thread1.start();
        thread2.start();
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread2.interrupt();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        isFinish = true;
        System.out.println(food.foot_count);
//        food.foot_count = 102;
//        System.out.println("execute food_count = 102;");
//        Thread thread2 = new Thread(food);
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                food.showFootCount();
//            }
//        });

//        thread2.start();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(food.foot_count);
    }

}
