package x;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Task implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            if(i==0){
                Date d = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                System.out.println(Thread.currentThread().getName()+ "Implemented at" + ft.format(d));
            }else{
                SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
                Date d = new Date();
                System.out.println(Thread.currentThread().getName() + "Executed at" + ft.format(d));
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}

public class Threads {
    public static void main(String args[]){
        Task t1 = new Task();
        Task t2 = new Task();
        Task t3 = new Task();
        Task t4 = new Task();
        Task t5 = new Task();

        ExecutorService pool = Executors.newFixedThreadPool(3);

        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.shutdown();
    }
}
