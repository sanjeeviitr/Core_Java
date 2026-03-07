package Practice_2;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Teacher> {
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return Integer.compare(o1.salary, o2.salary);
    }
}
