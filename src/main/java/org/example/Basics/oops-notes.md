# Java Core – Complete Revision Notes

---

# 1️⃣ Java Memory Model

## Memory Areas Overview

### 🧵 Stack

- Local primitives
- Reference variables
- Method stack frames
- Thread-specific
- LIFO structure

✔ Automatically cleaned after method execution  
❌ Not managed by Garbage Collector

---

### 🗄 Heap

- Objects
- Instance variables
- Arrays
- Wrapper objects
- String Pool

✔ Managed by Garbage Collector  
✔ Shared memory region

---

### 🧠 Metaspace

- Class metadata
- Static variables
- One copy per class

---

## Memory Mapping Rules

| Item | Stored In |
|------|-----------|
| Local primitive | Stack |
| Instance primitive | Inside object (Heap) |
| Object | Heap |
| String literal | String Pool |
| Static variable | Metaspace |

---

# 2️⃣ Primitive vs Reference

## Primitive

```java
int a = 5;
```

- Value stored directly
- If local → stored in Stack

---

## Reference

```java
Student s = new Student();
```

- `s` → Stack
- Object → Heap
- `s` stores memory address

### Core Rule

- Primitive → stores value
- Reference → stores address

---

# 3️⃣ Instance Variable

```java
class A {
    int x;
}
```

- Belongs to object
- Stored inside heap object
- Each object gets separate copy

---

# 4️⃣ Static Variable

```java
class A {
    static int x;
}
```

- One copy per class
- Stored in Metaspace
- Access using `A.x`

---

# 5️⃣ Dynamic Memory Allocation

```java
A obj = new A();
```

- Memory allocated in Heap
- Instance variables initialized
- Reference stored in Stack

✔ All objects are dynamically allocated  
✔ Arrays are dynamically allocated

---

# 6️⃣ String Memory

```java
String a = "Java";
```

- Literal stored in String Pool
- `a` stored in Stack

### Using new

```java
String a = new String("Java");
```

Creates:
- Literal in pool (if absent)
- New object in Heap

✔ String is immutable  
✔ Any modification creates new object

---

# 7️⃣ Wrapper Classes

| Primitive | Wrapper |
|------------|----------|
| int | Integer |
| double | Double |
| char | Character |
| boolean | Boolean |
| long | Long |
| float | Float |

- Wrapper objects → Heap
- Reference → Stack

### Purpose

- Collections require objects
- Provide utility methods

---

# 8️⃣ Autoboxing / Unboxing

```java
Integer a = 5;   // Autoboxing
int b = a;       // Unboxing
```

Internally uses:
- `Integer.valueOf()`
- `intValue()`

---

# 9️⃣ Integer Caching

Range: **-128 to 127**

- Inside range → same object reused
- Outside range → new object created

---

# 🔟 Final Keyword

## Final Primitive

```java
final int x = 10;
```

✔ Value cannot change

---

## Final Object

```java
final A obj = new A();
```

- Reference cannot change
- Object state CAN change

✔ `obj.x = 50;` allowed  
❌ `obj = new A();` not allowed

### Rule

`final` locks reference, not object.

---

# 1️⃣1️⃣ Pass-by-Value

Java is always pass-by-value.

- Primitive → copy of value passed
- Object → copy of reference passed

Original reference never changes.

---

# 1️⃣2️⃣ Garbage Collection

✔ Works only on Heap

Object eligible when:
- No reachable reference exists

Reachability checked from:
- Stack references
- Static references
- Active threads

`System.gc()` is only a request.

---

## GC Types

- Minor GC
- Major GC
- Full GC

---

# 2️⃣ Singleton Pattern (Double Checked Locking)

```java
class Singleton {

    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```

### Why volatile?

Without it, JVM may:
1. Allocate memory
2. Assign reference
3. Initialize object

Another thread might see partially constructed object.

---

# 3️⃣ Static in Java

## Meaning

- Belongs to class, not object
- One copy exists
- Loaded when class loads

---

## Static Variable

```java
class Test {
    static int count = 0;
}
```

- One copy per class
- Stored in Method Area

Access:
```java
Test.count;
```

---

## Static Method

```java
class MathUtil {
    static int square(int x) {
        return x * x;
    }
}
```

Call:
```java
MathUtil.square(5);
```

### Rules

