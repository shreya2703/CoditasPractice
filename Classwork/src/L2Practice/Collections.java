package L2Practice;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Collections {
    public static void main(String[] args) {

//        String str = "india is my country i love my india";
//        String[] arr = str.split(" ");
//        HashMap<String,Integer> hashMap = new HashMap<>();
//        for(int i=0;i<=arr.length;i++){
//            if(hashMap.containsKey(arr[i])){
//                hashMap.put(arr[i], hashMap.get(arr[i])+1);
//            }else{
//                hashMap.put(arr[i],1);
//            }
//        }
//        System.out.println(hashMap);
//        int[] a = new int[4];
//        int br[]={1,2,3};

        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(1,5);
        hm.put(1,6);
        hm.put(2,9);
        hm.put(null,5);
        hm.put(null,7);

        for(Map.Entry<Integer,Integer> map : hm.entrySet()){
            System.out.println(map.getKey() + " "+ map.getValue());

        }

        int a =15;
        int b =0;










    }

  // Collection<Integer> c = new ArrayList<>();




}
