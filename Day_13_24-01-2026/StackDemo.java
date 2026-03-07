// Day 13 – Stack
// LIFO – Last In First Out. Custom implementation + java.util.Stack

import java.util.Stack;

public class StackDemo {

    // ===== Custom Stack =====
    static class MyStack {
        private int[] data;
        private int top;

        MyStack(int capacity) {
            data = new int[capacity];
            top = -1;
        }

        void push(int val) {
            if (top == data.length - 1) {
                System.out.println("Stack overflow!");
                return;
            }
            data[++top] = val;
        }

        int pop() {
            if (isEmpty())
                throw new RuntimeException("Stack underflow!");
            return data[top--];
        }

        int peek() {
            if (isEmpty())
                throw new RuntimeException("Stack is empty!");
            return data[top];
        }

        boolean isEmpty() {
            return top == -1;
        }

        int size() {
            return top + 1;
        }
    }

    // Balanced brackets using Stack
    static boolean isBalanced(String expr) {
        Stack<Character> st = new Stack<>();
        for (char c : expr.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                st.push(c);
            else if (c == ')' || c == ']' || c == '}') {
                if (st.isEmpty())
                    return false;
                char top = st.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{'))
                    return false;
            }
        }
        return st.isEmpty();
    }

    // Reverse a string using Stack
    static String reverse(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray())
            st.push(c);
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Custom Stack ===");
        MyStack ms = new MyStack(5);
        ms.push(10);
        ms.push(20);
        ms.push(30);
        System.out.println("peek : " + ms.peek());
        System.out.println("pop  : " + ms.pop());
        System.out.println("size : " + ms.size());

        System.out.println("\n=== Balanced Brackets ===");
        System.out.println("{[()]}   : " + isBalanced("{[()]}"));
        System.out.println("{[(])}   : " + isBalanced("{[(])}"));
        System.out.println("((()))   : " + isBalanced("((()))"));

        System.out.println("\n=== Reverse String ===");
        System.out.println(reverse("Capgemini"));
    }
}
