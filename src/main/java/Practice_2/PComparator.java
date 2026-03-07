package Practice_2;

import java.util.*;

public class PComparator {

    static void main() {

//        Student ram = new Student(18, "ram");
//        Student rahul = new Student(32, "rahul");
//        Student shyam = new Student(31, "shyam");
//        Student ramu = new Student(14, "ramu");
//
//        ArrayList<Student> students = new ArrayList<>();
//        students.add(ram);
//        students.add(rahul);
//        students.add(shyam);
//        students.add(ramu);
//
////        Collections.sort(students, java.util.Comparator.comparing(a -> a.age));
////        Collections.sort(students, (s1,s2) -> s2.age - s1.age);
////        Collections.sort(students, Collections.reverseOrder());
//        Collections.sort(students);
//
//        students.sort(new NameComparator());
//        Iterator<Student> it = students.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next().name);
//        }

        Teacher t1 = new Teacher("1", "Ram", 4000);
        Teacher t2 = new Teacher("2", "Ramu", 2000);
        Teacher t3 = new Teacher("3", "Rahul", 3000);
        List<Teacher> teachers= new ArrayList<>(List.of(
            t1,t2,t3
        ));

        Collections.sort(teachers, new NameComparator());
        ListIterator<Teacher> it = teachers.listIterator();
        while (it.hasNext()){
            System.out.println(it.next().salary);
        }

    }
}
