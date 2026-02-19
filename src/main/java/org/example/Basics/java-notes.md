# Java Core Notes

--------------------------------------------------
JAVA ARCHITECTURE
--------------------------------------------------

JDK → Java Development Kit (used to write code)

JRE → Java Runtime Environment (used to run code)

JVM → Java Virtual Machine (executes bytecode)

Hierarchy:
JVM → inside JRE → inside JDK


--------------------------------------------------
COMPILATION FLOW
--------------------------------------------------

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


--------------------------------------------------
PRIMITIVE DATA TYPES
--------------------------------------------------

Type     | Size     | Example
--------------------------------
int      | 4 bytes  | 10
double   | 8 bytes  | 10.5
char     | 2 bytes  | 'A'
boolean  | 1 bit*   | true
long     | 8 bytes  | 100000L

(*boolean size is JVM dependent internally)


--------------------------------------------------
NON-PRIMITIVE TYPES
--------------------------------------------------

- String
- Arrays
- Classes
- Interfaces


--------------------------------------------------
IDENTIFIERS
--------------------------------------------------

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


--------------------------------------------------
NAMING CONVENTIONS
--------------------------------------------------

Variables → camelCase
Methods → camelCase
Classes → PascalCase
Constants → UPPER_CASE

In Java, `final` is used to declare constant variables.

Note:
Variable shadowing IS allowed in Java (inside different scopes).


--------------------------------------------------
LITERALS
--------------------------------------------------

Java has 5 main types of literals:

1. Integer Literals
   Whole numbers (no decimal)
   int a = 10;
   int b = -50;
   int c = 0b1010;   // binary
   int d = 012;      // octal
   int e = 0x1A;     // hexadecimal
   Default type → int
   Use L for long → 100000L

2. Floating-Point Literals
   double a = 10.5;
   Default type → double
   Use f or F for float → 3.14f

3. Character Literals
   char c = 'A';
   char d = '7';
   char e = '$';
   char c = 65;   // 'A'

4. String Literals
   String name = "Sanju";
   Stored in String Constant Pool.

5. Boolean Literals
   boolean a = true;
   boolean b = false;
   Must be lowercase.

Bonus:
Null Literal
String s = null;
(null is used only with objects, not primitives)


--------------------------------------------------
TYPE CASTING
--------------------------------------------------

1. Implicit Type Casting (Widening)
- Done automatically by Java
- Smaller → Larger type
- No data loss

byte → short → int → long → float → double
char ↗

Example:
int a = 10;
double b = a;

2. Explicit Type Casting (Narrowing)
- Done manually
- Larger → Smaller type
- May cause data loss

Example:
double a = 10.5;
int b = (int) a;


--------------------------------------------------
OPERATORS
--------------------------------------------------

Example:
int a = 5;
a++ + ++a

Step-by-step:
a++ → 5 (then a becomes 6)
++a → 7
Result → 5 + 7 = 12


--------------------------------------------------
OPERATOR PRECEDENCE (High → Low)
--------------------------------------------------

1. Postfix      ++  --
2. Unary        ++  --  +  -  !
3. Multiplicative  *  /  %
4. Additive     +  -
5. Relational   <  >  <=  >=
6. Equality     ==  !=
7. Logical AND  &&
8. Logical OR   ||
9. Assignment   =  +=  -=  *=  /=

Associativity:
- Most operators → Left to Right
- Assignment (=) → Right to Left
- Unary operators → Right to Left


--------------------------------------------------
CONTROL STATEMENTS
--------------------------------------------------

If-Else:
if(condition) {
// code
} else {
// code
}

Switch:
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

Do-While:
do {
// code
} while(condition);

--------------------------------------------------
METHODS / FUNCTIONS
--------------------------------------------------

A method is a block of code that performs a specific task.

Syntax:

returnType methodName(parameters) {
// body
return value;   // if return type is not void
}

Example:
int add(int a, int b) {
return a + b;
}

Why methods?
- Code reusability
- Better readability
- Modularity
- Easy debugging


--------------------------------------------------
JAVA IS ALWAYS PASS-BY-VALUE
--------------------------------------------------

Java passes a COPY of the variable, not the original.

Example:

static void change(int x) {
x = 100;
}

public static void main(String[] args) {
int a = 10;
change(a);
System.out.println(a); // 10
}

Explanation:
- 'a' is copied into 'x'
- Changes to 'x' do not affect 'a'

Important:
Even for objects, Java is still pass-by-value.
But the value passed is the copy of the reference.


--------------------------------------------------
STATIC vs NON-STATIC METHODS
--------------------------------------------------

1. Static Method

