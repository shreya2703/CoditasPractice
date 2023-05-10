package MultiThreading;

class SimpleDemo extends Thread{
    //after calling start control comes here and thread cycle begins from this point
    public void run(){
        for(int i=0;i<5;i++) {  //context switching ho raha hai and priority does not help to get the desired output
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Current thread " + Thread.currentThread());

        }
    }
//    public void display(){
//        System.out.println("Simple Demo");
//    }
}



public class ThreadDemo {
    public static void main(String[] args){

        for(int i=0;i<5;i++){

            try {
                System.out.println("main"+i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        SimpleDemo sd = new SimpleDemo();
       // sd.display();
        sd.setName("A");
        System.out.println(sd.getState());

        sd.start();//it will call run method implicitly
        SimpleDemo sd2 = new SimpleDemo();
        SimpleDemo sd3 = new SimpleDemo();
        sd2.setName("B");
        sd3.setName("C");
        System.out.println(sd2.getState());
        System.out.println(sd3.getState());
        sd2.start();
        sd3.start();
        System.out.println(sd.getState());
        System.out.println(sd2.getState());
        System.out.println(sd3.getState());

        //isalive getState set priority set daemon join
        //start method ek hi object m do baar

    }

}
