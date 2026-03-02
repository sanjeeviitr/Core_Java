package Practice_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PComparator {

    static void main() {

        Student ram = new Student(18, "ram");
        Student rahul = new Student(32, "rahul");
        Student shyam = new Student(31, "shyam");
        Student ramu = new Student(14, "ramu");

        ArrayList<Student> students = new ArrayList<>();
        students.add(ram);
        students.add(rahul);
        students.add(shyam);
        students.add(ramu);

//        Collections.sort(students, java.util.Comparator.comparing(a -> a.age));
//        Collections.sort(students, (s1,s2) -> s2.age - s1.age);
//        Collections.sort(students, Collections.reverseOrder());
        Collections.sort(students);

//        students.sort(java.util.Comparator.comparing(a->a.name));
        Iterator<Student> it = students.iterator();
        while(it.hasNext()){
            System.out.println(it.next().name);
        }

    }
}
