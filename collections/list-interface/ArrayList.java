ArrayList
Purpose & When to Use

Dynamic array implementation
Best for random access and iteration
Use when you need fast random access by index
Not synchronized (not thread-safe)

javaimport java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        // ========== CREATION ==========
        ArrayList<String> list1 = new ArrayList<>(); // Default capacity 10
        ArrayList<String> list2 = new ArrayList<>(20); // Initial capacity
        ArrayList<String> list3 = new ArrayList<>(list1); // Copy constructor
        
        // Using Arrays.asList()
        List<String> list4 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        
        // Java 9+ - List.of() (immutable)
        List<String> immutable = List.of("X", "Y", "Z");
        ArrayList<String> list5 = new ArrayList<>(immutable);
        
        // ========== ADDING ELEMENTS ==========
        ArrayList<String> list = new ArrayList<>();
        
        // Add at end
        list.add("Apple");           // [Apple]
        list.add("Banana");          // [Apple, Banana]
        
        // Add at specific index
        list.add(1, "Mango");        // [Apple, Mango, Banana]
        
        // Add multiple elements
        list.addAll(Arrays.asList("Orange", "Grapes")); // [Apple, Mango, Banana, Orange, Grapes]
        
        // Add collection at specific index
        list.addAll(2, Arrays.asList("Kiwi", "Peach")); // [Apple, Mango, Kiwi, Peach, Banana, Orange, Grapes]
        
        // ========== ACCESSING ELEMENTS ==========
        String first = list.get(0);              // Get element at index
        int size = list.size();                  // Get size
        boolean isEmpty = list.isEmpty();        // Check if empty
        boolean contains = list.contains("Mango"); // Check if contains element
        int index = list.indexOf("Banana");      // First occurrence index (-1 if not found)
        int lastIndex = list.lastIndexOf("Apple"); // Last occurrence index
        
        // ========== MODIFYING ELEMENTS ==========
        list.set(0, "Apricot");     // Replace element at index
        
        // ========== REMOVING ELEMENTS ==========
        list.remove(0);                  // Remove by index
        list.remove("Mango");           // Remove by object (first occurrence)
        list.removeAll(Arrays.asList("Kiwi", "Peach")); // Remove multiple
        list.retainAll(Arrays.asList("Banana", "Orange")); // Keep only these
        list.clear();                   // Remove all elements
        
        // Java 8+ - Remove if condition
        list.removeIf(fruit -> fruit.startsWith("A"));
        
        // ========== ITERATING ==========
        list = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        
        // For loop
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        
        // Enhanced for loop
        for (String item : list) {
            System.out.println(item);
        }
        
        // Iterator
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        // ListIterator (bidirectional)
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        
        // Java 8 forEach
        list.forEach(item -> System.out.println(item));
        list.forEach(System.out::println);
        
        // ========== SEARCHING & SORTING ==========
        Collections.sort(list);                    // Sort ascending
        Collections.sort(list, Collections.reverseOrder()); // Sort descending
        Collections.reverse(list);                 // Reverse
        Collections.shuffle(list);                 // Shuffle randomly
        
        // Binary search (list must be sorted first)
        Collections.sort(list);
        int position = Collections.binarySearch(list, "C");
        
        // ========== CONVERSION ==========
        // To Array
        String[] array = list.toArray(new String[0]);
        Object[] objArray = list.toArray();
        
        // To Stream (Java 8+)
        list.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);
        
        // Sublist
        List<String> subList = list.subList(1, 3); // From index 1 to 2 (exclusive end)
        
        // ========== OTHER OPERATIONS ==========
        ArrayList<String> clone = (ArrayList<String>) list.clone(); // Shallow copy
        list.ensureCapacity(50);                   // Increase capacity
        list.trimToSize();                         // Trim to current size
        
        // Java 8+ - replaceAll
        list.replaceAll(String::toUpperCase);
        
        // Frequency
        int count = Collections.frequency(list, "A");
        
        // Max and Min
        String max = Collections.max(list);
        String min = Collections.min(list);
    }
}
Time Complexity:

get(index): O(1)
add(element): O(1) amortized
add(index, element): O(n)
remove(index): O(n)
contains(element): O(n)