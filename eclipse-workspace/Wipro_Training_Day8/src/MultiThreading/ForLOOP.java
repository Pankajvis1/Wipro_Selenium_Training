package MultiThreading;

public class ForLOOP extends Thread {

    public void run() {
        
    	for (int i=0;i<2;i++) 
    		
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