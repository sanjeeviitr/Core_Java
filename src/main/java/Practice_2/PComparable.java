package Practice_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PComparable {

    static void main() {
        Teacher ram = new Teacher(12, "ram");
        Teacher shyam = new Teacher(12, "shyam");
        Teacher t2 = new Teacher(12, "t2");
        Teacher t3 = new Teacher(12, "t3");
        Teacher t4 = new Teacher(12, "t4");
        Teacher t6 = new Teacher(12, "t6");

        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.addAll(List.of(
                ram, shyam, t2, t3, t4, t6
        ));

        Collections.sort(teachers);

        Iterator<Teacher> it = teachers.iterator();
        while (it.hasNext()){
            System.out.println(it.next().name);
        }

    }
}
