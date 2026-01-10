PriorityQueue
Purpose & When to Use

Elements ordered by priority (natural order or comparator)
Min-heap by default
Use for task scheduling, Dijkstra's algorithm

javaimport java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // ========== CREATION ==========
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // Min-heap (default)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // Max-heap
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(20); // Initial capacity
        
        // ========== ADDING ELEMENTS ==========
        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(1);
        pq.offer(3); // Same as add, but returns boolean
        
        // ========== ACCESSING ELEMENTS ==========
        Integer head = pq.peek();  // View head without removing (returns null if empty)
        Integer element = pq.element(); // View head (throws exception if empty)
        
        // ========== REMOVING ELEMENTS ==========
        Integer removed = pq.poll();   // Remove and return head (null if empty)
        Integer removed2 = pq.remove(); // Remove and return head (exception if empty)
        pq.remove(5);  // Remove specific element
        
        // ========== ITERATING ==========
        // Note: Iterator doesn't guarantee order
        for (Integer num : pq) {
            System.out.println(num);
        }
        
        // Process in priority order
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        
        // ========== CUSTOM OBJECTS ==========
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(
            Comparator.comparingInt(Task::getPriority)
        );
        
        taskQueue.offer(new Task("Low", 3));
        taskQueue.offer(new Task("High", 1));
        taskQueue.offer(new Task("Medium", 2));
        
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll().getName());
        }
    }
}

class Task {
    String name;
    int priority;
    
    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
    
    String getName() { return name; }
    int getPriority() { return priority; }
}