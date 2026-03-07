// Day 17 – DSA: Arrays and Strings Problems

import java.util.Arrays;
import java.util.HashMap;

public class ArraysAndStrings {

    // 1. Rotate array by k positions (right)
    static void rotateRight(int[] arr, int k) {
        int n = k % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, n - 1);
        reverse(arr, n, arr.length - 1);
    }

    static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }

    // 2. Remove duplicates from sorted array (in-place)
    static int removeDuplicates(int[] arr) {
        if (arr.length == 0)
            return 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[j])
                arr[++j] = arr[i];
        return j + 1;
    }

    // 3. Longest substring without repeating characters
    static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left)
                left = map.get(c) + 1;
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    // 4. Check if a string is palindrome
    static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int l = 0, r = s.length() - 1;
        while (l < r)
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        return true;
    }

    // 5. Count vowels and consonants
    static void analyzeString(String s) {
        int vowels = 0, consonants = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiou".indexOf(c) >= 0)
                    vowels++;
                else
                    consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + "  Consonants: " + consonants);
    }

    public static void main(String[] args) {
        // Rotate
        int[] arr = { 1, 2, 3, 4, 5 };
        rotateRight(arr, 2);
        System.out.println("Rotated right 2: " + Arrays.toString(arr));

        // Remove duplicates
        int[] sorted = { 1, 1, 2, 3, 3, 4, 5, 5 };
        int len = removeDuplicates(sorted);
        System.out.println("After dedup, length: " + len + " -> " + Arrays.toString(Arrays.copyOf(sorted, len)));

        // Longest substring
        System.out.println("Longest no-repeat in 'abcabcbb': " + lengthOfLongestSubstring("abcabcbb"));

        // Palindrome
        System.out.println("'racecar' palindrome: " + isPalindrome("racecar"));
        System.out.println("'A man a plan a canal Panama' palindrome: " + isPalindrome("A man a plan a canal Panama"));

        // Analyze
        analyzeString("Hello World");
    }
}
