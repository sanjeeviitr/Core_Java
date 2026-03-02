package ExceptionHandling;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PExceptionHandling {

    static void method3() {
        int a = 10 / 0;   // Exception here
    }

    static void method2() {
        method3();
    }

    static void method1() {
        method2();
    }

    public static void main(String[] args) throws IOException {
//        method1();
//        int x = 10 / 0;
//        System.out.println(x);

        try (FileReader fr = new FileReader("file.txt")) {
            // use file
        }
        catch (IOException e) {
            System.out.println(("Database error occurred " +  e));
            throw new RuntimeException("Service failed", e);
        }
        finally{
            System.out.println("hehe");
        }

        try {
            method1();
        } catch (ArithmeticException e) {
            System.out.println("Handled in main");
        }
    }
}