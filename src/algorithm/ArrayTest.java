package algorithm;

import intf.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hongzhi Liu  liu13407134075@gmail.com
 * @date 2019/1/14 17:35
 */
public class ArrayTest implements Test {

    private int[] testIntArray = {2, 3, 8, 4, 5, 7};

    @Override
    public void runTest() {

    }


    /**
     * 返回某个int数组的前n个最大值
     *
     * @param array
     * @return
     */
    private int[] getMaxNArray(int[] array, final int n) {
        List<Integer> list = new ArrayList<>();
        // 前n个最大值的数组，result[0]为第n大的数值
        int[] result = new int[n];
        //to do
        for (int i = 0; i < array.length; i++) {
            int
        }

        return result;
    }
}
