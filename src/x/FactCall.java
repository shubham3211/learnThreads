package x;

import java.util.*;
import java.util.concurrent.*;

class Factorial implements Callable<Integer>{
    int n;

    Factorial(int n){
        this.n = n;
    }

    public Integer call() throws Exception{
        int f = 1;
        for(int i=1;i<=n;i++){
            f*=i;
        }
        return f;
    }
}

public class FactCall {
    public static void main(String args[]){
        ScheduledExecutorService e = Executors.newScheduledThreadPool(3);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for(int i=0;i<5;i++){
            Factorial f = new Factorial(i);
            Future<Integer> fi =  e.submit(f);
            list.add(fi);
        }
        for(Future<Integer> f: list){
            try{
                System.out.println(f.get());
            }catch(InterruptedException i){
                System.out.println(i);
            }catch(ExecutionException j){
                System.out.println(j);
            }

        }
        e.shutdown();
    }
}
