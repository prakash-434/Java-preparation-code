Stack
Purpose & When to Use

LIFO (Last In First Out) data structure
Extends Vector
Use for undo operations, expression evaluation, backtracking

javaimport java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        
        // Push elements
        stack.push("A");
        stack.push("B");
        stack.push("C");
        
        // Peek - view top without removing
        String top = stack.peek();  // "C"
        
        // Pop - remove and return top
        String popped = stack.pop(); // "C"
        
        // Search - 1-based position from top
        int position = stack.search("A"); // 2 (from top)
        
        // Check if empty
        boolean empty = stack.empty();
        
        // All Vector methods also work
        stack.get(0);
        stack.size();
    }
}
