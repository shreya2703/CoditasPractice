import java.io.Console;
public class ConsoleDemo {
    public static void main(String args[]){
        Console c=System.console();
        String name=c.readLine();
        char pwd[]=c.readPassword();
        String upwd=new String(pwd);
        if(name.equals("rt") && upwd.equals("rt")){
            System.out.println("Welcome ::"+name+" you are valid user!!!!");
        }
        else
            System.out.println("Sorry!!! password does not match :( ");
    }
}