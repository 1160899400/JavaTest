package designpattern.factory.factory;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/13 14:00
 */

import designpattern.factory.intf.Phone;

/**
 * 工厂类
 */
public class PhoneFactory extends AbstractProductFactory{

    private static final String packageName = "designpattern.factory.";
    public Phone getPhone(String phoneName) {
        Phone phone = null;

        //这里通过参数值来判断具体的类，也可以改为利用反射来创建对象
//        switch (phoneName) {
//            case PhoneName.PHONE_NAME_IPHONE:
//                phone = new IPhone();
//                break;
//            case PhoneName.PHONE_NAME_MIPHONE:
//                phone = new MIPhone();
//                break;
//            default:
//                phone = null;
//                break;
//
//        }


        //这里通过反射来创建对象
        try {
            Class phoneClazz =  Class.forName(packageName + phoneName);
            phone = (Phone) phoneClazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phone;
    }

}
