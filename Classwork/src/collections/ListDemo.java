package collections;

import java.util.*;

public class ListDemo {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.ensureCapacity(23);
        list.size();
        list.add(2);
        list.add(3);
        list.set(1,78);

        for(Integer i: list){
            System.out.println(i);
        }
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(6);
        list.add(3);

        list.addAll(list1);
//        for(Integer i: list){
//            System.out.println(i);
//        }

        list.retainAll(list1);
        for(Integer i: list){
            System.out.println(i);
        }

        System.out.println(list.subList(0,1));

        LinkedList<Integer> ll = new LinkedList<>();
        ll.size();
        Collections.sort(ll);

        HashSet<Integer> hs = new HashSet<>();

       LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
       lhs.add(1);
       lhs.add(56);
       lhs.toArray();
                for(Integer i: lhs){
            System.out.println(i);
        }

    }
}