- Cannot access non-static directly
- Cannot use `this`
- Cannot use `super`
- Cannot be overridden (method hiding)

---

## Static Block

```java
class Demo {
    static {
        System.out.println("Static block executed");
    }
}
```

- Runs once
- Executes before main()

---

# 4️⃣ Inheritance & Polymorphism

## Reference vs Object Type Rule

- Reference type → decides accessible members (compile-time)
- Object type → decides overridden method (runtime)

---

## Dynamic Method Dispatch

```java
Parent obj = new Child();
obj.display();
```

- Resolved at runtime
- Based on object type
- Called Runtime Polymorphism / Late Binding

---

## Overriding Rules

- Same name
- Same parameters
- Cannot override:
 - final
 - private
 - static

---

## Early vs Late Binding

| Type | Binding Time | Example |
|------|--------------|----------|
| Early | Compile-time | Overloading, static methods |
| Late | Runtime | Overriding |

---

# 5️⃣ Encapsulation / Abstraction

## Encapsulation

- Wrapping data + methods into class
- Use private variables
- Access via getters/setters

---

## Abstraction

- Hiding implementation
- Achieved using:
 - Abstract class
 - Interface

---

# 6️⃣ Access Modifiers

| Modifier | Same Class | Same Package | Subclass (Same Pkg) | Subclass (Diff Pkg) | Diff Pkg (Non-Sub) |
|----------|------------|--------------|---------------------|---------------------|--------------------|
| public | ✔ | ✔ | ✔ | ✔ | ✔ |
| protected | ✔ | ✔ | ✔ | ✔ | ✘ |
| default | ✔ | ✔ | ✔ | ✘ | ✘ |
| private | ✔ | ✘ | ✘ | ✘ | ✘ |

---

# 7️⃣ instanceof vs getClass()

## instanceof

```java
obj instanceof Parent
```

- Works at runtime
- Checks inheritance hierarchy

---

## getClass()

```java
obj.getClass()
```

- Returns exact runtime class
- Does NOT consider hierarchy

---

# 🔥 Golden Summary

Stack → locals + references  
Heap → objects + instance data  
Metaspace → class metadata + static  
Java → always pass-by-value  
GC → removes unreachable heap objects  
Static → belongs to class  
Polymorphism → runtime method resolution

# Abstract Class in Java – Complete Revision Notes

---

## 1. What is an Abstract Class?

An abstract class:

- Cannot be instantiated
- Can contain abstract methods (without body)
- Can contain concrete methods (with body)

### Example

```java
abstract class Animal {
    abstract void sound();

    void sleep() {
        System.out.println("Sleeping");
    }
}
```

---

## 2. Core Rules

### Rule 1: Cannot create object directly

```java
Animal a = new Animal(); // Compile-time error
```

### Rule 2: If a class has even ONE abstract method,
it MUST be declared abstract.

```java
abstract class A {
    abstract void test();
}
```

### Rule 3: Subclass must implement all abstract methods

```java
class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}
```

OR the subclass must also be abstract:

```java
abstract class Dog extends Animal {
}
```

---

## 3. What Can an Abstract Class Contain?

| Feature | Allowed |
|----------|----------|
| Abstract methods | Yes |
| Concrete methods | Yes |
| Constructors | Yes |
| Static methods | Yes |
| Final methods | Yes |
| Instance variables | Yes |
| Static variables | Yes |
| Static / Instance blocks | Yes |

---

## 4. Constructors in Abstract Class

Abstract classes CAN have constructors.

```java
abstract class Animal {
    Animal() {
        System.out.println("Animal constructor");
    }
}
```

When:

```java
Dog d = new Dog();
```

Execution order:

1. Parent constructor runs
2. Child constructor runs

---

## 5. Final + Abstract

A method cannot be both `final` and `abstract`.

Reason:

- abstract → must override
- final → cannot override

Conflict.

---

## 6. Abstract Class vs Interface

| Feature | Abstract Class | Interface |
|----------|----------------|------------|
| Multiple inheritance | No | Yes |
| Constructor | Yes | No |
| Variables | Any type | public static final only |
| Methods | Abstract + Concrete | Abstract (+ default/static allowed) |

---

## 7. Polymorphism

```java
Animal a = new Dog();
```

- Reference type: Parent
- Object type: Child
- Method execution based on object type (runtime polymorphism)

