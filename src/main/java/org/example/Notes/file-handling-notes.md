# Java File Handling & I/O — Quick Revision Notes

---

# 1. Core Idea of Java I/O

Java reads/writes data using **Streams**.

A stream is a flow of data between:

```
Program (RAM)  ↔  File / Network / Keyboard
```

Two main categories:

1. Byte Streams
2. Character Streams

---

# 2. Byte Streams

Used for **binary data**.

Examples:

- Images
- Videos
- PDF
- ZIP files

---

## Base Classes

```
InputStream   → Reading bytes
OutputStream  → Writing bytes
```

---

## Important Classes

- FileInputStream
- FileOutputStream
- BufferedInputStream
- BufferedOutputStream

---

## Example — Write Bytes

```java
FileOutputStream fos = new FileOutputStream("test.txt");

String text = "Hello";

fos.write(text.getBytes());

fos.close();
```

---

## Example — Read Bytes

```java
FileInputStream fis = new FileInputStream("test.txt");

int data;

while((data = fis.read()) != -1){
    System.out.print((char)data);
}

fis.close();
```

---

## Important Points

`read()` → returns **int**

Range:

```
0–255 → valid byte
-1    → end of file
```

---

# 3. Character Streams

Used for **text files**.

Examples:

- `.txt`
- `.csv`
- `.json`
- `.xml`

---

## Base Classes

```
Reader  → Reading characters
Writer  → Writing characters
```

---

## Important Classes

- FileReader
- FileWriter
- BufferedReader
- BufferedWriter

---

## Example — Read File

```java
BufferedReader br = new BufferedReader(new FileReader("test.txt"));

String line;

while((line = br.readLine()) != null){
    System.out.println(line);
}

br.close();
```

---

## Example — Write File

```java
BufferedWriter bw = new BufferedWriter(new FileWriter("test.txt"));

bw.write("Hello Java");
bw.newLine();

bw.close();
```

---

# 4. Buffered Streams

Buffered streams improve **performance**.

Instead of reading **1 byte/character at a time**, they read **large chunks (buffer)**.

Typical buffer size:

```
8 KB
```

---

## Without Buffer

```
Program → Disk → Program → Disk → Program
(slow)
```

---

## With Buffer

```
Disk → Load chunk → Memory buffer → Program
(fast)
```

---

## Classes

- BufferedReader
- BufferedWriter
- BufferedInputStream
- BufferedOutputStream

---

# 5. Bridge Classes

Bridge classes convert **byte streams ↔ character streams**.

Classes:

- InputStreamReader
- OutputStreamWriter

---

## Conversion

```
bytes → characters   (InputStreamReader)
characters → bytes   (OutputStreamWriter)
```

---

## Example

```java
BufferedReader reader =
    new BufferedReader(
        new InputStreamReader(
            new FileInputStream("test.txt")));
```

---

## Flow

```
File
 ↓
FileInputStream (bytes)
 ↓
InputStreamReader (byte → char)
 ↓
BufferedReader
 ↓
Program
```

---

# 6. Scanner

Scanner is a **high-level input parser**.

Used for:

- Reading tokens
- Reading numbers
- Reading words
- Reading lines

---

## Example

```java
Scanner sc = new Scanner(new File("test.txt"));

while(sc.hasNextLine()){
    System.out.println(sc.nextLine());
}

sc.close();
```

---

## Scanner Methods

```
nextInt()
nextDouble()
next()
nextLine()
```

---

## Scanner vs BufferedReader

| Feature | Scanner | BufferedReader |
|-------|--------|----------------|
| Parsing | Built-in | Manual |
| Speed | Slower | Faster |
| Use case | User input | Large file reading |

---

# 7. Serialization

Serialization means converting an **object into a byte stream**.

```
Object → Byte Stream → File
```

Used for:

- Saving object state
- Network communication
- Caching

---

## Step 1 — Make Class Serializable

```java
import java.io.Serializable;

class Student implements Serializable {

    private String name;
    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){ return name; }
    public int getAge(){ return age; }
}
```

---

## Step 2 — Serialize Object

```java
Student s = new Student("Sanjeev",1);

ObjectOutputStream oos =
    new ObjectOutputStream(
        new FileOutputStream("student.txt"));

oos.writeObject(s);

oos.close();
```

---

## Step 3 — Deserialize Object

```java
ObjectInputStream ois =
    new ObjectInputStream(
        new FileInputStream("student.txt"));

Student st = (Student) ois.readObject();

System.out.println(st.getName() + " " + st.getAge());

ois.close();
```

---

# 8. Important Serialization Points

- Class must implement **Serializable**
- `readObject()` returns **Object**
- Type casting required
- File contains **binary data**

---

## Transient Keyword

Fields marked as **transient** are not serialized.

```java
transient int password;
```

---

# 9. Complete Java I/O Hierarchy

## BYTE STREAMS

```
InputStream
 ├ FileInputStream
 └ BufferedInputStream
```

```
OutputStream
 ├ FileOutputStream
 └ BufferedOutputStream
```

---

## CHARACTER STREAMS

```
Reader
 ├ FileReader
 └ BufferedReader
```

```
Writer
 ├ FileWriter
 └ BufferedWriter
```

---

## BRIDGE CLASSES

```
InputStreamReader
OutputStreamWriter
```

---

## UTILITY

```
Scanner
```

---

## OBJECT STREAMS

```
ObjectInputStream
ObjectOutputStream
```

---

# 10. Simple Mental Model

Binary files → **InputStream / OutputStream**

Text files → **Reader / Writer**

Performance → **Buffered Streams**

Conversion → **Bridge Classes**

Parsing → **Scanner**

Objects → **Serialization**

---

# 11. Most Important Interview Points

- `read()` returns **int** because **-1 represents EOF**
- `BufferedReader` is faster due to buffering
- `InputStreamReader` converts **bytes → characters**
- `Scanner` is slower but easier for parsing
- Serialization converts **objects → byte stream**

---

# 12. Real-World Usage

Most real Java programs use:

- BufferedReader
- BufferedWriter
- Scanner (for input parsing)
- Object streams (for serialization)