
package Monday13;

public class ArrayDuplicate {
    public static void main(String[] args) {
        int [] arr = new int[]{1, 2, 3, 2, 4, 6, 8, 8, 4, 9};
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    System.out.println(arr[j]);
                }
            }
        }


    }



}
