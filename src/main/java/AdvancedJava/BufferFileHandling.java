package AdvancedJava;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BufferFileHandling {

    static void main() throws IOException, ClassNotFoundException {
//        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
//        String line;
//        while((line = br.readLine()) != null){
//            System.out.println(line);
//        }
//
//        br.close();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        System.out.println(str);


//        FileOutputStream stream1 = new FileOutputStream("test.txt");
//        String temp = "hhdsabhsy hbwwh";
//        stream1.write(temp.getBytes());
//
//        stream1.close();
//
//        FileInputStream stream = new FileInputStream("test.txt");
//        int data;
//        while((data = stream.read())!=-1)
//        System.out.print((char)data);
//        stream.close();

//
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("test.txt")));
//        writer.write("hdhdyehhduhweuuuwueud");
//
//        writer.close();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));
//        String data;
//        while ((data = reader.readLine()) != null) {
//            System.out.println(data);
//        }
//        reader.close();

        Student s = new Student("sanjeev", 1);
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("student.txt"));
        stream.writeObject(s);
        stream.close();

        ObjectInputStream stream1 = new ObjectInputStream(new FileInputStream("student.txt"));
        Student st = (Student) stream1.readObject();
        System.out.println(st.getName() +" " +  st.getAge() );

    }
}
