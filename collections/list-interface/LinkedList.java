LinkedList
Purpose & When to Use

Doubly-linked list implementation
Implements both List and Deque interfaces
Best for frequent insertions/deletions at beginning or middle
Use when you need queue/deque operations

Doubly linked list — implements both List AND Deque
No random access (O(n) for get(i)), but O(1) add/remove at head/tail
Higher memory overhead (each node holds prev + next pointers)
Time Complexity:

get(index): O(n)
add(element): O(1)
add(index, element): O(n)
addFirst()/addLast(): O(1)
removeFirst()/removeLast(): O(1)

    
javaimport java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        
        // ========== LIST OPERATIONS (Same as ArrayList) ==========
        list.add("A");
        list.add("B");
        list.add(1, "C");
        list.get(0);
        list.remove(0);
        list.set(0, "X");
        
        // ========== SPECIAL LINKEDLIST METHODS ==========
        // Add at beginning
        list.addFirst("First");
        list.offerFirst("First2");  // Same but returns boolean
        
        // Add at end
        list.addLast("Last");
        list.offerLast("Last2");    // Same but returns boolean
        
        // Get first/last
        String first = list.getFirst();
        String last = list.getLast();
        String peekFirst = list.peekFirst(); // Returns null if empty
        String peekLast = list.peekLast();   // Returns null if empty
        
        // Remove first/last
        list.removeFirst();
        list.removeLast();
        list.pollFirst();   // Returns null if empty
        list.pollLast();    // Returns null if empty
        
        // ========== QUEUE OPERATIONS ==========
        list.offer("Q1");       // Add to end (queue)
        list.poll();            // Remove from beginning
        list.peek();            // View first element
        
        // ========== STACK OPERATIONS ==========
        list.push("S1");        // Add to beginning (stack)
        list.pop();             // Remove from beginning
        
        // ========== DEQUE OPERATIONS ==========
        list.offerFirst("D1");
        list.offerLast("D2");
        list.pollFirst();
        list.pollLast();
    }
}
