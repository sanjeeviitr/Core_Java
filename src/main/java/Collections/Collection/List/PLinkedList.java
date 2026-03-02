package Collections.Collection.List;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PLinkedList {

    static void main() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(10);
        list.add(50);
        list.add(40);
        list.add(30);
        list.push(60);

        System.out.println(list.peek());
        System.out.println(list.getFirst());
        System.out.println(list);
        list.pop();
        list.offer(90);
        list.poll();
        Collections.sort(list);
        System.out.println(list);
    }
}
