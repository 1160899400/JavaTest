package designpattern.builder;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/14 11:11
 */

/**
 * Builder模式的变种（Android Builder模式）
 *
 * 此种Builder模式下,Builder 为需要构造的类的内部类，且持有与原实体类相同的成员变量
 * Builder必须声明为static、final，调用时直接Entity.Builder.add()....build()
 */
public class Meal {
    private String mainFood;
    private double weight;
    private double price;

    private Meal(Builder builder){
        this.mainFood = builder.mainFood;
        this.weight = builder.weight;
        this.price = builder.price;


    }

    public static final class Builder{
        private String mainFood;
        private double weight;
        private double price;


        public Meal build(){
            return new Meal(this);
        }


    }
}