---

## 8. Anonymous Abstract Class

```java
Animal a = new Animal() {
    void sound() {
        System.out.println("Meow");
    }
};
```

Creates anonymous subclass with immediate implementation.

---

## 9. Abstract Class Without Abstract Methods

```java
abstract class Test {
    void show() {
        System.out.println("Hello");
    }
}
```

Used to:

- Prevent object creation
- Force inheritance

---

## 10. Restrictions on Abstract Methods

Abstract methods cannot be:

- private
- final
- static

Because they must be overridden.

---

## 11. Real Backend Use Case

```java
abstract class Payment {
    abstract void pay();

    void generateReceipt() {
        System.out.println("Receipt generated");
    }
}
```

Used when:

- You want common reusable logic
- But force subclasses to implement specific behavior

# Java Interfaces – Complete Revision Notes

---

# 1️⃣ What is an Interface?

An interface is a blueprint of a class.

It defines:
- What a class must do
- But not how it does it (mostly)

It provides abstraction and supports loose coupling.

Example:

```java
interface Animal {
    void sound();
}
```

Implementation:

```java
class Dog implements Animal {
    public void sound() {
        System.out.println("Bark");
    }
}
```

---

# 2️⃣ Core Rules of Interface

## Rule 1: Cannot Instantiate

```java
Animal a = new Animal();  // ❌ Not allowed
```

---

## Rule 2: Methods are Public and Abstract by Default

Inside interface:

```java
void show();
```

Internally treated as:

```java
public abstract void show();
```

---

## Rule 3: Variables are Public Static Final by Default

```java
interface Test {
    int x = 10;
}
```

Internally:

```java
public static final int x = 10;
```

Rules:
- Must be initialized
- Cannot be modified
- Belong to interface

---

# 3️⃣ Interface Inheritance

## Interface → extends Interface

```java
interface A {
    void show();
}

interface B extends A {
    void display();
}
```

An interface can extend multiple interfaces:

```java
interface C extends A, B {}
```

---

## Class → implements Interface

```java
class Demo implements A {}
```

A class can implement multiple interfaces:

```java
class Demo implements A, B {}
```

---

# 4️⃣ Default Methods (Java 8+)

Interfaces can have default methods.

```java
interface A {
    default void show() {
        System.out.println("A");
    }
}
```

Purpose:
- Backward compatibility
- Add new methods without breaking old implementations

---

## Default Method Conflict Rule (Very Important)

If two interfaces contain same default method:

```java
interface A {
    default void show() {}
}

interface B {
    default void show() {}
}

class C implements A, B {}
```

Compile-time error due to ambiguity.

Solution:

```java
class C implements A, B {
    public void show() {
        A.super.show();
    }
}
```

Rule:
If multiple default implementations exist → class MUST override.

---

# 5️⃣ Static Methods in Interface

```java
interface A {
    static void show() {
        System.out.println("A");
    }
}
```

Call using:

```java
A.show();
```

Important:
- Static methods are NOT inherited
- Cannot call using object
- Cannot override

---

# 6️⃣ Private Methods (Java 9+)

Interfaces can have private methods.

```java
interface A {
    private void helper() {}
}
```

Used internally by default methods.

---

# 7️⃣ Polymorphism Using Interface Reference

```java
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Bark");
    }
}

Animal a = new Dog();
a.sound();   // Bark
```

Rules:
- Reference type → decides accessible methods (compile-time)
- Object type → decides overridden method execution (runtime)

---

# 8️⃣ Functional Interface

An interface with exactly ONE abstract method.

```java
@FunctionalInterface
interface A {
    void show();
}
```

Used with lambda expressions:

```java
A obj = () -> System.out.println("Hello");
```

---

# 9️⃣ Marker Interface

Interface with no methods.

Example:

```java
interface Serializable {}
```

Used to mark a class for special behavior.

---

# 🔟 Interface vs Abstract Class

| Feature | Interface | Abstract Class |
|----------|------------|----------------|
| Multiple inheritance | ✔ Yes | ✘ No |
| Constructor | ✘ No | ✔ Yes |
| Variables | public static final only | Any type |
| Methods | Abstract + default + static | Abstract + Concrete |
| Access modifiers | Public | Any |

---

# 1️⃣1️⃣ Overriding Rules

When implementing interface method:

