INTERVIEW QUESTIONS & ANSWERS
1. Why use Collections over Arrays?
Answer:

Dynamic sizing: Collections grow/shrink automatically
Rich API: Built-in methods for common operations
Type safety: Generics prevent ClassCastException
No primitive types: Arrays can store primitives, collections only objects (use wrapper classes)
Better abstractions: Interfaces allow different implementations

2. What is the difference between Collection and Collections?
Answer:

Collection: Interface at root of collection hierarchy
Collections: Utility class with static methods (sort, shuffle, reverse, etc.)

javaList<Integer> list = new ArrayList<>();
Collections.sort(list); // Using Collections utility class
3. How does HashMap work internally?
Answer:
HashMap uses array of buckets. When you put(key, value):

Calculate hashCode() of key
Apply hash function to determine bucket index
Store Entry object (key, value, hash, next) in bucket
If collision occurs, use linked list (Java 7) or balanced tree (Java 8+ if size > 8)
When load factor (0.75) exceeded, rehashing occurs (capacity doubles)

4. What is difference between HashMap and ConcurrentHashMap?
Answer:

HashMap: Not thread-safe, allows one null key
ConcurrentHashMap: Thread-safe, doesn't allow null keys/values, uses segment locking (better than Hashtable's full synchronization)

5. When to use ArrayList vs LinkedList?
Answer:

ArrayList: Random access, iteration, infrequent insertions/deletions
LinkedList: Frequent insertions/deletions at beginning/middle, queue/deque operations

6. What is fail-fast and fail-safe iterator?
Answer:

Fail-fast: Throws ConcurrentModificationException if collection modified during iteration (ArrayList, HashMap)
Fail-safe: Works on copy, doesn't throw exception (CopyOnWriteArrayList, ConcurrentHashMap)

javaList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
for (Integer num : list) {
    list.remove(num); // ConcurrentModificationException (fail-fast)
}

// Use Iterator.remove() instead
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    it.next();
    it.remove(); // Safe
}
7. How to make a collection thread-safe?
Answer:
javaList<String> list = Collections.synchronizedList(new ArrayList<>());
Set<String> set = Collections.synchronizedSet(new HashSet<>());
Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

// Or use concurrent collections
CopyOnWriteArrayList<String> concurrentList = new CopyOnWriteArrayList<>();
ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();
8. Difference between Comparable and Comparator?
Answer:
java// Comparable: Natural ordering, modify class
class Person implements Comparable<Person> {
    String name;
    int age;
    
    public int compareTo(Person other) {
        return this.age - other.age;
    }
}

Collections.sort(personList); // Uses compareTo()

// Comparator: Custom ordering, no class modification
Comparator<Person> byName = (p1, p2) -> p1.name.compareTo(p2.name);
Collections.sort(personList, byName);
9. What is the difference between == and equals() in collections?
Answer:

==: Compares references (memory addresses)
equals(): Compares contents (override in custom classes)

javaString s1 = new String("Hello");
String s2 = new String("Hello");

s1 == s2;       // false (different objects)
s1.equals(s2);  // true (same content)
10. How to create immutable collection?
Answer:
java// Java 9+
List<String> immutableList = List.of("A", "B", "C");
Set<String> immutableSet = Set.of("X", "Y", "Z");
Map<String, Integer> immutableMap = Map.of("A", 1, "B", 2);

// Pre-Java 9
List<String> list = Collections.unmodifiableList(new ArrayList<>(Arrays.asList("A", "B")));

This comprehensive guide covers all major collections in Java with syntax, use cases, comparisons, and interview perspectives!