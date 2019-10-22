package x;
//import java.util.concurrent.*;
import java.util.concurrent.CountDownLatch;

class PrintName extends Thread{
    private CountDownLatch latch;

    PrintName(CountDownLatch latch){
        this.latch = latch;
    }

    public void run(){
        try {
            Thread.sleep(1000);
            System.out.println("print name");
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            latch.countDown();
        }
    }
}

class Task1 extends Thread{
    private int delay;
    private CountDownLatch latch;

    Task1(int delay, CountDownLatch latch, String name){
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    public void run(){
        try{
            Thread.sleep(delay*1000);
            System.out.println(Thread.currentThread().getName()+" finished the execution");
        }catch(InterruptedException e){
            System.out.println("Interrupted");
        }finally{
            latch.countDown();
        }
    }
}

public class CountDownLatch1 {
    public static void main(String args[]) throws InterruptedException{
        CountDownLatch latch1 = new CountDownLatch(4);
        CountDownLatch latch2 = new CountDownLatch(1);
        Task1 t1 = new Task1(10, latch1,"Shubham");
        Task1 t2 = new Task1(2, latch1, "Vikram");
        Task1 t3 = new Task1(4, latch1, "Sumit");
        PrintName p1 = new PrintName(latch2);
        Task1 t4 = new Task1(5, latch1, "Vikram");

        t1.start();
        t2.start();
        t3.start();
        p1.start();
        t4.start();
        latch1.await();
        latch2.await();

        System.out.println(Thread.currentThread().getName()+ " finished the execution");
    }
}
