//package java_test_work2;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Score {
//	private int[] grades;
//
//	public Score() {
//		grades = new int[6];
//	}
//
//	public Score(int java, int math, int sql, int c_language, int software, int physics) {
//		grades = new int[] { java, math, sql, c_language, software, physics };
//	}
//
//	public int getJava() {
//		return grades[0];
//	}
//
//	public void setJava(int java) {
//		grades[0] = java;
//	}
//
//	public int getMath() {
//		return grades[1];
//	}
//
//	public void setMath(int math) {
//		grades[1] = math;
//	}
//
//	public int getSql() {
//		return grades[2];
//	}
//
//	public void setSql(int sql) {
//		grades[2] = sql;
//	}
//
//	public int getC_language() {
//		return grades[3];
//	}
//
//	public void setC_language(int c_language) {
//		grades[3] = c_language;
//	}
//
//	public int getSoftware() {
//		return grades[4];
//	}
//
//	public void setSoftware(int software) {
//		grades[4] = software;
//	}
//
//	public int getPhysics() {
//		return grades[5];
//	}
//
//	public void setPhysics(int physics) {
//		grades[5] = physics;
//	}
//
//	public int[] getGrades() {
//		return grades;
//	}
//
//	public void clearGrades() {
//		for (int i = 0; i < grades.length; i++) {
//			grades[i] = 0;
//		}
//	}
//
//	public int getTotalScore() {
//		int sum = 0;
//		for (int grade : grades) {
//			sum += grade;
//		}
//		return sum;
//	}
//
//	public List<Student> getStudentsList() {
//		List<Student> studentList = new ArrayList<>();
//		for (User user : UserStorage.getInstance().getUsers().values()) {
//			if (user instanceof Student) {
//				studentList.add((Student) user);
//			}
//		}
//		return studentList;
//	}
//
//	public int[] getAllGradesByCourse(int courseIndex) {
//		int[] allGrades = new int[getStudentsList().size()];
//		int index = 0;
//		for (Student student : getStudentsList()) {
//			allGrades[index] = student.getScore().getGrades()[courseIndex];
//			index++;
//		}
//		return allGrades;
//	}
//
//	@Override
//	public String toString() {
//		return "Java: " + grades[0] + "\t\nMath: " + grades[1] + "\t\nSQL: " + grades[2] + "\t\nC Language: "
//				+ grades[3] + "\t\nSoftware: " + grades[4] + "\t\nPhysics: " + grades[5];
//	}
//}
