package reflection;

import intf.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/3 17:09
 */

/**
 * java反射机制
 * <p>
 * 反射：通俗来说就是根据名称获取具体的对象  （如根据类名获取对应的 Class 对象,根据函数名获取对应的 Method 对象 根据变量名获取对应的 Field 对象）
 */
public class ReflectionTest implements Test {

    /**
     * 在初始化该类的对象时执行该代码块，设置clazz的测试类
     */ {
        try {
            clazz = Class.forName("reflection.User");
        } catch (ClassNotFoundException e) {
            System.out.println("exception:包名/类名未找到");
            e.printStackTrace();
        }
    }

    /**
     * 测试反射的类 的 字节码文件对象
     */
    private Class clazz;

    /**
     * 测试反射的对象
     */
    private User user;


    @Override
    public void runTest() {
        User user1 = getUser();
        user1.printName();
        getUser("Lhz");
        getMemberField("name");
        getMemberMethod("print");
        getInterface();

    }

    /**
     * 根据类名获取类对象
     */
    private User getUser() {
        try {
            /**
             * 这里类名必须加上所在的包名，不然会找不到类
             * newInstance() 方法创建对象时，将调用默认的无参的构造器。
             * 若默认的无参构造函数为private 或没有时，将会抛出异常
             */
            User user = (User) clazz.newInstance();
            return user;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("exception:无参构造函数不为public");
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.out.println("exception:找不到无参的构造函数");
            return null;
        }
    }

    /**
     * 根据类名获取类的构造器对象(有参、无参)
     * 可以通过类的构造器对象创建对象
     */
    private User getUser(String userName) {
        try {
            /**
             * getDeclaredConstructors函数  获取所有构造器（包括public、private、protected）
             * getConstructor()函数 获取public 属性的构造器（不含private、protected）       参数为构造器的参数，若不带参数，则尝试获取默认的无参构造器
             * 若没有找到对应的构造函数，则在此次抛出 NoSuchMethodException
             * Constructor.newInstance(args) 根据构造器构造对象
             * Constructor.setAccessible 可以改变成员变量或成员函数的 private/protected、public 权限
             */

            Constructor[] allConstructors = clazz.getDeclaredConstructors();
            System.out.println("构造函数个数：" + allConstructors.length);

            Constructor[] constructors = clazz.getConstructors();
            System.out.println("public 构造函数个数：" + constructors.length);
            for (int i = 0; i < constructors.length; i++) {
                System.out.print("第" + i + "个构造函数：  ");
                Constructor constructor = constructors[i];
                for (int j = 0; j < constructor.getParameterTypes().length; j++) {
                    System.out.print(constructor.getParameterTypes()[j].getName() + "\t");
                }
                System.out.println();
            }

            //通过带参数的构造器构造对象
            Constructor constructor = clazz.getConstructor(String.class);
            user = (User) constructor.newInstance(userName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 访问成员变量并修改变量值
     *
     * @param fieldName
     */
    private void getMemberField(String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            /**
             *  由于 name 属性为private，需要设置为可访问的，才能进行其他操作
             *  set 方法可设置变量值  第一个参数为需要设置的对象 第二个参数为设置值
             *  set 方法设置时，若设置的变量类型与成员变量类型不一致时，则会报错
             */

            field.setAccessible(true);
//            报错
//            field.set(user, 8);
//            field.set(user, getUser());

            field.set(user, "defaultName");
            user.printName();

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            System.out.println("没有找到该成员变量");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取成员函数并调用
     *
     * @param methodName
     */
    private void getMemberMethod(String methodName) {
        try {
            /**
             *  getMethod()函数 第一个参数为调用的函数名，后面的参数为调用的函数的参数类型，若调用的函数没有参数，则不用写
             *  invoke()函数 同理，后面的参数也可知名调用的函数的参数
             */
            //            Method method = clazz.getDeclaredMethod(methodName, String.class, int.class);
            Method method = clazz.getDeclaredMethod(methodName, String.class);
            method.setAccessible(true);
            method.invoke(user, "print content");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.out.println("没有找到该成员函数");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.out.println("该成员函数权限为private");
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取类的所有实现接口
     */
    private void getInterface() {
        Class[] classes = clazz.getInterfaces();
        for (int i = 0; i < classes.length; i++) {
            System.out.println("继承的第" + i + "个接口：" + classes[i].getName());
        }
    }
}
