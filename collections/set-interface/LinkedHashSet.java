LinkedHashSet
Purpose & When to Use

Maintains insertion order
Slightly slower than HashSet
Use when you need uniqueness with predictable iteration order

javaimport java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        
        set.add("Banana");
        set.add("Apple");
        set.add("Mango");
        set.add("Apple"); // Duplicate ignored
        
        // Maintains insertion order
        for (String fruit : set) {
            System.out.println(fruit); // Banana, Apple, Mango
        }
        
        // All HashSet methods work the same
    }
}
