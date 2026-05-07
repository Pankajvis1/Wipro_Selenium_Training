package Assignment;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Order implements Runnable {
	int orderId;

	Order(int orderId) {
		this.orderId = orderId;
	}

	public void run() {
		System.out.println("Order " + orderId + " is being delivered by " + Thread.currentThread().getName());

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}

		System.out.println("Order " + orderId + " delivered successfully by " + Thread.currentThread().getName());
	}
}

public class FoodDeliverySystem {
	public static void main(String[] args) {

		ExecutorService deliveryAgents = Executors.newFixedThreadPool(3);

		for (int i = 1; i <= 6; i++) {
			deliveryAgents.execute(new Order(i));
		}

		deliveryAgents.shutdown();
	}
}