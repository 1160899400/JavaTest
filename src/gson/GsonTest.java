package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import intf.Test;

/**
 * @author Hongzhi Liu
 * @date 2019/1/25
 */
public class GsonTest implements Test {

    private Gson gson;

    @Override
    public void runTest() {
        gson = new GsonBuilder().serializeNulls().create();

        String jsonString = "{id:2334}";
        Job job = gson.fromJson(jsonString, Job.class);
        Job.printJob(job);

        Job job1 = new Job();
        job1.setId(2134L);
        System.out.println(gson.toJson(job1));
        String job1String = gson.toJson(job1);
        Job.printJob(gson.fromJson(job1String, Job.class));


    }
}
