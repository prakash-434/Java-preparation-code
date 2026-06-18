TreeMap
Purpose & When to Use

Sorted map (keys sorted by natural order or comparator)
Backed by Red-Black tree
No null keys (but null values allowed)
Use when you need sorted key-value pairs

Red-Black Tree internally → always sorted
All operations O(log n)
Requires keys to be Comparable or you provide a Comparator


javaimport java.util.TreeMap;
import java.util.Comparator;
import java.util.Map;

public class TreeMapDemo {
    public static void main(String[] args) {
        // ========== CREATION ==========
        TreeMap<Integer, String> map = new TreeMap<>(); // Natural ordering
        TreeMap<Integer, String> reverseMap = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<String, Integer> customMap = new TreeMap<>((s1, s2) -> s2.compareTo(s1));
        
        // ========== ADDING ELEMENTS ==========
        map.put(3, "Three");
        map.put(1, "One");
        map.put(5, "Five");
        map.put(2, "Two");
        // Keys automatically sorted: 1, 2, 3, 5
        
        // ========== TREEMAP-SPECIFIC METHODS ==========
        Map.Entry<Integer, String> firstEntry = map.firstEntry();
        Map.Entry<Integer, String> lastEntry = map.lastEntry();
        
        Integer firstKey = map.firstKey();
        Integer lastKey = map.lastKey();
        
        Map.Entry<Integer, String> lowerEntry = map.lowerEntry(3);   // Largest key < 3
        Map.Entry<Integer, String> floorEntry = map.floorEntry(3);   // Largest key <= 3
        Map.Entry<Integer, String> higherEntry = map.higherEntry(3); // Smallest key > 3
        Map.Entry<Integer, String> ceilingEntry = map.ceilingEntry(3); // Smallest key >= 3
        
        Map.Entry<Integer, String> pollFirst = map.pollFirstEntry(); // Remove first
        Map.Entry<Integer, String> pollLast = map.pollLastEntry();   // Remove last
        
        // ========== SUBMAP VIEWS ==========
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        
        TreeMap<Integer, String> headMap = (TreeMap<Integer, String>) map.headMap(3); // Keys < 3
        TreeMap<Integer, String> tailMap = (TreeMap<Integer, String>) map.tailMap(3); // Keys >= 3
        TreeMap<Integer, String> subMap = (TreeMap<Integer, String>) map.subMap(2, 5); // Keys >= 2 and < 5
        
        // ========== NAVIGATION ==========
        TreeMap<Integer, String> descendingMap = (TreeMap<Integer, String>) map.descendingMap();
        Set<Integer> descendingKeys = map.descendingKeySet();
        
        // ========== ITERATING (IN SORTED ORDER) ==========
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
Time Complexity:

get(): O(log n)
put(): O(log n)
remove(): O(log n)
containsKey(): O(log n)