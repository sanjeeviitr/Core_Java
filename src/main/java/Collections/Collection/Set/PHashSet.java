package Collections.Collection.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class PHashSet {

    static void main() {
        Set<Integer> st = new HashSet<>();
        st.add(100);
        st.add(200);
        st.add(400);
        st.add(300);
        st.add(200);
        Iterator<Integer> it = st.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        st.remove(200);
        System.out.println(st.contains(300));

        Set<Integer> st2 = new HashSet<>();
        st2.add(300);
//        st2.addAll(st);
//        Iterator<Integer> it2 = st2.iterator();
//        while(it2.hasNext()){
//            System.out.println(it2.next());
//        }
        st2.retainAll(st);
        Iterator<Integer> it2 = st2.iterator();

        while(it2.hasNext()){
            System.out.println(it2.next());
        }
    }
}
