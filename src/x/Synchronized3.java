package x;

class PrintDemo{
    public synchronized void print(){
        try{
            for(int i=0;i<5;i++){
                System.out.println(i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

class mThread extends Thread{
    PrintDemo pd;

    mThread(PrintDemo pd){
        this.pd = pd;
    }

    public void run(){
        pd.print();
    }
}

public class Synchronized3 {
    public static void main(String args[]){
        PrintDemo pd = new PrintDemo();
        mThread t1 = new mThread(pd);
        mThread t2 = new mThread(pd);
        mThread t3 = new mThread(pd);

        t1.start();
        t2.start();
        t3.start();
    }
}
