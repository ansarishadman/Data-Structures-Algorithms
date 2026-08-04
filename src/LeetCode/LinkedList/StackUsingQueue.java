package LeetCode.LinkedList;

import java.util.*;

public class StackUsingQueue {
    public static void main(String[] args) {
        StackUsingQueue myStack = new StackUsingQueue();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        System.out.println("Top element (expected 3): " + myStack.top()); // returns 3

        // 2. Pop element
        System.out.println("Popped element (expected 3): " + myStack.pop()); // returns 3
        System.out.println("Top element after pop (expected 2): " + myStack.top()); // returns 2

        // 3. Check empty
        System.out.println("Is stack empty? (expected false): " + myStack.empty()); // returns false

        myStack.pop(); // pops 2
        myStack.pop(); // pops 1

        System.out.println("Is stack empty after popping all? (expected true): " + myStack.empty()); // returns true
    }

    private Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    public void push(int num) {
        queue.add(num); // Add element to the queue
        int size = queue.size(); // Store size before looping

        // Rotate existing elements behind the newly added element
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        Integer peek = queue.peek();
        return peek;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}