package designpattern.factory;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/13 14:00
 */

/**
 * 工厂类
 */
public class PhoneFactory {

    public Phone getPhone(String phoneName) {
        Phone phone;
        switch (phoneName) {
            case PhoneName.PHONE_NAME_IPHONE:
                phone = new IPhone();
                break;
            case PhoneName.PHONE_NAME_MIPHONE:
                phone = new MIPhone();
                break;
            default:
                phone = null;
                break;

        }
        return phone;
    }

}
