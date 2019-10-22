package x;

class First{
    String name;

    public void dispaly(String name){
        System.out.println("["+name);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("]");
    }
}

class Second extends Thread{
    First f;
    String name;

    Second(First f, String name){
        this.f = f;
        this.name = name;
    }
    public void run(){
        synchronized (f){
            f.dispaly(name);
        }
    }
}

public class Synchronized2 {
    public static void main(String args[]){
        First f = new First();
        Second t1 = new Second(f,"Shubahm");
        Second t2 = new Second(f, "Vikram");
        Second t3 = new Second(f, "Pratap");

        t1.start();
        t2.start();
        t3.start();
    }
}
