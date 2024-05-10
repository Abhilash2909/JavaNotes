import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exceptions {
    public static void main(String[] args) throws IOException {
//        int i, j=0, k = 0;
//        int[] ar = new int[4];
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        i = 8;
//
//        try{
//            j = Integer.parseInt(br.readLine());
//            k = i / j;  // critical statement
//        }
//        catch (IOException e) {
//            System.out.println("Some IO error");
//        }
//        catch (ArithmeticException e){
//            System.out.println("Cannot divide by 0");
//        }
//        catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Maximum no. of values are 4");
//        }
//        catch (Exception e){  // this catch must be last block
//            System.out.println("Unknown Exception");
//        }
//
//        System.out.println(k);


//        2. try block with resources-->

//        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){  // resource
//
//            String str = "";
//
//            str = br.readLine();
//        }

        // Below lines are not required if the resource is created in try section
//        catch(Exception e){
//            System.out.println(e);
//        }
//        finally {
//            br.close();
//        }


//        3. Throw & Throws

//        int i, j=0, k = 0;
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        i = 8;
//
//        try{
//            System.out.println("Enter the num");
//            j = Integer.parseInt(br.readLine());
//            k = i + j;
//            if(k < 10) {
//                throw new ArithmeticException();
//            }
//            System.out.println("Output is : " + k);
//        }
//        catch (IOException e){
//            System.out.println("Some IO error");
//        }
//        catch (ArithmeticException e){
//            System.out.println("Min value for output is 10");
//        }
//        finally {
//            System.out.println("Finally BYE");
//        }


//      4. User Defined Exception
        int i = 15;
        try {
            if(i < 10) {
                throw new MyException("Error");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    static class MyException extends Exception
    {
        public MyException(String msg) {
            super(msg);
        }
    }
}