package object_class_method;

public class Student {

    void details(int rollno, String name) {
        System.out.println("Rollno = " + rollno);
        System.out.println("Name = " + name);
    }

    void details(String name, int rollno) {
        System.out.println("Name = " + name);
        System.out.println("Rollno = " + rollno);
    }

    void details(int rollno, String name, int age) {
        System.out.println("Rollno = " + rollno);
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
    }

    public static void main(String[] args) {

        Student stud = new Student();

        stud.details(101, "Nisha", 20);

    }
}