package array;

/**
 * 二分查找
 */
public class Array1011 {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        for (int weight : weights) max += weight;

        int left = 0;
        int right = max + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int k = compute(weights, mid);

            if (k == days) right = mid;
            else if (k < days) right = mid;
            else if (k > days) left = mid + 1;
        }

        // left == right，result = left
        // 因为肯定有正确值，所以直接返回
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Array1011().shipWithinDays(new int[]{1, 2, 3, 1 ,1 }, 4));
    }

    public int compute(int[] weights, int speed) {
        int result = 0;
        int temp = 0;

        for (int weight : weights) {
            if (weight > speed) return Integer.MAX_VALUE;
            temp += weight;

            if (temp >= speed) {
                if (temp == speed) temp = 0;
                if (temp > speed) temp = weight;
                result++;
            }
        }
        if (temp != 0)
            result++;

        return result;
    }
}
