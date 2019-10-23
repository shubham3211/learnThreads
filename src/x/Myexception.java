package x;

import java.util.Scanner;

class CustomException extends Exception{
//    CustomException(String msg){
//        super(msg);
//    }

    public String toString(){
        return "Entered value more than 20";
    }
}

public class Myexception {
    public static void enterValue(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        sc.nextLine();

        try{
            if(i>20){
                throw new CustomException();
            }
        }catch(CustomException e){
            System.out.println(e);
//            e.printStackTrace();
        }
        System.out.println("hello");
    }

    public static void main(String args[]) {
        enterValue();
    }
}
