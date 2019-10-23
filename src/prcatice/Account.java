package prcatice;

class Acc{
    int currentBalance;

    Acc(int currentBalance){
        this.currentBalance = currentBalance;
    }

    public synchronized void withdraw(int amount){
        if(this.currentBalance>=amount){
            this.currentBalance-=amount;
            System.out.println("Money withdrawn");
        }else {
            System.out.println("not enough money in the account");
        }
    }
}

class As extends Thread{
    int amount;
    Acc account;

    As(Acc account, int amount){
        this.account = account;
        this.amount = amount;
    }

    public void run(){
        account.withdraw(amount);
    }
}

public class Account {
    public static void main(String args[]){
        Acc a = new Acc(10000);

        As h = new As(a,10000);
        As w = new As(a,10000);

        h.start();
        w.start();
    }
}
