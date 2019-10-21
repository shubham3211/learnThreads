package x;
//
////class Mythread extends Thread{
////    int total = 0;
////    public void run(){
////        synchronized (this){
////            for(int i=1;i<=100;i++){
////                total+=i;
////            }
////            this.notify();
////        }
////    }
////}
////
////public class MobilePhone{
////    public static void main(String args[]){
////        Mythread t = new Mythread();
////        synchronized (t){
////            try {
////                t.start();
////                t.wait();
////                System.out.println(t.total);
////            }catch (InterruptedException e){
////                System.out.println("Thread interupped");
////            }
////        }
////    }
////}
//
//
//class A{
//    public synchronized void d1(B b){
//        System.out.println("Inside A's d1 method");
//        try {
//            Thread.sleep(6000);
//            b.last();
//        }catch (InterruptedException e){
//            System.out.println("Interupted");
//        }
//    }
//
//    public synchronized void last(){
//        System.out.println("Inside A's last method");
//    }
//}
//
//class B{
//    public synchronized void d2(A a){
//        System.out.println("Inside B's d1 method");
//        try{
//            Thread.sleep(6000);
//            a.last();
//        }catch(InterruptedException e){
//            System.out.println("Interupted");
//        }
//    }
//
//    public synchronized void last(){
//        System.out.println("Inside B's last method");
//    }
//}
//
//class MyThread extends Thread{
//    MyThread(ThreadGroup g, String name){
//        super(g, name);
//
//    }
//    public void run(){
//        System.out.println("In child Thread group");
//        try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){
//            System.out.println("Interuption occured");
//        }
//    }
//}
//
//public class MobilePhone extends Thread{
//    A a = new A();
//    B b = new B();
//
//    public void m1(){
//        System.out.println(Thread.currentThread().getName());
//        this.start();
//        a.d1(b);
//    }
//
//    public void run(){
////        System.out.println(Thread.currentThread().getName());
////        b.d2(a);
//        for(int i=0;i<10;i++){
//            System.out.println("Executing "+i);
//        }
//    }
//
//
//    public static void main(String args[]){
////        MobilePhone t = new MobilePhone();
//////        System.out.println(Thread.currentThread().isDaemon());
//////        System.out.println(t.isDaemon());
////        t.setDaemon(true);
////        t.start();
////        try {
////            Thread.sleep(1000);
////        }catch(InterruptedException e){
////            System.out.println("Interupped");
////        }
////        System.out.println("End of program");
//
//        ThreadGroup g1 = new ThreadGroup("g1");
//        ThreadGroup g2 = new ThreadGroup(g1 ,"g1");
//        MyThread t1 = new MyThread(g1, "Child thread 1");
//        MyThread t2 = new MyThread(g1, "Child Thread 2");
//        t1.start();
//        t2.start();
//        System.out.println(g1.activeCount());
//        System.out.println(g1.activeGroupCount());
//        g1.list();
////        try {
////            Thread.sleep(10000);
////        }catch (InterruptedException e){
////            System.out.println("Interuppted");
////        }
//        System.out.println(g1.activeCount());
//        System.out.println(g1.activeGroupCount());
//        ThreadGroup sys = Thread.currentThread().getThreadGroup().getParent();
//        Thread[] t = new Thread[sys.activeCount()];
//        sys.enumerate(t); // All the active thread in the system will be copied to t
//        for(Thread k :t){
//            System.out.println(k.getName());
//        }
//    }
//}

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

//class Display{
//    ReentrantLock l = new ReentrantLock();
//    public void greet(String name){
//        l.lock();
//        for(int i=0;i<10;i++){
//            System.out.println("Good morning");
//            try {
//                System.out.println(name);
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                System.out.println("Interrupted");
//            }
//            System.out.println(name);
//        }
//        l.unlock();
//    }
//}
//
//class MyThread extends Thread{
//    Display display;
//    String name;
//
//    static ReentrantLock l = new ReentrantLock();
//
//    MyThread(Display display, String name){
//        this.display = display;
//        this.name = name;
//    }
//
//    public void run(){
//        try {
//            if (l.tryLock(100, TimeUnit.MILLISECONDS)) {
//                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(200000);
//                l.unlock();
//            } else {
//                System.out.println("cannot get the access to the lock");
//            }
//        }catch(InterruptedException e){
//            System.out.println("Interrupted");
//        }
//    }
//}
//
//public class MobilePhone {
//    public static void main(String args[]){
//        Display display = new Display();
//        MyThread t1 = new MyThread(display, "Shubham");
//        MyThread t2 = new MyThread(display, "Vikram");
//        t1.start();
//        t2.start();
//    }
//}

class MyThread implements Callable {
    String name;
    MyThread(String name){
        this.name = name;
    }
    public Object call() throws Exception{
        System.out.println(name+ "Job Started by Thread:"+ Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            System.out.println("Interrupted");
        }
//        System.out.println("Job completed by thread "+Thread.currentThread().getName());
        int sum = 0;
        for(int i=0;i<100;i++){
            sum+=i;
        }
        return sum;
    }
}

class CustomerThread extends Thread{
    static Integer custId = 0;
    private static ThreadLocal l = new ThreadLocal(){
        protected Integer initialValue(){
            return custId++;
        }
    };
    CustomerThread(String name){
        super(name);
    }
    public void run(){
        System.out.println(Thread.currentThread().getName() + "executed"+ l.get());
    }
}

public class MobilePhone{
    public static void  main(String args[]){
//        MyThread [] jobs = {new MyThread("Shubham"), new MyThread("Vikram"), new MyThread("Pratap"), new MyThread("Rana")};
//        ExecutorService service = Executors.newFixedThreadPool(3);
//        for(MyThread t: jobs){
//            Future f = service.submit(t);
//            System.out.println(f);
//        }
//        service.shutdown();
//        ThreadLocal l = new ThreadLocal();
//        System.out.println(l.get());
//        l.set("Shubham");
//        System.out.println(l.get());
//        l.remove();
//        System.out.println(l.get());
        CustomerThread c1 = new CustomerThread("Customer 1");
        CustomerThread c2 = new CustomerThread("Customer 2");
        CustomerThread c3 = new CustomerThread("Customer 3");
        c1.start();
        c2.start();
        c3.start();
    }
}