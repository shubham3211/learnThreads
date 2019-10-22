package x;

import java.util.Collection;
import java.util.concurrent.*;

class Producers extends Thread{
    int x=0;
    BlockingQueue queue;

    Producers(BlockingQueue queue){
        this.queue = queue;
    }

    public void run(){
        for(int i=0;i<100;i++){
            try{
                queue.put(i);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Comsumer1 extends Thread{
    BlockingQueue queue;
    int x;
    Comsumer1(BlockingQueue queue, int x){
        this.x =x;
        this.queue = queue;
    }

    public void run(){
        while(100-queue.remainingCapacity()!=0){
            try {
                System.out.println(Thread.currentThread().getName() +  queue.take()+" " +this.x);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class BlockingQueue2 {
    public static void main(String args[]){
        BlockingQueue queue = new ArrayBlockingQueue(100);
        Producers p1 = new Producers(queue);
//        Producers p2 = new Producers(queue);
        Comsumer1 c1 = new Comsumer1(queue, 1);
        Comsumer1 c2 = new Comsumer1(queue, 2);
        p1.start();
//        p2.start();
        c1.start();
        c2.start();
    }
}
