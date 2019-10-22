package x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Factorial1 implements Callable{
    int n;

    Factorial1(int n){
        this.n = n;
    }

    public Integer call(){
        int k=1;
        for(int i=1;i<=n;i++){
            k*=i;
        }
        return k;
    }
}

public class FactCall1 {
    public static void main(String args[]){
        ExecutorService e = Executors.newFixedThreadPool(10);
        List<Future<Integer>> list = new ArrayList<Future<Integer>>();
        for(int i=0;i<5;i++){
            list.add(e.submit(new Factorial1(i)));
        }
        for(Future<Integer> f:list){
            try{
                System.out.println(f.get());
            }catch (InterruptedException k){
                k.printStackTrace();
            }catch (ExecutionException k){
                k.printStackTrace();
            }
        }
        e.shutdown();
        while (!e.isTerminated()){}
    }
}
