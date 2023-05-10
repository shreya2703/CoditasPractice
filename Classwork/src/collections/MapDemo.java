package collections;

import java.util.HashMap;
import java.util.Map;
//select and control java doc
//how to iterate a  map using for each
public class MapDemo {
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"B");
        map.put(4,"D");
        map.put(6,"F");
        map.put(8,"H");
        map.put(null,"L");
        map.put(null,"Z");
        map.put(10,"J");



        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"A");
        map1.put(3,"C");
        map1.put(5,"E");
        map1.put(7,"G");
        map1.put(9,"I");

       // System.out.println(map.compute());

        // Map.Entry<Integer,String> entry = map.entrySet();
        for(Map.Entry<Integer,String> entry: map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }





    }
}
