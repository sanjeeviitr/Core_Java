package Collections.Collection.Queue;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PPriorityQueue {

    static void main() {

//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(90);
//        pq.add(50);
//        pq.add(100);
//        pq.offer(90);
//        pq.offer(50);
//        pq.offer(100);
////        Iterator<Integer> it = pq.iterator();
////        while (it.hasNext()){
////            System.out.println(it.next());
////        }
//
//        while(!pq.isEmpty()){
//            System.out.println(pq.poll());
//        }


        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(90);
        pq.add(50);
        pq.add(100);
        pq.offer(90);
        pq.offer(50);
        pq.offer(100);
//        Iterator<Integer> it = pq.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        System.out.println(pq.remove());

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        System.out.println(pq.remove(80));
//        System.out.println(pq.remove());

    }
}
