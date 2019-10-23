package prcatice;

import java.util.concurrent.*;

class AreaOfCircle implements Callable<Double>{
    public double radius;

    AreaOfCircle(double radius){
        this.radius = radius;
    }

    public Double call(){
        return Math.PI * radius *radius;
    }
}

class Circum implements Callable<Double>{
    double radius;

    Circum(double radius){
        this.radius = radius;
    }

    public Double call(){
        return Math.PI * radius *2;
    }
}

class Fact1 implements Callable<Integer>{
    int num;

    Fact1(int num){
        this.num =num;
    }

    public Integer call(){
        int k=1;
        for(int i=1;i<=num;i++){
            k*=i;
        }
        return  k;
    }
}

public class MultiFunc {
    public static void main(String args[]){
        ExecutorService e = Executors.newSingleThreadExecutor();
        AreaOfCircle a = new AreaOfCircle(5d);
        Circum c = new Circum(5d);
        Fact1 factor = new Fact1(5);

        Future<Double> f1 = e.submit(a);
        Future<Double> f2 = e.submit(c);
        Future<Integer> f3 = e.submit(factor);

        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        }catch (InterruptedException k){
            k.printStackTrace();
        }catch (ExecutionException k){
            k.printStackTrace();
        }

        e.shutdown();
        while(!e.isTerminated()){}
    }
}

