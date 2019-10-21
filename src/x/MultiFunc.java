package x;
import java.util.concurrent.*;

public class MultiFunc {
    public static void main(String args[]){
        ExecutorService e = Executors.newFixedThreadPool(3);
        Future<Double> f1 = e.submit(new AreaOfCircle(2d));
        Future<Double> f2 = e.submit(new CircumOfCircle(2d));
        Future<Integer> f3 = e.submit(new Fact(5));
        try{
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        }catch(InterruptedException k){
            System.out.println("Interrupted Exception"+k);
        }catch(ExecutionException g){
            System.out.println(g);
        }
        e.shutdown();
    }
}

class AreaOfCircle implements Callable<Double>{
    Double radius;

    AreaOfCircle(Double radius){
        this.radius = radius;
    }

    public Double call() throws Exception{
        return Math.PI*radius*radius;
    }
}

class CircumOfCircle implements Callable<Double>{
    Double radius;

    CircumOfCircle(Double radius){
       this.radius = radius;
    }

    public Double call() throws InterruptedException{
        Thread.sleep(1000);
        return 2*Math.PI*radius;
    }
}

class Fact implements Callable<Integer>{
    int n;
    Fact(int n){
        this.n = n;
    }
    public Integer call() throws Exception{
        int num=1;
        for(int i=1;i<n;i++){
            num*=i;
        }
        return num;
    }
}


