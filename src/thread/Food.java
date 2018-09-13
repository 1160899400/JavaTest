package thread;

public class Food {
    public static volatile int FOOT_COUNT = 200;
    
    public static void showFootCount(){
        System.out.println("foot count:" + FOOT_COUNT);
    }

    public void decrease(){

        FOOT_COUNT --;
    }
}
