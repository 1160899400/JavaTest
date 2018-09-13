package thread;

public class Consumer implements Runnable {
    private Food food;
    public Consumer(Food food){
        this.food = food;
    }
    @Override
    public void run() {
        food.decrease();

    }


}
