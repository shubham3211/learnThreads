package x;
import java.util.*;
import java.util.concurrent.*;

class Adder implements Callable<Integer>{
    int a, b;
    Adder(int a, int b){
        this.a = a;
        this.b = b;
    }

    public Integer call(){
        return a+b;
    }
}

public class CallableAadder {
    public static void main(String args[]){
        ExecutorService e = Executors.newFixedThreadPool(3);
        List<Future<Integer>> l = new ArrayList<Future<Integer>>();
        for(int i=0;i<100;i++){
            l.add(e.submit(new Adder(i-1, i)));
        }
        for(Future<Integer> f:l){
            try{
                System.out.println(f.get());
            }catch(InterruptedException k){
                k.printStackTrace();
            }catch (ExecutionException k){
                k.printStackTrace();
            }
        }
        e.shutdown();
        while(!e.isTerminated()){}
    }
}
