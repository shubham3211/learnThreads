package x;

import java.util.concurrent.*;

class Worker extends Thread{
    String command;

    Worker(String command){
        this.command = command;
    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " "+ command);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

public class ExecutorWorkerThread {

    public static void main(String args[]){
//        ExecutorService e = Executors.newFixedThreadPool(3);
        ExecutorService e = Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            e.execute(new Worker(Integer.toString(i)));
        }

        e.shutdown();

        while(!e.isTerminated()){}
    }
}
