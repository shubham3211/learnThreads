package x;

public class ExceptionTest {
    public static int divideByZero(int a, int b) throws ArithmeticException{
//        throw new NumberFormatException("number formaat");
        throw new ArithmeticException("e");
//        return a/b;
    }

    public static int computeDivision(int a, int b) throws ArithmeticException{
        int res = 0;
        try{
            res = divideByZero(a, b);
        }catch(ArithmeticException e){
            throw e;
        }
        return res;
    }

    public static void main(String args[]){
        int a = 1, b = 0;
        try{
            int i = computeDivision(a, b);
        }catch(Exception e){
            System.out.println("main");
        }finally {
            System.out.println("finally");
        }
    }
}
