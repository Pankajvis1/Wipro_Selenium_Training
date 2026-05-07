package Keywords;

public class static_keyword {

    int empid;
    String name;
    static String companyname = "Wipro";

    void show(int empid1, String name1) {

        empid = empid1;
        name = name1;

        System.out.println("empid = " + empid);
        System.out.println("name = " + name);
        System.out.println("companyname = " + companyname);
    }

    static void details(int empid1, String name1) {

        System.out.println("companyname = " + companyname);
        System.out.println("block");
    }

    public static void main(String[] args) {

        static_keyword emp = new static_keyword();

        emp.show(101, "Rohit");
        emp.show(102, "Mohan");
        emp.show(103, "Soham");

        details(101, "Rohit");
    }
}