// Day 14 – ArrayList, HashSet, LinkedHashSet, TreeSet and Overriding

import java.util.*;

public class CollectionsAdvanced {

    // ===== Custom class to demonstrate Comparable / overriding =====
    static class Student implements Comparable<Student> {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        // Natural ordering: by marks descending
        @Override
        public int compareTo(Student other) {
            return Integer.compare(other.marks, this.marks);
        }

        @Override
        public String toString() {
            return name + "(" + marks + ")";
        }

        // Required for HashSet/HashMap equality
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Student s))
                return false;
            return marks == s.marks && Objects.equals(name, s.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, marks);
        }
    }

    public static void main(String[] args) {
        // ===== ArrayList =====
        System.out.println("=== ArrayList ===");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 92));
        students.add(new Student("Charlie", 78));
        students.add(new Student("Dave", 92));
        Collections.sort(students); // uses compareTo (marks desc)
        System.out.println("Sorted by marks (desc): " + students);
        students.sort(Comparator.comparing(s -> s.name)); // by name
        System.out.println("Sorted by name         : " + students);
        System.out.println("subList(1,3)           : " + students.subList(1, 3));

        // ===== HashSet =====
        System.out.println("\n=== HashSet (no order, no duplicates) ===");
        Set<String> hs = new HashSet<>(Arrays.asList("mango", "apple", "banana", "apple"));
        System.out.println(hs); // "apple" once only, order unpredictable

        // ===== LinkedHashSet =====
        System.out.println("\n=== LinkedHashSet (insertion order preserved) ===");
        Set<String> lhs = new LinkedHashSet<>(Arrays.asList("mango", "apple", "banana", "apple"));
        System.out.println(lhs); // insertion order, "apple" once

        // ===== TreeSet =====
        System.out.println("\n=== TreeSet (natural sorted order) ===");
        Set<Integer> ts = new TreeSet<>(Arrays.asList(5, 3, 8, 1, 9, 3, 7));
        System.out.println(ts); // sorted ascending, no duplicates

        // TreeSet with custom Comparator (descending)
        TreeSet<String> tsDesc = new TreeSet<>(Comparator.reverseOrder());
        tsDesc.addAll(Arrays.asList("banana", "apple", "cherry", "date"));
        System.out.println("TreeSet desc: " + tsDesc);

        // ===== Set operations =====
        System.out.println("\n=== Set Operations ===");
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6, 7));

        Set<Integer> union = new HashSet<>(a);
        union.addAll(b);
        Set<Integer> inter = new HashSet<>(a);
        inter.retainAll(b);
        Set<Integer> diff = new HashSet<>(a);
        diff.removeAll(b);
        System.out.println("Union        : " + union);
        System.out.println("Intersection : " + inter);
        System.out.println("Difference   : " + diff);
    }
}
