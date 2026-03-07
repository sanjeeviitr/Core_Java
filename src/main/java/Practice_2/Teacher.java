package Practice_2;

public class Teacher implements Comparable<Teacher> {

    String id;
    String name;
    int salary;

    public Teacher(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }



    @Override
    public int compareTo(Teacher o) {
        return this.id.compareTo(o.id);
    }

//    public String compareTo(Teacher o){
//        return this.name > o.name;
//    }
}
