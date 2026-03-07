// Day 13 – LinkedList
// Singly linked list implemented from scratch + java.util.LinkedList usage.

import java.util.LinkedList;

public class LinkedListDemo {

    // ===== Custom Singly Linked List =====
    static class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
        }
    }

    static class SinglyLinkedList {
        Node head;

        void insertAtEnd(int val) {
            Node n = new Node(val);
            if (head == null) {
                head = n;
                return;
            }
            Node cur = head;
            while (cur.next != null)
                cur = cur.next;
            cur.next = n;
        }

        void insertAtHead(int val) {
            Node n = new Node(val);
            n.next = head;
            head = n;
        }

        void delete(int val) {
            if (head == null)
                return;
            if (head.data == val) {
                head = head.next;
                return;
            }
            Node cur = head;
            while (cur.next != null && cur.next.data != val)
                cur = cur.next;
            if (cur.next != null)
                cur.next = cur.next.next;
        }

        void reverse() {
            Node prev = null, cur = head, next;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            head = prev;
        }

        void print() {
            Node cur = head;
            while (cur != null) {
                System.out.print(cur.data + " -> ");
                cur = cur.next;
            }
            System.out.println("null");
        }

        int length() {
            int count = 0;
            Node cur = head;
            while (cur != null) {
                count++;
                cur = cur.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Singly Linked List ===");
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtEnd(10);
        sll.insertAtEnd(20);
        sll.insertAtEnd(30);
        sll.insertAtHead(5);
        sll.print();
        System.out.println("Length: " + sll.length());
        sll.delete(20);
        sll.print();
        sll.reverse();
        System.out.println("Reversed: ");
        sll.print();

        // ===== java.util.LinkedList =====
        System.out.println("\n=== java.util.LinkedList ===");
        LinkedList<String> ll = new LinkedList<>();
        ll.add("Alice");
        ll.add("Bob");
        ll.add("Charlie");
        ll.addFirst("Zara");
        ll.addLast("Eve");
        System.out.println("List       : " + ll);
        System.out.println("First      : " + ll.getFirst());
        System.out.println("Last       : " + ll.getLast());
        ll.removeFirst();
        System.out.println("After removeFirst: " + ll);

        // As a Queue
        System.out.println("\nAs Queue:");
        ll.offer("Frank");
        System.out.println("peek  : " + ll.peek());
        System.out.println("poll  : " + ll.poll());
        System.out.println("Remaining: " + ll);
    }
}
