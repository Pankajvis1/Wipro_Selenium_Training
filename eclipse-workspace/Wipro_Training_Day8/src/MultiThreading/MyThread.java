package MultiThreading;

public class MyThread extends Thread {

    public void run() {
        
    	
    	System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        MyThread t0 = new MyThread(); // new state
        t0.start();

        MyThread t1 = new MyThread();
        t1.start();

        MyThread t2 = new MyThread();
        t2.start();
    }
}