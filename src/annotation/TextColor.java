package annotation;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/8/21 16:37
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @interface 为关键字，用于定义注解
 *
 * 有 4  种用于定义注解的注解（源注解）：
 * @Retention
 * 表示注解保留的范围，默认值为RetentionPolicy.CLASS. 可选值有三种：
 *      RetentionPolicy.SOURCE, 只在源码中可用                 (常用于标记，无实际作用，如@Override）
 *      RetentionPolicy.CLASS, 在源码和字节码中可用             (编译时)
 *      RetentionPolicy.RUNTIME, 在源码,字节码,运行时均可用     （运行时）
 *
 * @Target
 * 表示用来修饰哪些东西，如 TYPE, METHOD, CONSTRUCTOR, FIELD, PARAMETER (数据类型、函数、构造器、域、参数)等，未标注则表示可修饰所有
 *
 * @Inherited
 * 表示是否可以被继承，默认为false
 *
 * @Documented
 * 表示是否会保存到 Javadoc 文档中
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TextColor {
    //注解值写法：  类型 参数名() default 默认值;             默认值可选，可以定义或不定义
    //注解值类型只能为byte,short,char,int,long,float,double,boolean八种基本数据类型和String、Enum、Class、annotations等数据类型,以及这一些类型的数组，这里用的String
    //单个注解值的参数名默认为value
    Color value() default Color.GREEN;
    String  bgColor() default  "BLUE";

    public enum Color {BLUE,GREEN,RED,GRAY};

}
