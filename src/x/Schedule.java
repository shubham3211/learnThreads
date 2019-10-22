package x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Facts implements Callable<Integer>{
    int n;

    Facts(int n){
        this.n = n;
    }

    public Integer call() throws InterruptedException, ExecutionException{
        int f = 1;
        for(int i=1;i<=n;i++){
            f*=i;
        }
        return f;
    }
}

public class Schedule {
    public static void main(String args[]){
        ScheduledExecutorService e = Executors.newScheduledThreadPool(3);
        List<ScheduledFuture<Integer>>  list = new ArrayList<ScheduledFuture<Integer>>();

        for(int i=0;i<=5; i++){
            list.add(e.schedule(new Facts(i), 5, TimeUnit.SECONDS));
        }

        for(Future<Integer> f : list){
            try{
                System.out.println(f.get());
            }catch(InterruptedException i){
                System.out.println("Interuppted");
            }catch(ExecutionException j){
                System.out.println("Executed");
            }finally {
                e.shutdown();
            }
        }
    }
}