- Belongs to the class
- Shared among all objects
- Can be called without creating object
- Cannot directly access non-static members

Example:

static void show() {
System.out.println("Static method");
}

Call:
Demo.show();


2. Non-Static Method

- Belongs to object (instance)
- Requires object to call
- Can access both static and non-static members

Example:

void display() {
System.out.println("Non-static method");
}

Call:

public static void main(String[] args) {
Demo obj = new Demo();
obj.display();
}

--------------------------------------------------
VARARGS (Object... args)
--------------------------------------------------

Varargs allow a method to accept variable number of arguments.

Syntax:
datatype... variableName

Example 1:

static void printNumbers(int... numbers) {
for (int n : numbers) {
System.out.println(n);
}
}

Example 2 (Using Arrays utility):

import java.util.Arrays;

public class Demo {

    static void printNumbers(int... nums) {
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        printNumbers(1, 2, 3, 4, 5);
    }
}

Important Points:
- Internally, varargs is treated as an array.
- Only ONE varargs parameter allowed per method.
- It must be the LAST parameter.
- You can also pass an array directly:
  printNumbers(new int[]{1,2,3});


--------------------------------------------------
METHOD CALL STACK (STACK MEMORY)
--------------------------------------------------

When a method is called:
- A new stack frame is created.
- Local variables are stored inside it.
- After execution, it is removed from stack memory.

Stack follows:
LIFO (Last In First Out)

Example Call Flow:

main()
└── methodA()
└── methodB()

Execution Order:
1. methodB finishes
2. methodA finishes
3. main finishes


--------------------------------------------------
METHOD SIGNATURE
--------------------------------------------------

Method Signature =
Method Name + Parameter List

Example:
add(int, int)

Signature does NOT include:
- Return type
- Access modifier
- static keyword
- throws clause

Example:

int add(int a, int b)
double add(double a, double b)

Both are valid (method overloading)
Because signatures are different.


--------------------------------------------------
METHOD OVERRIDING
--------------------------------------------------

Overriding means:
Child class provides its own implementation of parent method.

Correct Rules for Overriding:

1. Same method signature (name + parameters)
2. Return type must be:
   - Same
     OR
   - Covariant (child type allowed)
3. Access modifier cannot be more restrictive.
4. Method must not be private.
5. Final methods cannot be overridden.

Example:

class Parent {
void show() {
System.out.println("Parent");
}
}

class Child extends Parent {
@Override
void show() {
System.out.println("Child");
}
}


--------------------------------------------------
STATIC METHODS AND OVERRIDING
--------------------------------------------------

Static methods ARE inherited.
But they are NOT overridden.

They are METHOD HIDDEN.

Reason:
- Overriding → Runtime (Dynamic Binding)
- Static methods → Compile-time binding

Example:

class A {
static void show() {
System.out.println("A");
}
}

class B extends A {
static void show() {
System.out.println("B");
}
}

This is NOT overriding.
This is Method Hiding.

Method selection depends on reference type,
NOT object type.


--------------------------------------------------
STRING IMMUTABILITY
--------------------------------------------------

String objects are IMMUTABLE in Java.

Meaning:
Once created, its value cannot be changed.

Example:

String s = "Hello";
s.concat(" World");

System.out.println(s);  // Hello

Reason:
- Stored in String Constant Pool
- Improves security
- Improves performance
- Enables caching


--------------------------------------------------
POINTERS IN JAVA
--------------------------------------------------

In Java, there are NO explicit pointers like C/C++.

But:
Java uses references internally.

Example:

Demo obj = new Demo();

Here:
- 'obj' is a reference variable.
- It stores the address of the object.
- But you cannot manipulate memory directly.


--------------------------------------------------
VARIABLE SHADOWING
--------------------------------------------------

Shadowing means:
A local variable or child variable hides another variable
with the same name.

1. Local Variable Shadowing Instance Variable

class Demo {
int x = 10;

    void show() {
        int x = 20;
        System.out.println(x);        // 20
        System.out.println(this.x);   // 10
    }
}

this.x refers to instance variable.


2. Static Variable Shadowing

class Demo {
static int x = 5;

    void show() {
        int x = 10;
        System.out.println(x);         // 10
        System.out.println(Demo.x);    // 5
    }
}

Use class name to access static variable.


3. Variable Shadowing in Inheritance

class Parent {
int x = 10;
}

class Child extends Parent {
int x = 20;

    void show() {
        System.out.println(x);        // 20
        System.out.println(super.x);  // 10
    }
}

super.x refers to parent class variable.

--------------------------------------------------
ARRAYS – IMPORTANT POINTS (Quick Revision)
--------------------------------------------------

