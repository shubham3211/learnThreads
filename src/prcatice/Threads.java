package prcatice;

import java.util.concurrent.*;

class Display{
    public void print(){
        System.out.println("Shubham");
    }
}

class Ac implements Runnable{
    Display d;

    Ac(Display d){
        this.d = d;
    }

    public void printNumbers(){
        synchronized(this.d){
            for(int i=0;i<10;i++){
                System.out.println(i + Thread.currentThread().getName());
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public void run(){
        printNumbers();
    }
}

public class Threads {
    public static void main(String args[]){
        Display d = new Display();
        Ac a1 = new Ac(d);
        Ac a2 = new Ac(d);
        Ac a3 = new Ac(d);
        Thread t1 = new Thread(a1);
        Thread t2 = new Thread(a2);
        Thread t3 = new Thread(a3);
        t1.start();
        t2.start();
        t3.start();
    }
}
