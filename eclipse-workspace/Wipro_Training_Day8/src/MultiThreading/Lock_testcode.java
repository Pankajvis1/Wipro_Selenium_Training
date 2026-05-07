package MultiThreading;

class Securelocker {

	private int lockerid;
	private boolean isLocked;
	private String passcode;

	private class SecurityManager {
		private boolean verifyPasscode(String code) {
			return passcode.equals(code);
		}
	}

	public Securelocker(int lockerid, String passcode) {
		this.lockerid = lockerid;
		this.passcode = passcode;
		this.isLocked = true;
	}

	public void lock() {
		isLocked = true;
		System.out.println("Locker " + lockerid + " is now locked");
	}

	public void unlock(String code) {
		SecurityManager security = new SecurityManager();

		if (security.verifyPasscode(code)) {
			isLocked = false;
			System.out.println("Locker " + lockerid + " unlocked successfully.");
		} else {
			System.out.println("Invalid passcode. Access denied.");
		}
	}

	public boolean isLocked() {
		return isLocked;
	}
}

public class Lock_testcode {
	public static void main(String[] args) {
		Securelocker locker = new Securelocker(101, "1234");

		System.out.println("Is Locked: " + locker.isLocked());

		locker.unlock("1111");
		System.out.println("Is Locked: " + locker.isLocked());

		locker.unlock("1234");
		System.out.println("Is Locked: " + locker.isLocked());

		locker.lock();
		System.out.println("Is Locked: " + locker.isLocked());
	}
}