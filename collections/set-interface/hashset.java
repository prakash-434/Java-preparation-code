2. SET INTERFACE
HashSet
Purpose & When to Use

No duplicate elements
Unordered (no insertion order maintained)
Backed by HashMap
Allows one null element
Best for uniqueness with fast access

javaimport java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        // ========== CREATION ==========
        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>(20); // Initial capacity
        HashSet<String> set3 = new HashSet<>(20, 0.75f); // Capacity and load factor
        HashSet<String> set4 = new HashSet<>(Arrays.asList("A", "B", "C"));
        
        // ========== ADDING ELEMENTS ==========
        set.add("Apple");       // Returns true if added
        set.add("Banana");
        set.add("Apple");       // Returns false (duplicate)
        set.add(null);          // Null allowed
        
        set.addAll(Arrays.asList("Orange", "Grapes"));
        
        // ========== CHECKING ELEMENTS ==========
        boolean contains = set.contains("Apple");
        boolean isEmpty = set.isEmpty();
        int size = set.size();
        
        // ========== REMOVING ELEMENTS ==========
        set.remove("Apple");
        set.removeAll(Arrays.asList("Banana", "Orange"));
        set.retainAll(Arrays.asList("Grapes")); // Keep only these
        set.clear();
        
        // Java 8+
        set.removeIf(item -> item.startsWith("A"));
        
        // ========== ITERATING ==========
        set = new HashSet<>(Arrays.asList("A", "B", "C"));
        
        // Enhanced for loop
        for (String item : set) {
            System.out.println(item);
        }
        
        // Iterator
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        // Java 8 forEach
        set.forEach(System.out::println);
        
        // ========== SET OPERATIONS ==========
        HashSet<String> set1 = new HashSet<>(Arrays.asList("A", "B", "C"));
        HashSet<String> set2 = new HashSet<>(Arrays.asList("B", "C", "D"));
        
        // Union
        HashSet<String> union = new HashSet<>(set1);
        union.addAll(set2);  // [A, B, C, D]
        
        // Intersection
        HashSet<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);  // [B, C]
        
        // Difference
        HashSet<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);  // [A]
        
        // ========== CONVERSION ==========
        Object[] array = set.toArray();
        String[] strArray = set.toArray(new String[0]);
        
        // To List
        ArrayList<String> list = new ArrayList<>(set);
    }
}
Time Complexity:

add(): O(1)
remove(): O(1)
contains(): O(1)
size(): O(1)