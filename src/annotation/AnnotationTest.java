package annotation;


import intf.Test;

import java.lang.reflect.Field;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/8/21 17:08
 */
public class AnnotationTest implements Test {

    @TextColor(value = TextColor.Color.GRAY,bgColor = "green")
    private String testAnnotation;


    @Override
    public void runTest() {
        getAnnotation();
    }

    /**
     * 运用反射机制获取注解
     */
    public void getAnnotation(){
        // 获取要解析的类
        Class cls = null;
        try {
            cls = Class.forName("annotation.AnnotationTest");
            // 拿到所有Field
            Field[] declaredFields = cls.getDeclaredFields();
            for(Field field : declaredFields){
                // 获取Field上的注解
                TextColor annotation = field.getAnnotation(TextColor.class);
                if(annotation != null){
                    // 获取注解值
                    String value = annotation.bgColor();
                    System.out.println("获取到的注解TextColor中的bgColor值" + value);
                }

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
