TreeSet
Purpose & When to Use

Sorted set (natural ordering or custom comparator)
Backed by TreeMap (Red-Black tree)
No null elements allowed
Use when you need sorted unique elements

Red-Black Tree internally → always sorted
All operations O(log n)
Requires keys to be Comparable or you provide a Comparator


javaimport java.util.TreeSet;
import java.util.Comparator;

public class TreeSetDemo {
    public static void main(String[] args) {
        // ========== CREATION ==========
        TreeSet<Integer> set = new TreeSet<>(); // Natural ordering
        TreeSet<Integer> set2 = new TreeSet<>(Comparator.reverseOrder()); // Reverse
        TreeSet<String> set3 = new TreeSet<>(Arrays.asList("C", "A", "B"));
        
        // Custom comparator
        TreeSet<String> set4 = new TreeSet<>((s1, s2) -> s2.compareTo(s1)); // Reverse
        
        // ========== ADDING ELEMENTS ==========
        set.add(5);
        set.add(2);
        set.add(8);
        set.add(1);
        set.add(5); // Duplicate ignored
        // Elements automatically sorted: [1, 2, 5, 8]
        
        // ========== TREESET-SPECIFIC METHODS ==========
        Integer first = set.first();        // Get first (smallest)
        Integer last = set.last();          // Get last (largest)
        
        Integer lower = set.lower(5);       // Largest element < 5
        Integer floor = set.floor(5);       // Largest element <= 5
        Integer higher = set.higher(5);     // Smallest element > 5
        Integer ceiling = set.ceiling(5);   // Smallest element >= 5
        
        Integer pollFirst = set.pollFirst(); // Remove and return first
        Integer pollLast = set.pollLast();   // Remove and return last
        
        // Subset views
        TreeSet<Integer> headSet = (TreeSet<Integer>) set.headSet(5); // Elements < 5
        TreeSet<Integer> tailSet = (TreeSet<Integer>) set.tailSet(5); // Elements >= 5
        TreeSet<Integer> subSet = (TreeSet<Integer>) set.subSet(2, 8); // Elements >= 2 and < 8
        
        // Descending view
        TreeSet<Integer> descendingSet = (TreeSet<Integer>) set.descendingSet();
        Iterator<Integer> descendingIterator = set.descendingIterator();
        
        // ========== CUSTOM OBJECTS ==========
        TreeSet<Person> people = new TreeSet<>(Comparator.comparing(Person::getAge));
        people.add(new Person("Alice", 25));
        people.add(new Person("Bob", 20));
        people.add(new Person("Charlie", 30));
    }
}

class Person {
    String name;
    int age;
    
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    int getAge() { return age; }
}
Time Complexity:

add(): O(log n)
remove(): O(log n)
contains(): O(log n)