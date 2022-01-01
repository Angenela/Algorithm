package array;

/**
 * 二分查找
 */
public class Array875 {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 0) return 0;

        int left = 1;
        int max = 0;
        for (int pile : piles)
            max = Math.max(pile, max);
        int right = max;

        // 因为 max 是可取的，所以是闭区间
        // 把 compute(piles, mid, h) 当为一个数组即可
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int k = compute(piles, mid, h);

            if (k == h) right = mid - 1;
            else if (k > h) left = mid + 1;
            else if (k < h) right = mid - 1;
        }

        // 当找到目标时，result = left
        // 因为肯定是有一个目标值的，即 max，所以直接返回
        return left;
    }

    public int compute(int[] piles, int k, int h) {
        int count = 0;

        for (int pile : piles) {
            int temp = pile / k;
            if (pile % k == 0) count += temp;
            else count += temp + 1;
        }

        return count;
    }
}
