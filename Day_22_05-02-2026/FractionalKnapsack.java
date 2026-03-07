// Day 22 – Fractional Knapsack, Hashing (Anagram), Heaps, Huffman Algorithm

import java.util.*;

public class FractionalKnapsack {

    // ===== Fractional Knapsack (Greedy) =====
    static class Item {
        int weight, value;
        double ratio;

        Item(int w, int v) {
            weight = w;
            value = v;
            ratio = (double) v / w;
        }
    }

    static double fractionalKnapsack(Item[] items, int capacity) {
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio)); // sort by ratio desc
        double totalValue = 0.0;
        for (Item it : items) {
            if (capacity == 0)
                break;
            int take = Math.min(it.weight, capacity);
            totalValue += take * it.ratio;
            capacity -= take;
        }
        return totalValue;
    }

    // ===== Anagram Check via Hashing =====
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        int[] freq = new int[26];
        for (char c : a.toCharArray())
            freq[c - 'a']++;
        for (char c : b.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0)
                return false;
        }
        return true;
    }

    // Group anagrams together
    static Map<String, List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String w : words) {
            char[] arr = w.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(w);
        }
        return map;
    }

    // ===== Min-Heap and Max-Heap =====
    static void heapDemo() {
        System.out.println("=== Min-Heap (PriorityQueue) ===");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] vals = { 5, 3, 8, 1, 9, 2 };
        for (int v : vals)
            minHeap.offer(v);
        while (!minHeap.isEmpty())
            System.out.print(minHeap.poll() + " ");
        System.out.println();

        System.out.println("=== Max-Heap ===");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : vals)
            maxHeap.offer(v);
        while (!maxHeap.isEmpty())
            System.out.print(maxHeap.poll() + " ");
        System.out.println();

        // K smallest elements
        int[] arr = { 7, 2, 9, 1, 5, 3, 8 }, k = 3; // k largest using min-heap of size k
        PriorityQueue<Integer> kSmall = new PriorityQueue<>();
        for (int v : arr)
            kSmall.offer(v);
        System.out.print(k + " smallest: ");
        for (int i = 0; i < k; i++)
            System.out.print(kSmall.poll() + " ");
        System.out.println();
    }

    // ===== Huffman Encoding =====
    static class HuffNode implements Comparable<HuffNode> {
        char ch;
        int freq;
        HuffNode left, right;

        HuffNode(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public int compareTo(HuffNode o) {
            return this.freq - o.freq;
        }
    }

    static void buildHuffman(Map<Character, Integer> freqMap) {
        PriorityQueue<HuffNode> pq = new PriorityQueue<>();
        freqMap.forEach((c, f) -> pq.offer(new HuffNode(c, f)));

        while (pq.size() > 1) {
            HuffNode l = pq.poll(), r = pq.poll();
            HuffNode parent = new HuffNode('\0', l.freq + r.freq);
            parent.left = l;
            parent.right = r;
            pq.offer(parent);
        }

        System.out.println("=== Huffman Codes ===");
        printCodes(pq.peek(), "");
    }

    static void printCodes(HuffNode node, String code) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            System.out.println("  '" + node.ch + "' : " + code + "  (freq=" + node.freq + ")");
            return;
        }
        printCodes(node.left, code + "0");
        printCodes(node.right, code + "1");
    }

    public static void main(String[] args) {
        // Fractional Knapsack
        Item[] items = { new Item(10, 60), new Item(20, 100), new Item(30, 120) };
        System.out.printf("Fractional Knapsack (W=50): %.2f%n", fractionalKnapsack(items, 50));

        // Anagram
        System.out.println("\nAnagram 'listen'/'silent': " + isAnagram("listen", "silent"));
        System.out
                .println("Group anagrams: " + groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

        heapDemo();

        // Huffman
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : "aabbbccccddddd".toCharArray())
            freq.merge(c, 1, Integer::sum);
        System.out.println("\nFrequencies: " + freq);
        buildHuffman(freq);
    }
}
