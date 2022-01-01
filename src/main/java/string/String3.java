package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class String3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;

        Map<Character, Integer> windows = new HashMap<>();

        int left = 0;
        int right = 0;
        int resultLen = 0;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            right++;
            windows.put(c1, windows.getOrDefault(c1, 0) + 1);

            while (windows.get(c1) > 1) {
                char c2 = s.charAt(left);
                left++;
                windows.put(c2, windows.get(c2) - 1);
            }

            if (right - left > resultLen) resultLen = right - left;
        }

        return resultLen;
    }
}
