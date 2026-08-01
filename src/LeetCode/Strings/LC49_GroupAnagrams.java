package LeetCode.Strings;

import java.util.*;
public class LC49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 1. Convert string to character array and sort it
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);

            // 2. If key doesn't exist, create a new list in the map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // 3. Add original string to its anagram group
            map.get(key).add(str);
        }

        // Return all values (lists of anagrams) from the map
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        LC49_GroupAnagrams solver = new LC49_GroupAnagrams();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Output: " + solver.groupAnagrams(strs));
        // Expected: [["bat"],["nat","tan"],["ate","eat","tea"]]
    }
}
