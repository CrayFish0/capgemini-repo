// Day 12 – Collections Framework Overview
// java.util.Collection hierarchy: List, Set, Queue, Map (Map is not a Collection sub-type)

import java.util.*;

public class CollectionsOverview {
    public static void main(String[] args) {
        // ===== ArrayList (ordered, allows duplicates) =====
        System.out.println("=== ArrayList ===");
        List<String> list = new ArrayList<>(Arrays.asList("Banana", "Apple", "Cherry"));
        list.add("Mango");
        list.remove("Banana");
        Collections.sort(list);
        list.forEach(System.out::println);

        // ===== LinkedList (doubly-linked, also a Deque) =====
        System.out.println("\n=== LinkedList ===");
        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(3, 1, 4, 1, 5));
        ll.addFirst(0);
        ll.addLast(9);
        System.out.println(ll);

        // ===== HashSet (unordered, no duplicates) =====
        System.out.println("\n=== HashSet ===");
        Set<String> hs = new HashSet<>(Arrays.asList("Dog", "Cat", "Dog", "Bird"));
        System.out.println(hs); // "Dog" appears only once

        // ===== TreeSet (sorted, no duplicates) =====
        System.out.println("\n=== TreeSet ===");
        Set<Integer> ts = new TreeSet<>(Arrays.asList(5, 3, 8, 1, 9, 1));
        System.out.println(ts); // natural order

        // ===== HashMap =====
        System.out.println("\n=== HashMap ===");
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 90);
        map.put("Bob", 85);
        map.put("Charlie", 92);
        map.forEach((k, v) -> System.out.println(k + " -> " + v));
        System.out.println("get Alice: " + map.get("Alice"));
        System.out.println("containsKey Bob: " + map.containsKey("Bob"));

        // ===== Stack =====
        System.out.println("\n=== Stack ===");
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("peek: " + stack.peek());
        System.out.println("pop : " + stack.pop());
        System.out.println("size: " + stack.size());

        // ===== Queue (PriorityQueue) =====
        System.out.println("\n=== PriorityQueue ===");
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        while (!pq.isEmpty())
            System.out.print(pq.poll() + " "); // min-heap order
        System.out.println();
    }
}
