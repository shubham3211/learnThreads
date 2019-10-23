package prcatice;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.*;

//import static java.lang.Character.isLetter;

interface Func{
    int op(int a, int b);
}

public class Lambda {
    public static UnaryOperator<Integer> fact;
    public static UnaryOperator<Integer> fib;
    public  static  BinaryOperator<Integer> prime;

    public static void main(String args[]){
//        fact = (n) -> n==0 ? 1 : n*fact.apply(n-1);
//        fib = (n) -> (n==0 || n==1) ? 0 : (n==2) ? 1 : fib.apply(n - 1) + fib.apply(n - 2);
//
//        for(int i=0;i<5;i++){
//            System.out.println(i + " fact "+ fact.apply(i));
//        }
//
//        for(int i=0;i<10;i++){
//            System.out.println(i+ " fib "+ fib.apply(i));
//        }
//
//        prime = (a, b) -> (b==1) ? 1 : (a%b == 0) ? 0 : prime.apply(a, b-1);
//        System.out.println(prime.apply(2, 1));
//
//        Func f = new Func(){
//            public int op(int a, int b){
//                return a+b;
//            }
//        };
//
//        System.out.println(f.op(10, 20));
//
//        Func add = (a, b) -> a+b;
//        Func sun = (a, b) -> a-b;
//        Func mul = (a, b) -> a*b;
//        Func div = (a, b) -> a/b;
//
//        System.out.println(add.op(1, 3));
//        System.out.println(sun.op(1, 3));
//        System.out.println(mul.op(5,6));
//        System.out.println(div.op(10,2));
//
//        Thread t = new Thread(new Runnable(){
//                public void run(){
//                    for(int i=0;i<100;i++){
//                        System.out.println(i);
//                    }
//                }
//            }
//        );
//        t.start();
//
//        new Thread(() -> System.out.println("hello qorld")).start();
//        new Thread(() -> System.out.println("hello geeks")).start();
//        new Thread(() -> System.out.println("hello")).start();

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<100;i++){
            arr.add(i);
        }
        ArrayList<Integer> odd = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();

        odd = (ArrayList<Integer>)arr.stream().filter((n) -> n%2==0).collect(Collectors.toList());
        even = (ArrayList<Integer>)arr.stream().filter((n) -> n%2!=0).collect(Collectors.toList());

        System.out.println(odd);
        System.out.println(even);

        ArrayList<Integer> sq = (ArrayList<Integer>) arr.stream().map((n) -> n*n).collect(Collectors.toList());
        System.out.println(sq);

        sq.replaceAll((n) -> n*n);
        System.out.println(sq);

        System.out.println(odd.stream().reduce(0, (ans, i) -> ans+i));

//        arr.forEach((n) -> System.out.print(n));

        Iterator it = arr.iterator();

//        while(it.hasNext()){
//            System.out.print(it.next());
//        }

        for(int i=0;i<arr.size();i++){
            arr.set(i, arr.get(i)+100);
        }

        System.out.println(arr);

        String str = "wdmqkwmdkqwmd;12m09e9120e13kwd01i2edlkm qwkld1923912lq c;s";
        String s1 = str.toUpperCase();
        String s2 = str.toLowerCase();
        for(int i=0;i<str.length();i++){
            if(Character.isLetter(str.charAt(i))){
                System.out.println("letter");
            }
            if(Character.isDigit(str.charAt(i))){
                System.out.println("Digit");
            }
            if(Character.isWhitespace(str.charAt(i))){
                System.out.println("White space");
            }
            if(Character.isUpperCase(str.charAt(i))){
                System.out.println("upper");
            }
            if(Character.isLowerCase(str.charAt(i))){
                System.out.println("Lower");
            }
        }
        System.out.println(s1);
        System.out.println(s2);

        BinaryOperator<Integer> op = BinaryOperator.maxBy((a,b ) -> (a>b) ? 1 : (a==b) ? 0 : -1);
        System.out.println(op.apply(2,3));

        BinaryOperator<Integer> bp = BinaryOperator.minBy((a, b) -> (a>b) ? 1: (a==b) ? 0 : -1);
        System.out.println(bp.apply(2, 1));
    }
}
