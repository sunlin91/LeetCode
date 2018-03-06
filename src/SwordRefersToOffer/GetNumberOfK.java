package SwordRefersToOffer;

/**
 * Created by SUN on 2018/3/6
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0)
            return 0;
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k)
                result++;
            else if (array[i] > k)
                return result;
        }
        return result;
    }
}
