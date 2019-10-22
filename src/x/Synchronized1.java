package x;
import  java.util.concurrent.*;
//class Line{
//    public synchronized void getLine(){
//        for(int i=0;i<10;i++){
//            try{
//                System.out.println(i);
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class t1 extends Thread{
//    Line l;
//
//    t1(Line l){
//        this.l = l;
//    }
//    public void run(){
//        l.getLine();
//    }
//}
//
//public class Synchronized1 {
//    public static void main(String args[]){
//        Line l = new Line();
//
//        t1 k1 = new t1(l);
//        t1 k2 = new t1(l);
//
//        k1.start();
//        k2.start();
//    }
//}

//class Line{
//    public void getLine(){
//        for(int i=0;i<10;i++){
//            try{
//                System.out.println(i);
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
//class t1 extends Thread{
//    Line l;
//
//    t1(Line l){
//        this.l = l;
//    }
//    public void run(){
//        l.getLine();
//    }
//}
//
//public class Synchronized1 {
//    public static void main(String args[]){
//        Line l = new Line();
//
//        t1 k1 = new t1(l);
//        t1 k2 = new t1(l);
//
//        ExecutorService e =  Executors.newSingleThreadExecutor();
//        e.execute(k1);
//        e.execute(k2);
//        e.shutdown();
//        while(!e.terminate()){}
//    }
//}

class Line{
    public static final Object lock = new Object();

    public synchronized static void getLine(){
        for(int i=0;i<10;i++){
            try{
                System.out.println(i);
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class t1 extends Thread{
    Line l;

    t1(Line l){
        this.l = l;
    }
    public void run(){
        l.getLine();
    }
}

public class Synchronized1 {
    public static void main(String args[]){
        Line l = new Line();

        t1 k1 = new t1(l);
        t1 k2 = new t1(l);

        k1.start();
        k2.start();
    }
}