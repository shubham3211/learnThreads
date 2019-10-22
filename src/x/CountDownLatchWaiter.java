package x;
import java.util.concurrent.*;

public class CountDownLatchWaiter {
    public static void main(String args[]){
        CountDownLatch latch = new CountDownLatch(2);
        Waiter w = new Waiter(latch);
        Decrement d = new Decrement(latch);
        w.start();
        d.start();
    }
}

class Waiter extends Thread{
        private CountDownLatch latch;

        Waiter(CountDownLatch latch){
            this.latch = latch;
        }

        public void run(){
            try{
                latch.await();
                System.out.println("Both the latches are down");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
}

class Decrement extends Thread{
    private CountDownLatch latch;

    Decrement(CountDownLatch latch){
        this.latch = latch;
    }

    public void run(){
        try{
            Thread.sleep(1000);
            latch.countDown();
            System.out.println("First latch down");
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally{
            latch.countDown();
            System.out.println("Second latch Down");
        }
    }
}