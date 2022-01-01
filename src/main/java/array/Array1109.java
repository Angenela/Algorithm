package array;

/**
 * 差分数组
 */
public class Array1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int diff[] = new int[n];

        for (int i = 0; i < bookings.length; i++) {
            int x = bookings[i][0] - 1;
            int y = bookings[i][1] - 1;
            int z = bookings[i][2];

            diff[x] += z;
            if (y + 1 < n) {
                diff[y + 1] -= z;
            }
        }

        int result[] = new int[n];
        result[0] = diff[0];
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + diff[i];
        }

        return result;
    }
}
