package prcatice;

import java.util.ArrayList;
import java.util.concurrent.*;

class Fact implements Callable<Integer> {
    int n;
    Fact(int n){
        this.n = n;
    }

    public Integer call(){
        System.out.println(Thread.currentThread().getName());
        int k=1;
        for(int i=1;i<=n;i++){
            k*=i;
        }
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return k;
    }
}

public class Factorial {
    public static void main(String args[]){
//        ExecutorService e = Executors.newFixedThreadPool(3);
        ExecutorService e = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> l= new ArrayList<Future<Integer>>();
        for(int i=0;i<10;i++){
            Future<Integer> f = e.submit(new Fact(i));
            l.add(f);
        }
        for(Future<Integer> f : l){
            try{
                System.out.println(f.get());
            }catch(InterruptedException k){

            }catch (ExecutionException k){

            }
        }
        e.shutdown();
        while(!e.isTerminated()){}
    }
}
