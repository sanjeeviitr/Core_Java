package Collections.Map;

import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PHashMap {

    static void main() {
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(map.hashCode());
        map.put(1,5);
        map.put(33442,62);
        map.put(4,62);
        map.put(63434,62);
        map.put(2,62);
        map.put(937,62);
        System.out.println(map.get(1));
        System.out.println(map.get(4));
        System.out.println(map.containsKey(1));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println("key " + key + " value " + value);
        }
        System.out.println(map.values());
        System.out.println(map.remove(1));
        System.out.println(map.remove(1,5));
    }
}
