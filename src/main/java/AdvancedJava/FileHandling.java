package AdvancedJava;
import java.io.*;
import java.util.Scanner;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) throws IOException {

//        File file = new File("test.txt");
//
//        if (file.createNewFile()) {
//            System.out.println("File created");
//        } else {
//            System.out.println("File already exists");
//        }

//        FileWriter writer = new FileWriter("test.txt");
//
//        writer.write("Hello Java File Handling 2");
//
//        writer.close();
//        File file = new File("test.txt");
//        Scanner sc = new Scanner(file);
//
//        while (sc.hasNextLine()) {
//            System.out.println(sc.nextLine());
//        }
//
//        sc.close();

//        File file = new File("test.txt");
//
//        if(file.delete()){
//            System.out.println("File deleted");
//        }

//        File file = new File("test.txt");
//
//        System.out.println(file.exists());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.length());

//        File file = new File("test.txt");
//        if(file.createNewFile()){
//            System.out.println("file got created");
//        }
//        else{
//            System.out.println("File already exists");
//        }
//
//        FileWriter writer = new FileWriter("test.txt");
//        writer.write("Writing");
//
//        writer.close();
//        File file = new File("test.txt");
//        Scanner sc = new Scanner(file);
//        while (sc.hasNextLine()){
//            System.out.println(sc.nextLine());
//        }
//        sc.close();

//        File file = new File("test.txt");
//        System.out.println(file.exists());
//        System.out.println(file.canRead());
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getName());

//        FileOutputStream fos = new FileOutputStream("test.txt");
//
//        fos.write("Hello".getBytes());
//
//        fos.close();

        FileReader reader = new FileReader("test.txt");

        int data;

        while((data = reader.read()) != -1){
            System.out.print((char)data);
        }

        reader.close();


    }
}

