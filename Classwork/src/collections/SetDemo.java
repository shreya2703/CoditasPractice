package collections;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//null values allowed set.ad(null);
//duplicate values not allowed




//WHAT IS GENERICS that E integer why do we need it
public class SetDemo {

    public static void main(String[] args){
//        Set<Integer> set = new Set<Integer>() {  //dono side par interface likha hai esiliye
//            @Override
//            public int size() {
//                return 0;
//            }
//
//            @Override
//            public boolean isEmpty() {
//                return false;
//            }
//
//            @Override
//            public boolean contains(Object o) {
//                return false;
//            }
//
//            @Override
//            public Iterator<Integer> iterator() {
//                return null;
//            }
//
//            @Override
//            public Object[] toArray() {
//                return new Object[0];
//            }
//
//            @Override
//            public <T> T[] toArray(T[] a) {
//                return null;
//            }
//
//            @Override
//            public boolean add(Integer integer) {
//                return false;
//            }
//
//            @Override
//            public boolean remove(Object o) {
//                return false;
//            }
//
//            @Override
//            public boolean containsAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean addAll(Collection<? extends Integer> c) {
//                return false;
//            }
//
//            @Override
//            public boolean retainAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public boolean removeAll(Collection<?> c) {
//                return false;
//            }
//
//            @Override
//            public void clear() {
//
//            }
//        };

        Set<Integer> set = new HashSet<>(); //upcasting
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(7);
        set.add(9);


        Set<Integer> set1 = new HashSet<>(); //upcasting
        set1.add(2);
        set1.add(4);
        set1.add(6);
        set1.add(8);
        set1.add(10);


        set.addAll(set1);//union
        System.out.println(set.contains(11));
        System.out.println(set.contains(10));
        System.out.println(set.containsAll(set1));
        System.out.println(set.retainAll(set1));
        System.out.println(set.size());
        System.out.println(set.spliterator());


        //loop through
        //way1
        for(Integer i:set){
            System.out.println(i);
        }
       // System.out.println(set.retainAll(set1));//intersection odd wae hatt jaeynge
       //way2
//        Iterator<Integer> iterator = set.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());

//        }

    }
}
