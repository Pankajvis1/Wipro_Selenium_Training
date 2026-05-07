package FileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Student s = new Student(101, "Testcode");

        // Serialization
        FileOutputStream fos = new FileOutputStream("Sample.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.close();
        fos.close();

        // Deserialization
        FileInputStream fis = new FileInputStream("Sample.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student st = (Student) ois.readObject();
        ois.close();
        fis.close();

        System.out.println(st.id + "   " + st.name);
    }
}