- Must be public
- Cannot reduce visibility
- Must match method signature
- Return type must be same or covariant

---

# 1️⃣2️⃣ Static vs Default in Interface

| Feature | Default Method | Static Method |
|----------|----------------|---------------|
| Inherited | ✔ Yes | ✘ No |
| Overridable | ✔ Yes | ✘ No |
| Call using object | ✔ Yes | ✘ No |
| Call using interface name | ✘ No | ✔ Yes |

---

# 1️⃣3️⃣ Important Interview Traps

- Interface cannot have constructor.
- Interface cannot have static block.
- Interface can have main method (static).
- Class cannot extend interface (must implement).
- Interface cannot implement another interface (must extend).
- Cannot reduce visibility while overriding.
- Static methods are method hidden, not overridden.

---

# 🔥 Golden Summary

- Interface defines contract.
- Cannot instantiate.
- Methods → public abstract by default.
- Variables → public static final.
- Supports multiple inheritance.
- Java 8 → default + static methods.
- Java 9 → private methods.
- Enables loose coupling.
- Core to frameworks (Spring, JDBC, etc).
- Functional interfaces power lambdas.

# Java Generics & Sorting – Complete Revision Notes

---

## GENERICS

Generics provide compile-time type safety.

They allow writing reusable, type-safe classes.

They work only with object types, not primitives.

Generics exist only at compile time.

---

## WHY GENERICS

### Without Generics

```java
ArrayList list = new ArrayList();
list.add("Hello");
String s = (String) list.get(0); // Casting required
```

Manual casting required.  
Risk of ClassCastException at runtime.

---

### With Generics

```java
ArrayList<String> list = new ArrayList<>();
String s = list.get(0); // No casting
```

Type safety enforced at compile time.

---

## BENEFITS OF GENERICS

- Prevents ClassCastException
- Removes manual casting
- Safer and cleaner code
- Better readability

---

## TYPE PARAMETER NAMING

T → Type  
E → Element  
K → Key  
V → Value

These are conventions, not rules.

---

## IMPORTANT GENERIC RULES

Cannot use primitive types.

### Invalid

```java
List<int> list; // Not allowed
```

Must use wrapper classes:

```java
List<Integer> list;
```

Cannot create object of type parameter:

```java
T obj = new T(); // Not allowed
```

Reason:

Type erasure removes actual type at runtime.

---

## TYPE ERASURE

Java removes generic type information at runtime.

Generics exist only during compilation.

### Example

```java
List<String>
List<Integer>
```

Both become:

```java
List
```

at runtime.

Because of type erasure:

- Cannot use `new T()`
- Cannot check `instanceof List<String>`
- Cannot create generic arrays directly

Generics are a compile-time feature only.

---

## BOUNDED TYPES

### Upper Bound

```java
class Test<T extends Number>
```

T must be Number or its subclass.

Examples:

- Integer
- Double
- Float

Allows calling methods of Number.

---

## WILDCARDS

Wildcard means unknown type.

---

### UNBOUNDED WILDCARD

```java
List<?> list;
```

Can read elements as Object.  
Cannot add elements (except null).

---

### UPPER BOUND WILDCARD

```java
List<? extends Number>
```

Accepts Number or its subclass.

Can read.  
Cannot add.

Reason:

Actual type could be Integer, Double, etc.

---

### LOWER BOUND WILDCARD

```java
List<? super Integer>
```

Accepts Integer or its parent.

Can add Integer.  
Reading returns Object.

---

### Rule to Remember

Producer → extends  
Consumer → super

---

## COMPARABLE

Used to define natural ordering.

Implemented inside the class.

Only one natural ordering allowed.

Interface:

```java
public interface Comparable<T> {
    int compareTo(T o);
}
```

---

## COMPARETO RULES

Negative → this < other  
Zero → equal  
Positive → this > other

---

## COMPARABLE EXAMPLE

```java
class Student implements Comparable<Student> {

    int marks;

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }
}
```

---

## USED IN

- TreeSet
- TreeMap
- Collections.sort()

Important:

TreeSet uses compareTo() for sorting and duplicate detection.

If compareTo() returns 0 → Treated as duplicate.

TreeSet does not rely on equals().

---

## COMPARATOR

Used for custom sorting logic.

Defined outside the class.

Allows multiple sorting strategies.

Method:

