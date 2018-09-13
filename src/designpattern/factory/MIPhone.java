package designpattern.factory;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/13 15:46
 */
public class MIPhone implements Phone {
    @Override
    public String printPhoneName() {
        System.out.println(PhoneName.PHONE_NAME_MIPHONE);
        return PhoneName.PHONE_NAME_MIPHONE;
    }
}
