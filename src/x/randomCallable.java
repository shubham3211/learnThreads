package x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Randon implements Callable {
    public Integer call(){
        return (int)(Math.random()*100);
    }
}

public class randomCallable {
    public static void main(String args[]){
        ExecutorService e = Executors.newFixedThreadPool(10);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for(int i=0;i<10;i++){
            list.add(e.submit(new Randon()));
        }
        for(Future<Integer> f:list){
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
