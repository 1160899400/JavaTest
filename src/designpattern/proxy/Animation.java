package designpattern.proxy;

/**
 * @author Hongzhi Liu  2014302580200@whu.edu.cn
 * @date 2018/9/3 10:15
 */
public class Animation implements Video {

    private String fileName = "default.mp4";

    public Animation() {
    }

    public Animation(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        System.out.println("filename:  Animation_" + fileName);

    }

}
