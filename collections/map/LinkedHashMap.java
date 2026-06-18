LinkedHashMap
Purpose & When to Use

Maintains insertion order
Slightly slower than HashMap
Can maintain access order (LRU cache)

javaimport java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // ========== INSERTION ORDER ==========
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Banana", 2);
        map.put("Apple", 1);
        map.put("Mango", 3);
        
        // Maintains insertion order
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()); // Banana, Apple, Mango
        }
        
        // ========== ACCESS ORDER (LRU Cache) ==========
        // Third parameter: true = access order, false = insertion order
        LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<>(16, 0.75f, true);
        
        lruCache.put("A", 1);
        lruCache.put("B", 2);
        lruCache.put("C", 3);
        
        lruCache.get("A"); // Access A
        
        // Order: B, C, A (A moved to end after access)
        for (String key : lruCache.keySet()) {
            System.out.println(key);
        }
        
        // ========== LRU CACHE IMPLEMENTATION ==========
        LinkedHashMap<Integer, String> cache = new LinkedHashMap<Integer, String>(5, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size() > 5; // Remove oldest when size > 5
            }
        };
        
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        cache.put(4, "Four");
        cache.put(5, "Five");
        cache.put(6, "Six"); // Removes entry 1 (oldest)
        
        // All HashMap methods work
    }
}
