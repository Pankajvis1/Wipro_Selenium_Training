package Encapsulation_practice;

public class Bankdetails {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        acc.deposit(1000);
        acc.withdraw(2000);

        System.out.println("Balance = " + acc.getBalance());

        Student st = new Student();

        System.out.println(st.rollno);     
        System.out.println(st.getName()); 
    }
}