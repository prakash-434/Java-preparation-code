
Hashtable
Purpose & When to Use

Synchronized version of HashMap
Thread-safe but slower
No null keys or values
Legacy class (use ConcurrentHashMap instead)

javaimport java.util.Hashtable;

public class HashtableDemo {
    public static void main(String[] args) {
        Hashtable<String, Integer> table = new Hashtable<>();
        
        table.put("A", 1);
        table.put("B", 2);
        // table.put(null, 3); // NullPointerException
        // table.put("C", null); // NullPointerException
        
        // All HashMap methods work (synchronized)
        Integer value = table.get("A");
        table.remove("B");
        
        // Legacy methods
        table.contains(1);  // Check if value exists
        Enumeration<String> keys = table.keys();
        Enumeration<Integer> values = table.elements();
    }
}