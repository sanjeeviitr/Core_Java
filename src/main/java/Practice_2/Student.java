package Practice_2;

public class Student implements Comparable<Student>{

    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
