HashMap
Purpose & When to Use

Key-value pairs
No duplicate keys (values can be duplicate)
Unordered
One null key, multiple null values
Best for fast lookups

javaimport java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        // ========== CREATION ==========
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>(20); // Initial capacity
        HashMap<String, Integer> map3 = new HashMap<>(20, 0.75f); // Capacity and load factor
        HashMap<String, Integer> map4 = new HashMap<>(map); // Copy constructor
        
        // Java 9+ - Map.of() (immutable, max 10 entries)
        Map<String, Integer> immutable = Map.of("A", 1, "B", 2);
        
        // ========== ADDING ELEMENTS ==========
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Mango", 30);
        map.put("Apple", 15); // Updates existing key
        map.put(null, 100);   // Null key allowed
        
        map.putAll(Map.of("Orange", 40, "Grapes", 50));
        
        // Put if absent
        map.putIfAbsent("Kiwi", 60); // Only adds if key doesn't exist
        
        // ========== ACCESSING ELEMENTS ==========
        Integer value = map.get("Apple");     // Get value (null if not found)
        Integer defaultValue = map.getOrDefault("Peach", 0); // Default if not found
        
        boolean containsKey = map.containsKey("Apple");
        boolean containsValue = map.containsValue(20);
        
        int size = map.size();
        boolean isEmpty = map.isEmpty();
        
        // ========== REMOVING ELEMENTS ==========
        map.remove("Apple");                    // Remove by key
        map.remove("Banana", 20);              // Remove if key-value match
        map.clear();                           // Remove all
        
        // ========== ITERATING ==========
        map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        
        // Iterate over keys
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
        
        // Iterate over values
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        
        // Iterate over entries (best performance)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        
        // Java 8 forEach
        map.forEach((key, value) -> System.out.println(key + " = " + value));
        
        // ========== JAVA 8+ OPERATIONS ==========
        // Compute new value
        map.compute("A", (key, val) -> val == null ? 1 : val + 1);
        
        // Compute if absent
        map.computeIfAbsent("D", key -> 4);
        
        // Compute if present
        map.computeIfPresent("A", (key, val) -> val * 2);
        
        // Merge
        map.merge("A", 10, (oldVal, newVal) -> oldVal + newVal);
        
        // Replace
        map.replace("A", 100);
        map.replace("A", 100, 200); // Replace if current value matches
        
        // ReplaceAll
        map.replaceAll((key, val) -> val * 2);
        
        // ========== VIEWS ==========
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
    }
}
Time Complexity:

get(): O(1)
put(): O(1)
remove(): O(1)
containsKey(): O(1)