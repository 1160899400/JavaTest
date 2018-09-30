package basic;

import intf.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/21 10:51
 */
public class BasicTest implements Test {
    @Override
    public void runTest() {
        Dog dog = new BlackDog();
        dog.eat();
        choose(dog);

//        List list = new ArrayList();
//        list.add(1);
//        list.add(3);
//        list.add(2);
//        list.add(4);
//        list.forEach(System.out::println);

        List list = new ArrayList();
        list.add(2);
        list.add(6);
        list.add(3);

        String a = "sdfs";
        System.out.println(list);
    }

    public void choose(Dog dog){
        System.out.println(1);
    }
    
    public void choose(BlackDog blackDog){
        System.out.println(2);
    }
}
