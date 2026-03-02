package Collections.Collection.Set;

import java.util.Iterator;
import java.util.TreeSet;

public class PTreeSet {

    static void main() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(100);
        set.add(500);
        set.add(1400);
        set.add(330);
        set.add(320);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(set.remove(200));



    }
}
