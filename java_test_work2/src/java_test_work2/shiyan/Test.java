package shiyan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Test {
	abstract class User {
		// 用户名
		private String username;
		// 密码
		private String password;
		// 身份证号
		private String personID;
		// 电话号码
		private String phoneNumber;

		public User(String username, String password, String personID, String phoneNumber) {
			this.username = username;
			this.password = password;
			this.personID = personID;
			this.phoneNumber = phoneNumber;
		}

		// 用户名
		public String getUsername() {
			return username;
		}

		// 密码
		public String getPassword() {
			return password;
		}

		// 身份证号
		public String getPersonID() {
			return personID;
		}

		public abstract Score getScore();
	}

	class Student extends User {
		private String studentName;
		private int studentNumber;// 学生编号
		private Score score;

		public Student(String username, String password, String personID, String phoneNumber, String studentName,
				int studentNumber) {
			super(username, password, personID, phoneNumber);
			this.studentName = studentName;
			this.studentNumber = studentNumber;
			this.score = new Score(personID, studentName, studentNumber);
		}

		public int getStudentNumber() {
			return this.studentNumber;
		}

		public String getStudentName() {
			return studentName;
		}

		@Override
		public Score getScore() {
			return score;
		}
	}

	class UserStorage {
		private Map<String, Score> scoreTable;
		private Map<String, User> usersMap;
		private static volatile UserStorage instance;

		private UserStorage() {
			this.usersMap = new HashMap<>();
			this.scoreTable = new HashMap<>();
		}

		public static UserStorage getInstance() {
			if (instance == null) {
				synchronized (UserStorage.class) {
					if (instance == null) {
						instance = new UserStorage();
					}
				}
			}
			return instance;
		}

		public User login(String username, String password) {
			User user = usersMap.get(username);
			if (user != null && user.getPassword().equals(password)) {
				return user;
			} else {
				return null;
			}
		}

		public void registerUser(User newUser) {
			usersMap.put(newUser.getUsername(), newUser);
		}

		public Map<String, User> getUsers() {
			return usersMap;
		}

		public Student getStudentById(int studentNumber) {
			User user = usersMap.get(studentNumber);
			if (user instanceof Student) {
				return (Student) user;
			} else {
				return null;
			}
		}

		public Score getScoreByStudentNumber(String studentNumber) {
			// 假设 scoreTable 是一个映射，用于存储学生ID及其对应的成绩
			Score score = scoreTable.get(studentNumber);
			return score;
		}

		public void addScore(Score score) {
			scoreTable.put(score.getStudentID(), score);
		}

		public void addUser(Integer user, List<Integer> userList) {
			userList.add(user);
		}

		public void addUser(User newUser) {
			// TODO Auto-generated method stub

		}
	}

	class Score {
		private String studentID;
		private String studentName;
		private int studentNumber;
		private Map<String, Integer> courseGrades;

		public Score(String studentID, String studentName, int studentNumber) {
			this.studentID = studentID;
			this.studentName = studentName;
			this.studentNumber = studentNumber;
			this.courseGrades = new HashMap<>();
		}

		public String getStudentID() {
			return studentID;
		}

		public String getStudentName() {
			return studentName;
		}

		public int getStudentNumber() {
			return studentNumber;
		}

		public void setStudentID(String studentID) {
			this.studentID = studentID;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public void setStudentNumber(int studentNumber) {
			this.studentNumber = studentNumber;
		}

		public void addCourseGrade(String course, int grade) {
			courseGrades.put(course, grade);
		}

		public void updateGrade(String course, int grade) {
			if (courseGrades.containsKey(course)) {
				courseGrades.put(course, grade);
			} else {
				System.out.println("该课程不存在！");
			}
		}

		public void deleteGrade(String course) {
			if (courseGrades.containsKey(course)) {
				courseGrades.remove(course);
			} else {
				System.out.println("该课程不存在！");
			}
		}

		public void statisticsForCourse(String course) {
			List<Integer> gradesForCourse = new ArrayList<>();
			for (Map.Entry<String, Integer> entry : courseGrades.entrySet()) {
				if (entry.getKey().equals(course)) {
					gradesForCourse.add(entry.getValue());
				}
			}
			if (!gradesForCourse.isEmpty()) {
				double sum = 0;
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				for (int grade : gradesForCourse) {
					sum += grade;
					if (grade > max) {
						max = grade;
					}
					if (grade < min) {
						min = grade;
					}
				}
				double average = sum / gradesForCourse.size();
				System.out.println("课程 " + course + " 的统计信息如下：");
				System.out.println("平均成绩：" + average);
				System.out.println("最高成绩：" + max);
				System.out.println("最低成绩：" + min);
			} else {
				System.out.println("该课程暂无成绩记录！");
			}
		}

		public Map<String, Integer> findStudentGrades(int studentNumber) {
			Map<String, Integer> studentGrades = new HashMap<>();
			for (Map.Entry<String, Integer> entry : courseGrades.entrySet()) {
				studentGrades.put(entry.getKey(), entry.getValue());
			}
			return studentGrades;
		}

		public void sortGradesDescending() {
			Map<String, Integer> sortedGrades = courseGrades.entrySet().stream()
					.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(LinkedHashMap::new,
							(map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);

			System.out.println("按成绩从高往低排序后的成绩如下：");
			for (Map.Entry<String, Integer> entry : sortedGrades.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		}

		public void viewGrades() {
			System.out.println("学生ID: " + studentID);
			System.out.println("学生姓名: " + studentName);
			System.out.println("学号: " + studentNumber);
			System.out.println("课程成绩:");
			displayGrades();
		}

		// 添加获取指定课程成绩的方法
		public int getGrade(String course) {
			if (courseGrades.containsKey(course)) {
				return courseGrades.get(course);
			} else {
				return -1; // 如果课程成绩不存在，返回-1或者其他适当的值
			}
		}

		// 添加显示所有成绩的方法
		public void displayGrades() {
			for (Map.Entry<String, Integer> entry : courseGrades.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		}

		public void statisticsGrades() {
			// TODO Auto-generated method stub

		}

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		UserStorage userStorage = UserStorage.getInstance();

		User loggedInUser = null;
		boolean exit = false;
		while (!exit) {
			System.out.println("1. 注册");
			System.out.println("2. 登录");
			System.out.println("0. 退出");
			System.out.print("请选择一个选项：");
			int initialChoice = input.nextInt();
			switch (initialChoice) {
			case 1:
				// 注册新用户
				System.out.print("请输入用户名：");
				String regUsername = input.next();
				System.out.print("请输入密码：");
				String regPassword = input.next();
				System.out.print("请输入身份证号：");
				String regPersonID = input.next();
				System.out.print("请输入电话号码：");
				String regPhoneNumber = input.next();
				System.out.print("请输入学生姓名：");
				String studentName = input.next();
				System.out.print("请输入学生编号：");
				int studentNumber = input.nextInt();
				User newUser = new Student(regUsername, regPassword, regPersonID, regPhoneNumber, studentName,
						studentNumber);
				userStorage.registerUser(newUser);
				Score score = ((Student) newUser).getScore();
				System.out.println("注册成功！");
				break;
			case 2:
				// 登录
				System.out.print("请输入用户名：");
				String username = input.next();
				System.out.print("请输入密码：");
				String password = input.next();
				loggedInUser = userStorage.login(username, password);
				if (loggedInUser != null) {
					System.out.println("登录成功！");
					handleUserActions(loggedInUser, input, userStorage);
				} else {
					System.out.println("用户名或密码错误！");
				}
				break;
			case 0:
				exit = true;
				break;
			default:
				System.out.println("选项无效，请重新输入选项：");
			}
		}
		input.close();
	}

	private static void handleUserActions(User user, Scanner input, UserStorage userStorage) {
		if (user instanceof Student) {
			Student student = (Student) user;
			GradeManager gradeManager = GradeManager.getInstance(student.getScore(), userStorage);
			gradeManager.performActions(input, student.getStudentNumber());
		} else {
			System.out.println("未知用户类型！");
		}
	}

	class LoggedInUser {
		private Score score;
		private UserStorage userStorage;

		public LoggedInUser(Score score, UserStorage userStorage) {
			this.score = score;
			this.userStorage = userStorage;
		}

		public void manageGrades(Scanner input) {
			System.out.print("请输入学生学号：");
			int studentNumber = input.nextInt();
			GradeManager gradeManager = new GradeManager(score, userStorage);
			gradeManager.performActions(input, studentNumber);
		}
	}

	static class GradeManager {
		private final Score score;
		private final UserStorage userStorage;
		private final List<StudentGradeRecord> studentGradeRecords;

		private static GradeManager instance;

		private GradeManager(Score score, UserStorage userStorage) {
			this.score = score;
			this.userStorage = userStorage;
			this.studentGradeRecords = new ArrayList<>();
		}

		public static GradeManager getInstance(Score score, UserStorage userStorage) {
			if (instance == null) {
				instance = new GradeManager(score, userStorage);
			}
			return instance;
		}

		public void addStudentGradeRecord(StudentGradeRecord record) {
			studentGradeRecords.add(record);
		}

		public void performActions(Scanner input, int studentNumber) {
			Student student = userStorage.getStudentById(studentNumber);
			if (student != null) {
				score = student.getScore();

				boolean exit = false;
				while (!exit) {
					// 显示学生功能菜单
					System.out.println("==============================");
					System.out.println("===== 欢迎进入成绩管理页面 =====");
					System.out.println("===== 1. 查看成绩 =====");
					System.out.println("===== 2. 修改成绩 =====");
					System.out.println("===== 3. 添加成绩 =====");
					System.out.println("===== 4. 删除成绩 =====");
					System.out.println("===== 5. 查找学生的课程成绩 =====");
					System.out.println("===== 6. 统计课程成绩 =====");
					System.out.println("===== 7. 排序所有课程的成绩 =====");
					System.out.println("===== 8. 查找学生成绩 =====");
					System.out.println("===== 0. 退出成绩管理页面 =====");
					System.out.println("==============================");

					int choice = -1; // 初始化为无效值

					while (choice < 0 || choice > 8) {
						try {
							System.out.print("请输入选项（0-8）：");
							choice = input.nextInt();
							if (choice < 0 || choice > 8) {
								System.out.println("选项无效，请重新输入选项：");
							}
						} catch (InputMismatchException e) {
							System.out.println("输入无效，请重新输入选项：");
							input.next(); // 清除输入缓冲区
						}
					}

					switch (choice) {
					case 1:
						// 查看成绩
						score.viewGrades();
						break;
					case 2:
						// 修改成绩
						System.out.print("请输入课程名称：");
						String courseToModify = input.next();
						System.out.print("请输入新的成绩：");
						int newGrade = input.nextInt();
						score.updateGrade(courseToModify, newGrade);

						break;
					case 3:
						// 添加成绩
						System.out.print("请输入课程名称：");
						String courseToAdd = input.next();
						System.out.print("请输入成绩：");
						int gradeToAdd = input.nextInt();
						score.addCourseGrade(courseToAdd, gradeToAdd);
						break;
					case 4:
						// 删除成绩
						System.out.print("请输入要删除的课程名称：");
						String courseToDelete = input.next();
						score.deleteGrade(courseToDelete);
						break;
					case 5:
						// 查找学生的课程成绩
						System.out.print("请输入学生学号：");
						score.findStudentGrades(studentNumber);
						break;
					case 6:
						// 统计课程成绩
						score.statisticsGrades();
						break;
					case 7:
						// 排序所有课程的成绩
						score.sortGradesDescending();
						break;
					case 8:
						// 查找学生成绩
						System.out.print("请输入学生学号：");
						String studentIdToFind = input.next();
						score.findStudentGrades(studentNumber);
						break;
					case 0:
						exit = true;
						System.out.println("退出系统！");
						break;
					default:
						System.out.println("选项无效，请重新输入选项：");
						break;
					}
				}
			} else {
				System.out.println("学生学号无效，请重新输入！");
			}
			viewAllGrades();
		}

		public void viewAllGrades() {
			// 查看学生成绩单
			System.out.println("学生的所有成绩如下：");
			for (StudentGradeRecord record : studentGradeRecords) {
				System.out.println("序号: " + record.getSerialNumber() + ", 学生姓名: " + record.getStudentName() + ", 学号: "
						+ record.getStudentNumber() + ", 课程名称: " + record.getCourseName() + ", 成绩: "
						+ record.getGrade());
			}
		}

		public void addGrades(Scanner input) {
			input.nextLine(); // 清除输入缓冲区
			System.out.print("请输入学生ID: ");
			String studentID = input.nextLine();

			System.out.print("请输入学生姓名: ");
			String studentName = input.nextLine();

			System.out.print("请输入学生学号: ");
			int studentNumber = 0;
			try {
				studentNumber = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("输入无效，请重新输入学生学号：");
				return;
			}
			// 创建学生成绩信息或获取已有信息
			Score studentScore = UserStorage.getInstance().getScoreByStudentNumber(String.valueOf(studentNumber));
			if (studentScore == null) {
				studentScore = new Score(studentID, studentName, studentNumber);
				UserStorage.getInstance().addScore(studentScore);
			}

			// 提示用户输入课程名称和成绩
			System.out.print("请输入课程名称：");
			String course = input.next();
			System.out.print("请输入成绩：");

			// 添加对成绩的有效性验证
			int grade = 0;
			while (true) {
				try {
					grade = input.nextInt();
					if (grade < 0 || grade > 100) {
						throw new IllegalArgumentException("成绩无效，请输入有效成绩（0-100）！");
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("输入无效，请重新输入成绩：");
					input.nextLine(); // 清除输入缓冲区
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			}

			// 将课程成绩信息存储到学生成绩信息中
			studentScore.addCourseGrade(course, grade);
			System.out.println("成绩添加成功！");
		}

		public void modifyGrade(Scanner input) {
			System.out.print("请输入要修改成绩的课程名称：");
			String course = input.next();
			System.out.print("请输入新的成绩：");
			int grade = input.nextInt();
			score.updateGrade(course, grade);
			System.out.println("成绩修改成功！");
		}

		public void deleteGrade(Scanner input) {
			System.out.print("请输入要删除成绩的课程名称：");
			String course = input.next();
			score.deleteGrade(course);
			System.out.println("成绩删除成功！");
		}

		public void selectGrades(Scanner input) {
			System.out.print("请输入要查找成绩的课程名称：");
			String course = input.next();
			int grade = score.getGrade(course);
			System.out.println("课程 " + course + " 的成绩为：" + grade);
			System.out.print("请输入学生学号：");
			String studentNumber = input.next();
			Score studentScore = UserStorage.getInstance().getScoreByStudentNumber(studentNumber);
			if (studentScore != null) {
				int studentGrade = studentScore.getGrade(course);
				if (studentGrade != -1) {
					System.out.println("学号为 " + studentNumber + " 的学生在课程 " + course + " 的成绩为：" + studentGrade);
				} else {
					System.out.println("学号为 " + studentNumber + " 的学生没有在课程 " + course + " 中的成绩记录。");
				}
			} else {
				System.out.println("学号为 " + studentNumber + " 的学生没有成绩记录。");
			}
		}

		// 查找学生成绩
		public void findStudentGrades(Scanner input, String studentNumber) {
			Score studentScore = UserStorage.getInstance().getScoreByStudentNumber(studentNumber);
			if (studentScore != null) {
				System.out.println("学生学号为 " + studentNumber + " 的所有成绩如下：");
				studentScore.displayGrades();
			} else {
				System.out.println("学生学号为 " + studentNumber + " 的成绩记录不存在。");
			}
		}
	}
}
