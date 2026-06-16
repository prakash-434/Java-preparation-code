Java Collections Framework - Complete Guide
What are Collections?
Collections are container objects that store groups of objects.
The Java Collections Framework provides a unified architecture for storing and manipulating groups of objects.
Added in Java version 1.2
Present in java.util package

Purpose of Collections

Dynamic sizing - Unlike arrays, collections can grow/shrink automatically
Ready-to-use data structures - No need to implement from scratch
High performance - Optimized implementations
Interoperability - Standard interfaces allow different implementations
Powerful utility methods - Searching, sorting, manipulation


Collections Hierarchy
Collection (Interface)
│
├── List (Interface)
│   ├── ArrayList
│   ├── LinkedList
│   ├── Vector
│   └── Stack
│
├── Set (Interface)
│   ├── HashSet
│   ├── LinkedHashSet
│   └── TreeSet
│
└── Queue (Interface)
    ├── PriorityQueue
    ├── ArrayDeque
    └── LinkedList

Map (Interface) - Separate hierarchy
├── HashMap
├── LinkedHashMap
├── TreeMap
├── Hashtable
└── ConcurrentHashMap
