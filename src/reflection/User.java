package reflection;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/4 9:31
 */

import intf.Test;

/**
 * 用于测试反射的类
 */
public class User implements Test {

    private String name = "default name";
    private int age = 18;
    private String email = "default email";

    public User(){
    }

    public User(String name){
        this.name = name;
    }

    protected User(String name,int age){
        this.name = name;
    }

    private User(String name,String email){
        this.name = name;
    }
    
    public void printName(){
        System.out.println("user name:" + name);
    }

    private void print(String content){
        System.out.println(content);
    }

    @Override
    public void runTest() {

    }
}
