package Collections.Collection.Set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class PLinkedHashSet {

    static void main() {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(100);
        set.add(400);
        set.add(300);
        set.add(200);
//        Iterator<Integer> it = set.iterator();
//        while ((it.hasNext())){
//            System.out.println(it.next());
//        }
        set.remove(400);
        Iterator<Integer> it = set.iterator();
        while ((it.hasNext())){
            System.out.println(it.next());
        }
    }
}
