All Types of Loops in Java
Java provides several types of loops for iteration. Here's a comprehensive guide:

1. for Loop
Basic for Loop
java// Syntax
for (initialization; condition; update) {
    // code block
}

// Example
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// Multiple variables
for (int i = 0, j = 10; i < j; i++, j--) {
    System.out.println(i + " " + j);
}

// Infinite loop
for (;;) {
    System.out.println("Infinite");
    break; // Need break to exit
}

// Without initialization
int i = 0;
for (; i < 5; i++) {
    System.out.println(i);
}

// Without update
for (int i = 0; i < 5;) {
    System.out.println(i);
    i++;
}

2. Enhanced for Loop (for-each)
java// Syntax
for (dataType variable : array/collection) {
    // code block
}

// Array example
int[] numbers = {1, 2, 3, 4, 5};
for (int num : numbers) {
    System.out.println(num);
}

// Collection example
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
for (String item : list) {
    System.out.println(item);
}

// 2D Array
int[][] matrix = {{1, 2}, {3, 4}};
for (int[] row : matrix) {
    for (int num : row) {
        System.out.println(num);
    }
}

// Map iteration
HashMap<String, Integer> map = new HashMap<>();
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

3. while Loop
java// Syntax
while (condition) {
    // code block
}

// Example
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}

// Infinite loop
while (true) {
    System.out.println("Infinite");
    break; // Need break to exit
}

// Loop until condition
Scanner sc = new Scanner(System.in);
String input = "";
while (!input.equals("exit")) {
    input = sc.nextLine();
    System.out.println("You entered: " + input);
}

// Array traversal
int[] arr = {1, 2, 3, 4, 5};
int index = 0;
while (index < arr.length) {
    System.out.println(arr[index]);
    index++;
}

4. do-while Loop
java// Syntax
do {
    // code block
} while (condition);

// Example
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 5);

// Executes at least once
int x = 10;
do {
    System.out.println("This prints even though x >= 10");
} while (x < 5);

// Menu-driven program
int choice;
do {
    System.out.println("1. Option 1");
    System.out.println("2. Option 2");
    System.out.println("3. Exit");
    choice = sc.nextInt();
    // process choice
} while (choice != 3);

// Input validation
int number;
do {
    System.out.println("Enter a positive number:");
    number = sc.nextInt();
} while (number <= 0);

5. Nested Loops
for within for
java// 2D pattern
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("* ");
    }
    System.out.println();
}

// Multiplication table
for (int i = 1; i <= 10; i++) {
    for (int j = 1; j <= 10; j++) {
        System.out.print(i * j + "\t");
    }
    System.out.println();
}
while within while
javaint i = 1;
while (i <= 3) {
    int j = 1;
    while (j <= 3) {
        System.out.println(i + "," + j);
        j++;
    }
    i++;
}
Mixed nested loops
javafor (int i = 0; i < 3; i++) {
    int j = 0;
    while (j < 3) {
        System.out.println(i + "," + j);
        j++;
    }
}

6. Loop Control Statements
break
java// Exit loop immediately
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break; // Exit loop when i is 5
    }
    System.out.println(i);
}

// Labeled break (for nested loops)
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) {
            break outer; // Breaks outer loop
        }
        System.out.println(i + "," + j);
    }
}
continue
java// Skip current iteration
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue; // Skip even numbers
    }
    System.out.println(i);
}

// Labeled continue
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (j == 1) {
            continue outer; // Continue outer loop
        }
        System.out.println(i + "," + j);
    }
}
return
java// Exit method (and loop)
public static void findNumber(int[] arr, int target) {
    for (int num : arr) {
        if (num == target) {
            System.out.println("Found!");
            return; // Exit method
        }
    }
    System.out.println("Not found");
}

7. Iterator Loop
java// Using Iterator
ArrayList<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add("C");

Iterator<String> iterator = list.iterator();
while (iterator.hasNext()) {
    String item = iterator.next();
    System.out.println(item);
    // Can safely remove during iteration
    if (item.equals("B")) {
        iterator.remove();
    }
}

// ListIterator (bidirectional)
ListIterator<String> listIterator = list.listIterator();
while (listIterator.hasNext()) {
    System.out.println(listIterator.next());
}
while (listIterator.hasPrevious()) {
    System.out.println(listIterator.previous());
}

8. Stream forEach (Java 8+)
java// ArrayList
ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
list.forEach(num -> System.out.println(num));

// Method reference
list.forEach(System.out::println);

// Array to Stream
int[] arr = {1, 2, 3, 4, 5};
Arrays.stream(arr).forEach(System.out::println);

// Map forEach
HashMap<String, Integer> map = new HashMap<>();
map.put("A", 1);
map.put("B", 2);
map.forEach((key, value) -> System.out.println(key + ": " + value));

// Stream operations
list.stream()
    .filter(n -> n % 2 == 0)
    .forEach(System.out::println);

9. Enumeration Loop (Legacy)
java// Vector or legacy collections
Vector<String> vector = new Vector<>();
vector.add("A");
vector.add("B");

Enumeration<String> enumeration = vector.elements();
while (enumeration.hasMoreElements()) {
    System.out.println(enumeration.nextElement());
}

10. Spliterator (Java 8+)
javaArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
Spliterator<String> spliterator = list.spliterator();

// forEachRemaining
spliterator.forEachRemaining(System.out::println);

// tryAdvance
Spliterator<String> spliterator2 = list.spliterator();
while (spliterator2.tryAdvance(item -> System.out.println(item))) {
    // Process one element at a time
}

Common Loop Patterns
Reverse loop
javafor (int i = 10; i > 0; i--) {
    System.out.println(i);
}
Step loop
javafor (int i = 0; i < 20; i += 2) {
    System.out.println(i); // Print even numbers
}
Loop with multiple conditions
javafor (int i = 0; i < 10 && i != 5; i++) {
    System.out.println(i);
}
Comma operator in for loop
javafor (int i = 0, j = 10; i < 5; i++, j--) {
    System.out.println(i + " " + j);
}
This covers all the loop types and variations available in Java!