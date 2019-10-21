package x;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class CallableAdder implements Callable<Integer>{
    Integer op1;
    Integer op2;

    CallableAdder(Integer op1, Integer op2){
        this.op1 = op1;
        this.op2 = op2;
    }

    public Integer call() throws Exception{
        System.out.println("Executing sum of" + op1 +" "+ op2 + "="+(int)(op1+op2));
        return op1+op2;
    }
}

public class CallableTest {
    public Integer parallerSum() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>>  list = new ArrayList<Future<Integer>>();
        int count = 1, prev =0;
        for(int i=0;i<10;i++){
            System.out.println( "Prev:" + (int)(i-1) + "current:" + i);
            Future<Integer> f = executor.submit(new CallableAdder(i-1, i));
            list.add(f);
        }
        int sum = 0;
        for(Future<Integer> f: list){
            try{
                sum += f.get();
            }catch(InterruptedException e) {
                System.out.println("Thread Interrupted");
            }catch(ExecutionException e){
                System.out.println("Exeecution exception occured");
            }
        }
        executor.shutdown();
        return sum;
    }

    public static void main(String args[]){
        CallableTest c = new CallableTest();
        int s = c.parallerSum();
        System.out.println(s);
    }
}
