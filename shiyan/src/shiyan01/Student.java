package shiyan01;

public class Student extends User {
	private int score;

	public Student(String username, String password, int score) {
		super(username, password);
		this.score = score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student{" + "username='" + getUsername() + '\'' + ", password='" + getPassword() + '\'' + ", score="
				+ score + '}';
	}
}
