package OPPs;

abstract class Hospital {

 // Abstract methods (must be implemented by child classes)
 abstract void documents();
 abstract void ot();
 abstract void patients();
 abstract void operations();

 // Concrete method (common functionality)
 void hospitalInfo() {
     System.out.println("Hospital provides healthcare services");
 }
}

//Child class 1
class Doctor extends Hospital {

 void documents() {
     System.out.println("Doctor handles patient reports and prescriptions");
 }

 void ot() {
     System.out.println("Doctor performs surgeries in OT");
 }

 void patients() {
     System.out.println("Doctor diagnoses and treats patients");
 }

 void operations() {
     System.out.println("Doctor performs medical operations");
 }
}

//Child class 2
class Nurse extends Hospital {

 void documents() {
     System.out.println("Nurse maintains patient records");
 }

 void ot() {
     System.out.println("Nurse assists in OT");
 }

 void patients() {
     System.out.println("Nurse takes care of patients");
 }

 void operations() {
     System.out.println("Nurse supports hospital operations");
 }
}

//Main class
public class HospitalTest {

 public static void main(String[] args) {

     Hospital doc = new Doctor();
     doc.hospitalInfo();
     doc.documents();
     doc.ot();
     doc.patients();
     doc.operations();

     System.out.println("*********************");

     Hospital nurse = new Nurse();
     nurse.hospitalInfo();
     nurse.documents();
     nurse.ot();
     nurse.patients();
     nurse.operations();
 }
}