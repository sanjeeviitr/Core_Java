package Practice_2;

public class Teacher implements Comparable<Teacher> {

    int age;
    String name;

    public Teacher(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Teacher o) {
        return this.age-o.age;
    }

//    public String compareTo(Teacher o){
//        return this.name > o.name;
//    }
}