Fixed Size
-----------------
- Size is decided at the time of creation.
- Cannot resize after creation.
- To resize:
  → Create new array
  OR
  → Use ArrayList (dynamic size)

Example:
int[] arr = new int[5];


Stored in Heap
-----------------
- Array object is created in HEAP memory.
- The variable stores the reference (address).

Example:
int[] arr = new int[3];

arr → reference
Object → stored in heap


Reference Copy vs Clone
----------------------------

int[] b = a;         // Same object
int[] b = a.clone(); // New object (safe for 1D)

Using '=':
- Copies reference
- Both point to SAME array

Using clone():
- Creates NEW array object
- Safe for 1D arrays

Important:
clone() gives shallow copy.
But for 1D arrays, shallow copy behaves like deep copy
because elements are primitives.


Pass-by-Value Concept
--------------------------

Java is ALWAYS pass-by-value.

For arrays:
- Reference is copied.
- Both references point to same array object.

Example:

static void change(int[] arr) {
arr[0] = 100;
}

Array elements can be modified inside method.


length is a PROPERTY
-------------------------

arr.length

- It is NOT a method.
- No parentheses.


Arrays Are Mutable
----------------------

arr[0] = 100;   // Allowed

Array contents can be changed after creation.

 Printing Arrays
--------------------

import java.util.Arrays;

Arrays.toString(arr);       // 1D array
Arrays.deepToString(arr);   // 2D array

System.out.println(arr);  // Prints address (not values)


--------------------------------------------------
2D ARRAYS (Very Important)
--------------------------------------------------

⃣2D Array = Array of Arrays
--------------------------------

int[][] arr = new int[2][3];

Memory Structure:

arr →  [ref] [ref]
↓      ↓
[0 0 0] [0 0 0]

Important:
Java 2D array is NOT continuous memory like C/C++.
It is an array of row arrays.


 Accessing 2D Elements
-------------------------

arr[row][column]

Example:
arr[1][2]


 Looping 2D Array
--------------------

for(int i = 0; i < arr.length; i++) {
for(int j = 0; j < arr[i].length; j++) {
System.out.println(arr[i][j]);
}
}

Important:
arr.length      → Number of rows
arr[i].length   → Columns in that row


--------------------------------------------------
JAGGED 2D ARRAY (Very Important)
--------------------------------------------------

Jagged Array = Unequal Row Sizes
----------------------------------------

int[][] arr = new int[3][];

arr[0] = new int[2];
arr[1] = new int[4];
arr[2] = new int[1];

Memory:

[ref] → [0 0]
[ref] → [0 0 0 0]
[ref] → [0]

Each row has different length.


 Why 2D clone() is Shallow
---------------------------------

int[][] b = a.clone();

What happens?
- Outer array is copied.
- Inner row arrays are SHARED.

So:

b[0][0] = 100;

Will also modify original array.

Reason:
Inner arrays are same objects in memory.


--------------------------------------------------
BONUS IMPORTANT ARRAY POINTS
--------------------------------------------------

🔹 Default Values:

int[] → 0
double[] → 0.0
boolean[] → false
char[] → '\u0000'
Object[] → null

🔹 Anonymous Array:

method(new int[]{1,2,3});

🔹 For-each Loop:

for(int n : arr) {
System.out.println(n);
}

🔹 Multidimensional array declaration styles:

int[][] a;
int a[][];
int[] a[];

(All valid, but first is preferred)

--------------------------------------------------
JAVA STRING – COMPLETE REVISION NOTES
--------------------------------------------------

WHAT IS STRING?
----------------

- String is a class in java.lang package.
- It is final.
- It is immutable.
- Widely used (HashMap keys, URLs, DB credentials).


--------------------------------------------------
MEMORY MODEL (Very Important)
--------------------------------------------------

Stack:
- Stores local variables
- Stores references

Heap:
- Stores objects
- Stores String Pool (special area inside heap)

Correct Memory Understanding:

Local primitive variable        → Stack
Instance primitive variable     → Inside object (Heap)
Object                          → Heap
String literal                  → String Pool (inside Heap)
Static variables                → Method Area / Metaspace


--------------------------------------------------
STRING POOL
--------------------------------------------------

- Special area inside heap.
- Stores unique string literals.
- Avoids duplicate objects.

Example:

String a = "Java";
String b = "Java";

Both refer to the same object.


--------------------------------------------------
STRING CREATION
--------------------------------------------------

Using Literal:

String s = "Hello";

- Stored in String Pool.

Using new:

String s = new String("Hello");

Creates:
- Literal in pool (if not present)
- New object in heap

