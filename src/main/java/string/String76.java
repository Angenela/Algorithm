package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口
 */
public class String76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        // 窗口
        Map<Character, Integer> windows = new HashMap<>();
        // 需要的字符
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int resultLeft = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            right++;
            // 增大窗口
            if (need.containsKey(c1)) {
                windows.put(c1, windows.getOrDefault(c1, 0) + 1);
                if (windows.get(c1).equals(need.get(c1)))
                    valid++;
            }

            // 减小窗口
            while (valid == need.size()) {
                if (right - left < len) {
                    resultLeft = left;
                    len = right - left;
                }
                char c2 = s.charAt(left);
                left++;
                if (need.containsKey(c2)) {
                    if (windows.get(c2).equals(need.get(c2)))
                        valid--;
                    windows.put(c2, windows.get(c2) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(resultLeft, len + resultLeft);
    }
}
