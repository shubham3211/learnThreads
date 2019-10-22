package x;
import java.util.concurrent.*;

class Message{
    public String msg;

    Message(String msg){
        this.msg = msg;
    }
    String getMsg(){
        return this.msg;
    }
}

class Comsumer implements Runnable{
    BlockingQueue<Message> queue;

    Comsumer(BlockingQueue queue){
        this.queue = queue;
    }

    public void run(){
        Message msg;
        try{
            while(true){
                String m = queue.take().getMsg();
                System.out.println(queue.remainingCapacity());
                if(m.equals("exit")){
                    break;
                }
                System.out.println(m);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Producer implements Runnable{
    BlockingQueue<Message> queue;
    Producer(BlockingQueue<Message> q){
        this.queue = q;
    }
    public void run(){
       try{
           queue.put(new Message("1"));
           queue.put(new Message("2"));
           queue.put(new Message("3"));
           queue.put(new Message("4"));
           queue.put(new Message("5"));
           queue.put(new Message("6"));
           queue.put(new Message("exit"));
       }catch(InterruptedException e){
           e.printStackTrace();
       }
    }
}

public class BlockingQueue1 {
    public static void main(String args[]){
        BlockingQueue<Message> queue = new ArrayBlockingQueue(5);
        Producer p = new Producer(queue);
        Comsumer c = new Comsumer(queue);
        Thread t1  = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();
    }
}
