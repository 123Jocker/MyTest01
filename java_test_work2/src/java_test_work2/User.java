//package java_test_work2;
//
////User 类
//public abstract class User {
//	private String username;
//	private String password;
//	private String personID;
//	private String phoneNumber;
//
//	public User(String username, String password, String personID, String phoneNumber) {
//		this.username = username;
//		this.password = password;
//		this.personID = personID;
//		this.phoneNumber = phoneNumber;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public abstract boolean login();
//
//	protected abstract void viewGrades();
//
//	protected abstract void modifyGrade(Student student, String courseName, int grade);
//
//	protected abstract void addGrades();
//
//	protected abstract void deleteGrade(int studentIdToDelete);
//
//	protected abstract void selectGrades(int studentIdToSelect);
//
//	protected abstract void statisticsGrades(int courseIndex);
//
//	protected abstract void sortGrades();
//}