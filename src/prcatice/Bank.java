package prcatice;

class BankService{
    public static String listServices[] = new String[0];
    public static Object lock = new Object();

    public static String[] updateList(String newService){
        String oldSevice []= listServices;
        synchronized (lock){
            listServices = new String[listServices.length+1];
            for(int i=0;i<oldSevice.length;i++){
                listServices[i]=oldSevice[i];
            }
            listServices[oldSevice.length]=newService;
            try{
                System.out.println("List updated");
                Thread.sleep(1000);
            }catch (InterruptedException e){

            }
            return listServices;
        }
    }
}

class Employee extends Thread{
    String name;

    Employee(String name){
        this.name =  name;
    }

    public void run(){
        BankService b = new BankService();
        BankService.updateList(name);
    }
}

public class Bank {
    public static void main(String args[]){
        Employee e1 = new Employee("Shubham");
        Employee e2 = new Employee("Vikram");
        e1.start();
        e2.start();
    }
}
