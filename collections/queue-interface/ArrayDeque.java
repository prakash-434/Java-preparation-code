ArrayDeque
Purpose & When to Use

Resizable array implementation of Deque
Faster than LinkedList for queue/deque operations
No capacity restrictions, no null elements
Use as stack or queue (preferred over Stack and LinkedList)

javaimport java.util.ArrayDeque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        
        // ========== ADD OPERATIONS ==========
        // Add at end
        deque.add("A");
        deque.addLast("B");
        deque.offer("C");
        deque.offerLast("D");
        
        // Add at beginning
        deque.addFirst("X");
        deque.offerFirst("Y");
        deque.push("Z"); // Stack operation
        
        // ========== ACCESS OPERATIONS ==========
        String first = deque.getFirst();
        String last = deque.getLast();
        String peekFirst = deque.peekFirst();
        String peekLast = deque.peekLast();
        String peek = deque.peek(); // Same as peekFirst
        
        // ========== REMOVE OPERATIONS ==========
        String removeFirst = deque.removeFirst();
        String removeLast = deque.removeLast();
        String pollFirst = deque.pollFirst();
        String pollLast = deque.pollLast();
        String poll = deque.poll(); // Same as pollFirst
        String pop = deque.pop();   // Stack operation
        
        // ========== USE AS STACK ==========
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // 3, 2, 1
        }
        
        // ========== USE AS QUEUE ==========
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        
        while (!queue.isEmpty()) {
            System.out.println(queue.poll()); // 1, 2, 3
        }
    }
}
