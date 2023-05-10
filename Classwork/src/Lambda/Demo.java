package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo {
    public static void main(String[] args) {

        List<String> list1= Arrays.asList("Aarti","Kriti","Dhirti");
        list1.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        //anonymous class
        list1.forEach(yash -> System.out.println(yash));

        //method refernce anonymous class
        list1.forEach(System.out::println);



    }
}
