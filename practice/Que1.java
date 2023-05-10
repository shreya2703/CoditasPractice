package practice;
class Thread1 extends Thread{
    public void run(){
        System.out.println("Thread1");
    }
}
class Thread2 extends Thread{
    public void run(){
        System.out.println("Thread2");
    }
}

public class Que1 {
    public static void main(String[] args){

        Thread1 t1 = new Thread1();
        t1.start();
        Thread2 t2 = new Thread2();
        t2.start();


    }
}
