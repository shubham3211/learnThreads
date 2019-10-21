package x;
import java.sql.SQLOutput;
import java.util.concurrent.*;
import java.util.*;

class BankService implements Callable<String []>{
    public static String [] listOfServices = new String[0];
    String newService;

    BankService(String newService){
        this.newService = newService;
    }

    public String[] call() throws InterruptedException, ExecutionException{
        String oldListOfServices [] = listOfServices;
        listOfServices = new String[oldListOfServices.length + 1];
        for(int i=0;i<listOfServices.length;i++){
            listOfServices[i]=oldListOfServices[i];
        }
        listOfServices[oldListOfServices.length] = newService;
        return listOfServices;
    }
}

public class Bank {
    public static void main(String args[]){
        ExecutorService e = Executors.newFixedThreadPool(3);
        List<Future<String []>> l = new ArrayList<Future<String[]>>();
        for(int i=0;i<10;i++){
            l.add(e.submit(new BankService(Integer.toString(i))));
        }
        try{
            for(Future<String []> f :l){
                String a [] = f.get();
                for(int i=0;i<a.length;i++){
                    System.out.println(a[i]);
                }
            }
        }catch(InterruptedException k){
            System.out.println(k);
        }catch(ExecutionException p){
            System.out.println(p);
        } finally {
            e.shutdown();
        }
    }
}
