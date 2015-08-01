
public class User {
	
	private String username;
	private String pin;
	private boolean clockedIn = false;
	
	public User(String username, String pin) {
		super();
		this.username = username;
		this.pin = pin;
	}

	public String getUsername() {
		return username;
	}

	

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public boolean isClockedIn() {
		return clockedIn;
	}

	public void setClockedIn(boolean clockedIn) {
		this.clockedIn = clockedIn;
	}
	
	
	
	
	
	

}
