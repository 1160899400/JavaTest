package designpattern.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/3 19:52
 */

/**
 * 这是以Cglib库 实现的动态代理的例子
 * 这种方式的优点是 被代理对象不需要继承接口实现。
 * <p>
 * 使用此种方式需导入Cglib.jar包
 */
public class CglibProxy<T> implements MethodInterceptor {

    private Object realObject;

    public Object getInstance(final Object realObject) {
        this.realObject = realObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.realObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        //此处可加入自定义的预操作

        Object objectResult = methodProxy.invoke(object, args);


        //此处可加入自定义的后续操作

        return objectResult;
    }
}
