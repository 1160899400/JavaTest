package gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Hongzhi Liu
 * @date 2019/1/25
 */
public class Job {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("name")
    private String name;

    private Integer type;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static void printJob(Job job){
        if (null != job){
            System.out.println("id:  " + job.getId());
            System.out.println("name:   " + job.getName());
            if (null == job.getName()){
                System.out.println("job name is null");
            }
            System.out.println("type:   " + job.getType());
            if (null == job.getType()){
                System.out.println("job type is null");
            }
        }
    }
}
