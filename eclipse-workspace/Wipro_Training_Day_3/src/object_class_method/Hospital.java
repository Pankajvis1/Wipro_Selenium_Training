package object_class_method;

public class Hospital {

    void details(int patientId, String name) {
        System.out.println("Patient ID = " + patientId);
        System.out.println("Name = " + name);
    }

    void details(String name, int patientId) {
        System.out.println("Name = " + name);
        System.out.println("Patient ID = " + patientId);
    }

    void details(int patientId, String name, int age) {
        System.out.println("Patient ID = " + patientId);
        System.out.println("Name = " + name);
        System.out.println("Age = " + age);
    }

    public static void main(String[] args) {

        Hospital pat = new Hospital();

        pat.details(201, "tushar", 25);

    }
}