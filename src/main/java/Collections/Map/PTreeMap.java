package Collections.Map;

import java.util.Map;
import java.util.TreeMap;

public class PTreeMap {

    static void main() {

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("ab", 1);
        map.put("bc", 1);
        map.put("cd", 1);
        map.put("de", 1);
        map.put("ef", 1);
        map.put("gh", 1);
        map.put("jkjh", 1);
        map.put("ajhj", 1);
        map.remove("gh");
        map.remove("de",1);
        map.remove("ab",2);

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String curr = entry.getKey();
            Integer count = entry.getValue();
            System.out.println("curr " + curr + " count " + count);
        }
    }
}
