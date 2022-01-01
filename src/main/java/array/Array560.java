package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 前缀和
 */
public class Array560 {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;

        // map.get(x) 表示前缀和 x 出现的次数
        Map<Integer, Integer> map = new HashMap<>(length);
        map.put(0, 1);

        int sum_i = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            // 当前最多个数字的前缀和
            sum_i += nums[i];
            // 需要的前缀和
            int sum_j = sum_i - k;
            if (map.containsKey(sum_j)) {
                count += map.get(sum_j);
            }
            map.put(sum_i, map.getOrDefault(sum_i, 0) + 1);
        }

        return count;
    }
}
