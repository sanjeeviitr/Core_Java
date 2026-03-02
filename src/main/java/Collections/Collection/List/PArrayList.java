package Collections.Collection.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PArrayList {

    static void main() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        list.add(30);
        list.add(1,8);
        list.set(0,1);
        list.add(20);
        list.add(100);
        list.add(80);
        list.addFirst(2222);
//        System.out.println(list.contains(100));
//        System.out.println(list.indexOf(10));
//        System.out.println(list.remove(5));
//        System.out.println(list.indexOf(10));
        Collections.sort(list);
//        Collections.sort(list, Collections.reverseOrder());

        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
//        list.clear();
//        int[] arr = new int[list.size()];
//        for(int i=0;i<list.size();i++){
//            arr[i]= list.get(i);
//        }
//        int [] arr = list.stream().mapToInt(In)
        System.out.println("elements are" + list);
        System.out.println(list.hashCode());

    }
}
