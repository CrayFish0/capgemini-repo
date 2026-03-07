// Day 13 – HashMap and Hashing

import java.util.*;

public class HashMapDemo {
    public static void main(String[] args) {
        // ===== HashMap basics =====
        System.out.println("=== HashMap ===");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 78);
        scores.put("Charlie", 85);
        scores.put("Alice", 95); // update existing key

        System.out.println("Map           : " + scores);
        System.out.println("get Alice     : " + scores.get("Alice"));
        System.out.println("getOrDefault  : " + scores.getOrDefault("Dave", 0));
        System.out.println("containsKey   : " + scores.containsKey("Bob"));
        System.out.println("containsValue : " + scores.containsValue(85));
        scores.remove("Bob");
        System.out.println("After remove  : " + scores);

        // Iterate
        System.out.println("\nIterating keySet:");
        for (String key : scores.keySet())
            System.out.println("  " + key + " -> " + scores.get(key));

        System.out.println("\nIterating entrySet:");
        for (Map.Entry<String, Integer> entry : scores.entrySet())
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());

        // ===== Frequency counter (Hashing technique) =====
        System.out.println("\n=== Character Frequency ===");
        String str = "programming";
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : str.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        freq.forEach((c, f) -> System.out.println("'" + c + "' -> " + f));

        // ===== Anagram Check =====
        System.out.println("\n=== Anagram Check ===");
        System.out.println("'listen' vs 'silent': " + isAnagram("listen", "silent"));
        System.out.println("'hello'  vs 'world' : " + isAnagram("hello", "world"));

        // ===== Two Sum using HashMap =====
        System.out.println("\n=== Two Sum (HashMap) ===");
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        System.out.println("Pair summing to " + target + ": " + Arrays.toString(twoSum(arr, target)));
    }

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : a.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : b.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0)
                return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement))
                return new int[] { complement, arr[i] };
            map.put(arr[i], i);
        }
        return new int[] {};
    }
}
