package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动窗口
 */
public class String438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();

        Map<Character, Integer> windows = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> result = new ArrayList<>();

        while (right < s.length()) {
            char c1 = s.charAt(right);
            right++;
            if (need.containsKey(c1)) {
                windows.put(c1, windows.getOrDefault(c1, 0) + 1);
                if (windows.get(c1).equals(need.get(c1)))
                    valid++;
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }
                char c2 = s.charAt(left);
                left++;
                if (need.containsKey(c2)) {
                    if (need.get(c2).equals(windows.get(c2)))
                        valid--;
                    windows.put(c2, windows.get(c2) - 1);
                }
            }
        }

        return result;
    }
}
