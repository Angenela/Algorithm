package array;

/**
 * 二分查找
 */
public class Array34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeft(nums, target), searchRight(nums, target)};
    }

    public int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) right = mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;
        }

        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    public int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) left = mid + 1;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid;
        }

        if (left == 0) return -1;
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
