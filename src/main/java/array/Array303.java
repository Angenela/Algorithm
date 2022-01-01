package array;

/**
 * 前缀和
 */
public class Array303 {
    class NumArray {
        // preNums[n] 代表前n的数的和，
        private int preNums[];

        public NumArray(int[] nums) {
            this.preNums = new int[nums.length + 1];
            for (int i = 1; i < preNums.length; i++) {
                this.preNums[i] = this.preNums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return this.preNums[right + 1] - this.preNums[left];
        }
    }
}
