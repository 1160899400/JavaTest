package designpattern.proxy;

import intf.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/3 17:32
 */

/**
 * 动态代理的作用：
 * 能在调用某个函数时加入自定义的操作
 *
 * 动态代理实现方式：
 * 1 利用JDK 提供的API 实现动态代理  （原理：反射机制     缺点：被代理的类必须继承interface）
 * 2 利用CGLIB 实现动态代理  （原理：为需要被代理的类创建子类拦截父类函数的调用   缺点：不能代理final修饰的class）
 */
public class ProxyTest implements Test {
    @Override
    public void runTest() {
        Video animation = new Animation("XiYangYang");

        InvocationHandler invocationHandler = new DynamicProxy(animation);

        /**
         * 此处为利用 java api 实现的动态代理
         * 函数的第二个参数必须为interface, 第一个参数可以为实体类
         */
        Video animationProxy = (Video) Proxy.newProxyInstance(Video.class.getClassLoader(), new Class<?>[]{Video.class},invocationHandler);
        animationProxy.display();


        /**
         * 此处利用 cglib实现动态代理
         */
        CglibProxy cglibProxy = new CglibProxy();
        Animation anim = (Animation) cglibProxy.getInstance(animation);
        anim.display();
    }
}
