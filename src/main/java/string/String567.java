package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class String567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c1 = s2.charAt(right);
            right++;
            if (need.containsKey(c1)) {
                windows.put(c1, windows.getOrDefault(c1, 0) + 1);
                if (need.get(c1).equals(windows.get(c1)))
                    valid++;
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char c2 = s2.charAt(left);
                left++;
                if (need.containsKey(c2)) {
                    if (need.get(c2).equals(windows.get(c2)))
                        valid--;
                    windows.put(c2, windows.get(c2) - 1);
                }
            }
        }

        return false;
    }
}
