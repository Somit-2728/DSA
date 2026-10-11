import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
         List<Integer> res = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) {
            return res;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        // Store frequency of characters in p
        for (int i = 0; i < m; i++) {
            char ch = p.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
            }

            // Window size should not exceed p.length()
            if (right - left + 1 > m) {
                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                }

                left++;
            }

            // Check if current window has length m and all required
            // character frequencies have been matched
            if (right - left + 1 == m) {
                boolean valid = true;

                for (int value : map.values()) {
                    if (value != 0) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    res.add(left);
                }
            }
        }

        return res;
    }
}