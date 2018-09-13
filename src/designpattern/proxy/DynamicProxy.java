package designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/3 10:37
 */


/**
 * 静态代理比较简单，可参考网上资料，只针对动态代理研究
 *
 * 此类为 自定义动态代理类
 *
 *
 *
 * 该类使用第一种方式实现动态代理, Cglib代理可参照 CglibProxy类
 */
public class DynamicProxy<T> implements InvocationHandler {

    /**
     * 被代理的视频对象
     */
    private T realObject;


    public DynamicProxy(T realObject){
        this.realObject = realObject;
    }

    /**
     * @param proxy
     * proxy为代理对象
     * @param method
     * 代表代理对象正在执行的某个方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object resultObject = null;
        //此处可加一些自定义的预操作

        //通过反射调用被代理类的函数,返回的object对象表示执行结果
        //当代理对象调用某一函数时，会自动跳转到该方法中执行调用
        if(method.getDeclaringClass() == Object.class){
            return method.invoke(this,args);
        }
        resultObject = method.invoke(realObject,args);


        //此处可加一些自定义的后续操作

//也可以返回null
//        return null;

        return resultObject;
    }
}
