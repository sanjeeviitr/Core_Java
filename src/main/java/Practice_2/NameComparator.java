package Practice_2;

import java.util.Comparator;

public class NameComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o2.name.compareTo(o1.name);
    }
}
