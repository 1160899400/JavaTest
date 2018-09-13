package designpattern.factory;

import intf.Test;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/13 13:58
 */

/**
 * 用于测试工厂模式的类
 *
 * 工厂模式设计思想：
 * 创建对象时，使用者不需要关心对象的具体创建过程，不用手动new 对象来创建,通过工厂来获取对象
 */
public class FactoryTest implements Test {
    @Override
    public void runTest() {
        PhoneFactory phoneFactory = new PhoneFactory();
        Phone phone;
        phone = phoneFactory.getPhone(PhoneName.PHONE_NAME_IPHONE);
        phone.printPhoneName();
        phone = phoneFactory.getPhone(PhoneName.PHONE_NAME_MIPHONE);
        phone.printPhoneName();
    }
}
