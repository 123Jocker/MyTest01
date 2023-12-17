package java_test_work04;

public class PetKeepers {
	private String keepername;
	private String password;

	public PetKeepers(String keepername, String password) {
		this.keepername = keepername;
		this.password = password;
	}

	public String getUsername() {
		return keepername;
	}

	public void setUsername(String keepername) {
		this.keepername = keepername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
