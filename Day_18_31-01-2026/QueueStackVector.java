// Day 18 – Queue, Stack (revision), and Vector

import java.util.*;

public class QueueStackVector {

    // ===== Queue =====
    // FIFO – First In First Out

    // Custom Queue using array
    static class MyQueue {
        int[] data;
        int front, rear, size;

        MyQueue(int cap) {
            data = new int[cap];
            front = rear = size = 0;
        }

        void enqueue(int val) {
            if (size == data.length) {
                System.out.println("Queue full!");
                return;
            }
            data[rear % data.length] = val;
            rear++;
            size++;
        }

        int dequeue() {
            if (isEmpty())
                throw new RuntimeException("Queue empty!");
            int val = data[front % data.length];
            front++;
            size--;
            return val;
        }

        int peek() {
            return data[front % data.length];
        }

        boolean isEmpty() {
            return size == 0;
        }

        int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        // ===== Queue =====
        System.out.println("=== Custom Queue ===");
        MyQueue q = new MyQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("peek    : " + q.peek());
        System.out.println("dequeue : " + q.dequeue());
        System.out.println("size    : " + q.size());

        System.out.println("\n=== java.util.LinkedList as Queue ===");
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println("poll : " + queue.poll());
        System.out.println(queue);

        // Deque (Double-ended queue)
        System.out.println("\n=== Deque (ArrayDeque) ===");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        System.out.println("Deque  : " + deque);
        System.out.println("peekFirst: " + deque.peekFirst());
        System.out.println("peekLast : " + deque.peekLast());

        // ===== Stack (revision) =====
        System.out.println("\n=== Stack ===");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack  : " + stack);
        System.out.println("pop    : " + stack.pop());

        // ===== Vector (legacy, thread-safe ArrayList) =====
        System.out.println("\n=== Vector ===");
        Vector<Integer> v = new Vector<>(3, 2); // initial cap 3, increment 2
        v.add(10);
        v.add(20);
        v.add(30);
        System.out.println("Vector     : " + v);
        System.out.println("capacity   : " + v.capacity());
        v.add(40); // triggers resize +2
        System.out.println("After add  : " + v + "  cap: " + v.capacity());
        v.remove(Integer.valueOf(20));
        System.out.println("After remove 20: " + v);
        System.out.println("firstElement: " + v.firstElement());
        System.out.println("lastElement : " + v.lastElement());
    }
}