```java
int compare(T o1, T o2);
```

---

## COMPARATOR EXAMPLE

```java
Comparator<Student> comp =
    (s1, s2) -> Integer.compare(s1.marks, s2.marks);
```

Sorting example:

```java
list.sort(Comparator.comparing(s -> s.name));
```

---

## COMPARABLE vs COMPARATOR

Defined in:

Comparable → Same class  
Comparator → Separate class or lambda

Method:

Comparable → compareTo()  
Comparator → compare()

Natural ordering:

Comparable → Yes  
Comparator → No

Multiple sorting logic:

Comparable → No  
Comparator → Yes

---

## IMPORTANT GENERIC CONCEPT

List<Integer> is NOT List<Number>.

Generics are invariant.

Even though Integer extends Number,  
List<Integer> does not extend List<Number>.

---

## SUMMARY

Generics provide compile-time type safety.  
Generics use type erasure.  
Cannot instantiate new T().  
Cannot use primitives in generics.  
Wildcards provide flexibility.  
Comparable defines natural ordering.  
Comparator defines custom ordering.  
TreeSet uses compareTo() for sorting and duplicate detection.

# Java Enum – Complete Revision Notes

---

## 1️⃣ What is Enum?

`enum` is a special type of class used to define a fixed set of constants.

Used when values are:

- Limited
- Predefined
- Constant
- Controlled

### Example

```java
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY
}
```

Usage:

```java
Day d = Day.MONDAY;
```

---

## 2️⃣ Why Use Enum?

### ❌ Without Enum

```java
String status = "SUCCESS";
```

Problems:

- Typo possible
- Any random string allowed
- No compile-time safety
- Hard to maintain

---

### ✅ With Enum

```java
enum Status {
    SUCCESS,
    FAILURE
}
```

Usage:

```java
Status status = Status.SUCCESS;
```

Benefits:

- Compile-time safety
- Only predefined values allowed
- Cleaner and safer code
- Type-safe constants

---

## 3️⃣ How Enum Works Internally

Enum is:

- A special class
- Extends `java.lang.Enum`
- Implicitly final
- Constructor is always private
- Constants are `public static final`
- Objects created at class loading time

Each constant = one object.

### Example

```java
enum Test {
    A,
    B,
    C;
}
```

👉 3 objects are created at class loading.

---

## 4️⃣ Enum Constructor

- Always private
- Cannot create object manually
- Called automatically for each constant

```java
enum Status {
    SUCCESS(200),
    FAILURE(500);

    int code;

    Status(int code) {
        this.code = code;
    }
}
```

---

## 5️⃣ Enum Can Have

| Feature | Allowed? |
|----------|----------|
| Variables | ✔ Yes |
| Methods | ✔ Yes |
| Constructor | ✔ Yes (private only) |
| Implement Interface | ✔ Yes |
| Extend Class | ❌ No |

---

## 6️⃣ Enum with Methods

```java
enum Status {
    SUCCESS,
    FAILURE;

    void print() {
        System.out.println(this);
    }
}
```

Usage:

```java
Status.SUCCESS.print();
```

---

## 7️⃣ Enum with Abstract Method (Advanced)

Enum can have abstract methods.

Each constant must implement it.

```java
enum Operation {

    ADD {
        int apply(int a, int b) {
            return a + b;
        }
    },

    SUBTRACT {
        int apply(int a, int b) {
            return a - b;
        }
    };

    abstract int apply(int a, int b);
}
```

---

## 8️⃣ Built-in Methods

Every enum has:

- `values()` → returns all constants
- `valueOf(String name)`
- `ordinal()` → position index (starts from 0)
- `name()` → constant name

### Example

```java
System.out.println(Status.SUCCESS.ordinal()); // 0
```

---

## 9️⃣ Switch with Enum

```java
switch (status) {
    case SUCCESS:
        break;
    case FAILURE:
        break;
}
```

---

## 🔟 Important Interview Points

- Enum constants are `public static final`
- Enum constructor is always private
- Enum cannot be extended
- Enum objects are created once
- Enum is thread-safe
- Number of enum objects = number of constants
- Created at class loading time

---

## 🔥 Golden Summary

- Enum = Type-safe, fixed set of singleton constants
- Better than using String for constant values
- Provides compile-time safety
- Can hold state and behavior
- Objects created once at class loading  