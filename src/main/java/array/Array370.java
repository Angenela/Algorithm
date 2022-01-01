package array;

/**
 * 差分数组
 */
public class Array370 {
    class Difference {
        private int diff[];

        public Difference(int nums[]) {
            int length = nums.length;
            diff = new int[length];
            diff[0] = nums[0];

            for (int i = 1; i < length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int k) {
            diff[i] += k;
            if (j + 1 < diff.length) {
                diff[i] -= k;
            }
        }

        public int[] result() {
            int length = diff.length;
            int result[] = new int[length];
            result[0] = diff[0];

            for (int i = 1; i < length; i++) {
                result[i] = diff[i] + result[i - 1];
            }

            return result;
        }
    }
}
