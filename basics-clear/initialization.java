Data Types in Java
Java has two categories of data types: Primitive Data Types and Reference/Object Data Types.

1. Primitive Data Types
Java has 8 primitive data types:
byte (8-bit integer)
java// Declaration
byte b;

// Initialization techniques
byte b1 = 10;                    // Direct assignment
byte b2 = (byte) 130;            // Type casting (overflow)
byte b3 = Byte.parseByte("25");  // String to byte
byte b4 = Byte.MAX_VALUE;        // Using constants (127)
byte b5 = 0b1010;                // Binary literal
byte b6 = 0x0F;                  // Hexadecimal literal
short (16-bit integer)
java// Declaration
short s;

// Initialization techniques
short s1 = 1000;
short s2 = (short) 50000;        // Type casting
short s3 = Short.parseShort("500");
short s4 = Short.MIN_VALUE;      // -32768
short s5 = 0b1111111111111111;   // Binary
short s6 = 0x7FFF;               // Hexadecimal
int (32-bit integer)
java// Declaration
int i;

// Initialization techniques
int i1 = 100;                    // Direct assignment
int i2 = 1_000_000;              // With underscores for readability
int i3 = Integer.parseInt("123");
int i4 = Integer.MAX_VALUE;      // 2147483647
int i5 = 0b11111111;             // Binary
int i6 = 0xFF;                   // Hexadecimal
int i7 = 077;                    // Octal
int i8 = (int) 10.5;             // Type casting from double
int i9 = 'A';                    // From character (ASCII value)
long (64-bit integer)
java// Declaration
long l;

// Initialization techniques
long l1 = 100L;                  // With L suffix (required for literals)
long l2 = 10_000_000_000L;       // With underscores
long l3 = Long.parseLong("1234567890");
long l4 = Long.MAX_VALUE;
long l5 = 0b1111111111111111L;   // Binary
long l6 = 0xFFFFFFFFL;           // Hexadecimal
long l7 = System.currentTimeMillis(); // From method
float (32-bit floating point)
java// Declaration
float f;

// Initialization techniques
float f1 = 10.5f;                // With f suffix (required)
float f2 = 1.5e10f;              // Scientific notation
float f3 = Float.parseFloat("3.14");
float f4 = Float.MAX_VALUE;
float f5 = Float.POSITIVE_INFINITY;
float f6 = Float.NaN;            // Not a Number
float f7 = (float) 10.5;         // Type casting
float f8 = 10f;                  // Integer as float
double (64-bit floating point)
java// Declaration
double d;

// Initialization techniques
double d1 = 10.5;                // Direct (no suffix needed)
double d2 = 10.5d;               // With d suffix (optional)
double d3 = 1.5e100;             // Scientific notation
double d4 = Double.parseDouble("3.14159");
double d5 = Double.MAX_VALUE;
double d6 = Math.PI;             // From Math constants
double d7 = Math.sqrt(25);       // From method
double d8 = 100;                 // Implicit conversion from int
char (16-bit Unicode character)
java// Declaration
char c;

// Initialization techniques
char c1 = 'A';                   // Character literal
char c2 = 65;                    // Unicode value (A)
char c3 = '\u0041';              // Unicode escape sequence (A)
char c4 = '\n';                  // Escape sequence (newline)
char c5 = '\\';                  // Backslash
char c6 = (char) 97;             // Type casting (a)
char c7 = "Hello".charAt(0);     // From String method
boolean
java// Declaration
boolean bool;

// Initialization techniques
boolean bool1 = true;            // Direct assignment
boolean bool2 = false;
boolean bool3 = (5 > 3);         // From expression
boolean bool4 = Boolean.parseBoolean("true");
boolean bool5 = Boolean.TRUE;    // From Boolean class
boolean bool6 = "test".equals("test"); // From method
boolean bool7 = !false;          // Using NOT operator

2. Reference/Object Data Types
String
java// Declaration
String str;

// Initialization techniques
String str1 = "Hello";           // String literal (stored in String pool)
String str2 = new String("World"); // Using new keyword
String str3 = new String(new char[]{'J', 'a', 'v', 'a'});
String str4 = String.valueOf(123);
String str5 = "" + 100;          // Concatenation
String str6 = new String(new byte[]{65, 66, 67}); // From byte array
String str7 = "Hi".concat(" there");
String str8 = String.format("%d items", 10);
Arrays
java// Declaration
int[] arr1;
int arr2[];

// Initialization techniques
int[] arr3 = {1, 2, 3, 4, 5};    // Array initializer
int[] arr4 = new int[5];         // With size (default values)
int[] arr5 = new int[]{1, 2, 3}; // Anonymous array
int[][] arr6 = {{1, 2}, {3, 4}}; // 2D array
int[][] arr7 = new int[3][4];    // 2D with size

// For other types
String[] strArr = {"A", "B", "C"};
String[] strArr2 = new String[3];
Wrapper Classes
java// Integer
Integer int1 = 100;              // Autoboxing
Integer int2 = new Integer(100); // Constructor (deprecated)
Integer int3 = Integer.valueOf(100);
Integer int4 = Integer.valueOf("100");

// Double
Double d1 = 10.5;                // Autoboxing
Double d2 = Double.valueOf(10.5);
Double d3 = Double.valueOf("10.5");

// Boolean
Boolean b1 = true;               // Autoboxing
Boolean b2 = Boolean.valueOf(true);
Boolean b3 = Boolean.valueOf("true");

// Character
Character ch1 = 'A';             // Autoboxing
Character ch2 = Character.valueOf('A');
Objects (Custom Classes)
java// Assuming a class Person exists
Person p1 = new Person();        // Using constructor
Person p2 = new Person("John", 25); // Parameterized constructor
Person p3 = null;                // Null reference

// Using factory methods (if available)
Person p4 = Person.create();

// Using builder pattern (if implemented)
Person p5 = new Person.Builder()
    .name("Alice")
    .age(30)
    .build();
Collections
java// ArrayList
ArrayList<Integer> list1 = new ArrayList<>();
ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
List<String> list3 = new ArrayList<>(); // Using interface reference

// HashMap
HashMap<String, Integer> map1 = new HashMap<>();
Map<String, Integer> map2 = new HashMap<>();

// HashSet
HashSet<String> set1 = new HashSet<>();
Set<String> set2 = new HashSet<>(Arrays.asList("A", "B"));

Special Initialization Techniques
Default Values (for class fields)
javaclass Demo {
    int i;           // 0
    double d;        // 0.0
    boolean b;       // false
    char c;          // '\u0000'
    String s;        // null
    int[] arr;       // null
}
Final Variables
javafinal int CONSTANT = 100;        // Must initialize
final int value;
value = 50;                      // Blank final (initialized once)
Static Variables
javastatic int count = 0;
static final double PI = 3.14159;
static {
    count = 10;                  // Static block initialization
}
Var (Type Inference - Java 10+)
javavar x = 10;                      // Inferred as int
var name = "Java";               // Inferred as String
var list = new ArrayList<String>(); // Inferred as ArrayList<String>