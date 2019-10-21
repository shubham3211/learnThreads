package x;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Tasks implements Callable<Integer> {
    public Integer call() throws Exception{
        int x = (int)(Math.random()*100);
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        return x;
    }
}

public class Callable1 {
    public static void main(String args[]){
        ExecutorService e = Executors.newFixedThreadPool(3);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for(int i=0;i<10;i++){
            Tasks t = new Tasks();
            Future<Integer> f = e.submit(t);
            list.add(f);
        }
        int sum = 0;
        for(Future<Integer> f: list){
            try {
                sum += f.get();
            }catch(InterruptedException i){
                System.out.println(i);
            }catch(ExecutionException j){
                System.out.println(j);
            }
        }
        System.out.println(sum);
        e.shutdown();
    }
}
