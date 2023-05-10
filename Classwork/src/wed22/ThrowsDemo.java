package wed22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//use to solve compile time error
class Demo{
    public void show()  { //yeh compile time pr kaam karega (throws sirf)
        try {
            FileInputStream fi = new FileInputStream("abcd.txt");
        } catch (FileNotFoundException e) {
           // throw new RuntimeException(e); //throwing it explicitly //throwable clause ke time pr bhi throw use karr sakte hai
            System.out.println(e);
        }
    }
}
public class ThrowsDemo  {
    public static void main(String[] args) throws FileNotFoundException{
        Demo demo = new Demo();
        demo.show();
    }
}
