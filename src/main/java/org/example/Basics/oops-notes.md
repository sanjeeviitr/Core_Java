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

