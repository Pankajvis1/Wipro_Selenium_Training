package MultiThreading;

public class testSynch extends Thread {

    static int count = 0;

    synchronized static void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " -> " + count);
    }

    public void run() {
        increment();
    }

    public static void main(String[] args) {

        testSynch t1 = new testSynch();
        testSynch t2 = new testSynch();
        testSynch t3 = new testSynch();

        t1.start();
        t2.start();
        t3.start();
    }
}