So two objects exist.


--------------------------------------------------
IMMUTABILITY
--------------------------------------------------

- String class is final.
- Internal value array is final.
- Any modification creates a new object.

Example:

String s = "Hello";
s = s + " World";

Creates a new object.

Why String is Immutable?

- Security
- Thread safety
- Hashcode caching
- String Pool optimization


--------------------------------------------------
STRING COMPARISON
--------------------------------------------------

==
- Compares references.

.equals()
- Compares values.

Always prefer:
a.equals(b)


--------------------------------------------------
COMPILE-TIME vs RUNTIME CONCATENATION
--------------------------------------------------

Compile-Time (Only Literals):

String a = "Hel" + "lo";

- Compiler optimizes to "Hello"
- Stored in pool

Runtime (Using Variable):

String part = "Hel";
String b = part + "lo";

- Creates new object in heap


--------------------------------------------------
intern() METHOD
--------------------------------------------------

String a = new String("Java");
String b = a.intern();

- Moves string to pool (if not present)
- Returns pool reference


--------------------------------------------------
+ OPERATOR (Important)
--------------------------------------------------

Java supports operator overloading only for + with String.

Example:

"a" + 1

Result:
"a1"

Reason:
- 1 converted to Integer
- toString() called
- Concatenation happens

Rule:
At least one operand must be String.


--------------------------------------------------
STRING CONCATENATION PERFORMANCE
--------------------------------------------------

Bad Practice:

String s = "";
s = s + "abc";

Each + creates a new object.


--------------------------------------------------
STRINGBUILDER
--------------------------------------------------

- Mutable
- Not thread-safe
- Faster than String

Example:

StringBuilder sb = new StringBuilder();
sb.append("Hello");

Modifies same object.


--------------------------------------------------
STRINGBUFFER
--------------------------------------------------

- Mutable
- Thread-safe (synchronized)
- Slower than StringBuilder


--------------------------------------------------
PRETTY PRINTING
--------------------------------------------------

Using printf:

System.out.printf("%.2f", 12.3456);

Output:
12.35

Common Specifiers:

%d   → Integer
%f   → Float/Double
%.2f → 2 decimal places
%s   → String
%c   → Character


--------------------------------------------------
IMPORTANT STRING METHODS
--------------------------------------------------

length()
charAt()
substring()
indexOf()
replace()
trim()
split()
toUpperCase()
toLowerCase()
contains()
equals()
equalsIgnoreCase()


--------------------------------------------------
HASHCODE CACHING
--------------------------------------------------

- String caches hashcode internally.
- Improves HashMap performance.


--------------------------------------------------
STRING AS HASHMAP KEY
--------------------------------------------------

Safe because:
- Immutable
- Hashcode does not change
- Thread-safe

--------------------------------------------------
equals() vs hashCode() CONTRACT
--------------------------------------------------

Core Rule:

If a.equals(b) is true,
then a.hashCode() must be equal to b.hashCode().

Reverse is NOT mandatory:
Same hashCode does NOT guarantee equals() is true.

This situation is called a hash collision.


--------------------------------------------------
Why String is Perfect as HashMap Key
--------------------------------------------------

String works reliably as a key because:

- Immutable (state cannot change)
- hashCode() is cached
- equals() compares content
- hashCode() is consistent with equals()

So once inserted, key identity never changes.


--------------------------------------------------
StringBuilder Trap
--------------------------------------------------

StringBuilder:

- Mutable
- Does NOT override equals()
- Does NOT override hashCode()

It uses Object’s implementation:
- equals() → reference comparison
- hashCode() → identity-based

Example:

StringBuilder a = new StringBuilder("Java");
StringBuilder b = new StringBuilder("Java");

a.equals(b) → false

Even though content looks same. => because reference comparison


--------------------------------------------------
Hash Collision Example
--------------------------------------------------

"FB".hashCode() == "Ea".hashCode()

Reason (hash formula for 2 chars):

s[0]*31 + s[1]

"FB"
70*31 + 66 = 2236

"Ea"
69*31 + 97 = 2236

Same hashCode.
Different strings.


--------------------------------------------------
Why Collision Does Not Break HashMap
--------------------------------------------------

HashMap logic:

1. hashCode() → selects bucket
2. equals() → verifies actual key match

Even if two keys share same hashCode:
If equals() returns false,
they are treated as different keys.


--------------------------------------------------
Interview Takeaway
--------------------------------------------------

- Equal objects → must have equal hashCodes.
- Equal hashCodes → may not be equal objects.
- equals() decides real equality.
- hashCode() is only for bucket placement.
