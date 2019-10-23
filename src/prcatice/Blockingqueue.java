package prcatice;
import java.util.concurrent.*;


class Consumer extends Thread{
    BlockingQueue queue;

    Consumer(BlockingQueue queue){
        this.queue = queue;
    }

    public void run(){
        try{
            while(99-queue.remainingCapacity()!=0){
                System.out.println(queue.take()+" "+Thread.currentThread().getName()+" "+queue.remainingCapacity());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            System.out.println("here");
        }
    }
}

class Producer extends Thread{
    BlockingQueue queue;

    Producer(BlockingQueue queue){
        this.queue = queue;
    }

    public void run(){
        try{
            for(int i=0;i<100;i++){
                queue.put(i);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class Blockingqueue {
    public static void main(String args[]){
        BlockingQueue queue = new ArrayBlockingQueue(100);
        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        p.start();
        ExecutorService e = Executors.newSingleThreadExecutor();
        e.submit(c1);
        e.submit(c2);
        e.shutdown();
        while(!e.isTerminated()){}
    }
}
