# Java Core Notes

---

# JAVA ARCHITECTURE

JDK → Java Development Kit (used to write code)

JRE → Java Runtime Environment (used to run code)

JVM → Java Virtual Machine (executes bytecode)

Hierarchy:  
JVM → inside JRE → inside JDK

---

# COMPILATION FLOW

.java → compiled → .class (bytecode) → JVM runs it

javac (Java Compiler) converts .java code into bytecode (.class file).

The JVM:
1. Loads bytecode
2. Verifies it
3. Converts it into machine code
4. Executes it

Inside JVM:
- Interpreter (line-by-line execution initially)
- JIT Compiler (Just-In-Time compiler) for optimization

Note:  
JVM is machine specific.

---

# PRIMITIVE DATA TYPES

| Type    | Size     | Example |
|---------|----------|---------|
| int     | 4 bytes  | 10      |
| double  | 8 bytes  | 10.5    |
| char    | 2 bytes  | 'A'     |
| boolean | 1 bit*   | true    |
| long    | 8 bytes  | 100000L |

(*boolean size is JVM dependent internally)

---

# NON-PRIMITIVE TYPES

- String
- Arrays
- Classes
- Interfaces

---

# IDENTIFIERS

An identifier is the name given to:
- Variables
- Methods
- Classes
- Interfaces
- Packages

Rules:
- Can contain letters (a–z, A–Z)
- Can contain digits (0–9)
- Can contain underscore (_)
- Can contain dollar sign ($)
- Cannot start with a digit
- Cannot use Java keywords
- No spaces allowed
- Case sensitive

---

# NAMING CONVENTIONS

Variables → camelCase  
Methods → camelCase  
Classes → PascalCase  
Constants → UPPER_CASE

In Java, `final` is used to declare constant variables.

Note:  
Variable shadowing IS allowed in Java (inside different scopes).

---

# LITERALS

Java has 5 main types of literals:

## 1. Integer Literals

Whole numbers (no decimal)

```java
int a = 10;
int b = -50;
int c = 0b1010;   // binary
int d = 012;      // octal
int e = 0x1A;     // hexadecimal
```

Default type → int  
Use L for long → 100000L

---

## 2. Floating-Point Literals

```java
double a = 10.5;
```

Default type → double  
Use f or F for float → 3.14f

---

## 3. Character Literals

```java
char c = 'A';
char d = '7';
char e = '$';
char c = 65;   // 'A'
```

---

## 4. String Literals

```java
String name = "Sanju";
```

Stored in String Constant Pool.

---

## 5. Boolean Literals

```java
boolean a = true;
boolean b = false;
```

Must be lowercase.

Bonus:  
Null Literal

```java
String s = null;
```

(null is used only with objects, not primitives)

---

# TYPE CASTING

## 1. Implicit Type Casting (Widening)

- Done automatically by Java
- Smaller → Larger type
- No data loss

byte → short → int → long → float → double  
char ↗

Example:

```java
int a = 10;
double b = a;
```

---

## 2. Explicit Type Casting (Narrowing)

- Done manually
- Larger → Smaller type
- May cause data loss

Example:

```java
double a = 10.5;
int b = (int) a;
```

---

# OPERATORS

Example:

```java
int a = 5;
a++ + ++a
```

Step-by-step:
a++ → 5 (then a becomes 6)  
++a → 7  
Result → 5 + 7 = 12

---

# OPERATOR PRECEDENCE (High → Low)

1. Postfix → ++  --
2. Unary → ++  --  +  -  !
3. Multiplicative → *  /  %
4. Additive → +  -
5. Relational → <  >  <=  >=
6. Equality → ==  !=
7. Logical AND → &&
8. Logical OR → ||
9. Assignment → =  +=  -=  *=  /=

Associativity:
- Most operators → Left to Right
- Assignment (=) → Right to Left
- Unary operators → Right to Left

---

# CONTROL STATEMENTS

## If-Else

```java
if(condition) {
    // code
} else {
    // code
}
```

## Switch

```java
switch(day) {
case 1:
break;
case 2:
break;
case 3:
break;
default:
break;
}
```

## Do-While

```java
do {
    // code
} while(condition);
```

---

# METHODS / FUNCTIONS

A method is a block of code that performs a specific task.

Syntax:

```java
returnType methodName(parameters) {
    // body
    return value;   // if return type is not void
}
```

Example:

```java
int add(int a, int b) {
    return a + b;
}
```

Why methods?
- Code reusability
- Better readability
- Modularity
- Easy debugging

---

# JAVA IS ALWAYS PASS-BY-VALUE

Java passes a COPY of the variable, not the original.

Example:

```java
static void change(int x) {
    x = 100;
}

public static void main(String[] args) {
    int a = 10;
    change(a);
    System.out.println(a); // 10
}
```

Explanation:
- 'a' is copied into 'x'
- Changes to 'x' do not affect 'a'

Important:  
Even for objects, Java is still pass-by-value.  
But the value passed is the copy of the reference.

---