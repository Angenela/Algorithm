package array;

/**
 * 差分数组
 */
public class Array1094 {
    public static boolean carPooling(int[][] trips, int capacity) {
        int locations = 1001;
        int diff[] = new int[locations];

        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int sl = trips[i][1];
            int el = trips[i][2] - 1;

            diff[sl] += num;
            if (el + 1 < locations) {
                diff[el + 1] -= num;
            }
        }

        int result = diff[0];
        for (int i = 1; i < locations; i++) {
            if (result > capacity) return false;
            result = diff[i] + result;
        }

        return true;
    }
}
