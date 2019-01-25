package algorithm;

import intf.Test;

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
     * 返回某个int数组的前n个最大值的数组索引
     * 如果该数组元素长度小于n 或者n == 0,则返回null
     *
     * @param array
     * @return
     */
    private int[] getMaxNArray(int[] array, final int n) {
        if (array.length < n || n <= 0) {
            return null;
        }
        // 前n个最大值的数组，result[0]为第n大的数值
        int[] result = new int[n];
        result[0] = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] < array[result[0]]) {
                result[i] = result[0];
                result[0] = i;
            } else {
                result[i] = i;
            }
        }


        //to do
        for (int i = n; i < array.length; i++) {
            if (array[i] >= array[result[0]]) {
                result[0] = i;

            }
        }

        return result;
    }
}
