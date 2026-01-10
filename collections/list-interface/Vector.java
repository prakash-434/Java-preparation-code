Vector
Purpose & When to Use

Synchronized version of ArrayList
Thread-safe but slower
Legacy class (use ArrayList with Collections.synchronizedList() instead)

javaimport java.util.Vector;
import java.util.Enumeration;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        Vector<String> vector2 = new Vector<>(20); // Initial capacity
        Vector<String> vector3 = new Vector<>(20, 10); // Capacity and increment
        
        // All ArrayList methods work
        vector.add("A");
        vector.add("B");
        vector.addElement("C");  // Legacy method
        
        // Vector-specific methods
        vector.capacity();       // Get capacity
        vector.firstElement();   // Get first
        vector.lastElement();    // Get last
        vector.removeElement("A"); // Remove by object
        vector.removeElementAt(0); // Remove by index
        vector.removeAllElements(); // Clear
        
        // Enumeration (legacy iterator)
        vector.add("X");
        vector.add("Y");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}