package shiyan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class User {
	private String username;
	private String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}

class Student extends User {
	private String personID;
	private String phoneNumber;
	private String studentName;
	private Long studentNumber;
	private Score score;

	public Student(String username, String password, String personID, String phoneNumber, String studentName,
			Long studentNumber) {
		super(username, password);
		this.personID = personID;
		this.phoneNumber = phoneNumber;
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.score = new Score(String.valueOf(studentNumber), studentName, studentNumber);
	}

	public Score getScore() {
		return score;
	}

	public Long getStudentNumber() {
		return studentNumber;
	}

	// 用于更新指定课程的成绩
	public void updateGrade(String course, int newGrade) {
		score.updateGrade(course, newGrade);
	}

	// 用于删除指定课程的成绩
	public void deleteGrade(String course) {
		score.deleteGrade(course);
	}

	// 用于查看所有课程的成绩
	public void viewGrades() {
		score.viewGrades();
	}
}

class Score {
	String studentID;
	String studentName;
	private Long studentNumber;
	Map<String, Integer> courseGrades;

	public Score(String studentID, String studentName, Long studentNumber) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.setStudentNumber(studentNumber);
		this.courseGrades = new HashMap<>();
	}

	public void addCourseGrade(String course, int grade) {
		courseGrades.put(course, grade);
	}

	public void updateGrade(String course, int newGrade) {
		if (courseGrades.containsKey(course)) {
			courseGrades.put(course, newGrade);
			System.out.println("成绩更新成功！");
		} else {
			System.out.println("未找到对应课程成绩！");
		}
	}

	public void deleteGrade(String course) {
		if (courseGrades.containsKey(course)) {
			courseGrades.remove(course);
			System.out.println("成绩删除成功！");
		} else {
			System.out.println("未找到对应课程成绩！");
		}
	}

	public void viewGrades() {
		for (Map.Entry<String, Integer> entry : courseGrades.entrySet()) {
			System.out.println("课程名称: " + entry.getKey() + ", 成绩: " + entry.getValue());
		}
	}

	public Long getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Map<String, Integer> getCourseGrades() {
		return courseGrades;
	}

	public String getStudentName() {
		// TODO Auto-generated method stub
		return studentName;
	}
}

class StudentGradeRecord {
	private int serialNumber;
	private String studentName;
	private int studentNumber;
	private String courseName;
	private int grade;

	// 构造方法
	public StudentGradeRecord(int serialNumber, String studentName, int studentNumber, String courseName, int grade) {
		this.serialNumber = serialNumber;
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.courseName = courseName;
		this.grade = grade;
	}

	// getter 和 setter 方法
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}

public class UserStorage {

	private Map<String, Long> scoreTable = new HashMap<>();

	// 用于获取指定学生的课程成绩记录
	public List<StudentGradeRecord> getStudentGradeRecords(Long studentNumber) {
		List<StudentGradeRecord> records = new ArrayList<>();
		Long score = getScoreByStudentNumber(studentNumber);
		if (score != null) {
			int serialNumber = 1;
			for (Map.Entry<String, Integer> entry : score.getCourseGrades().entrySet()) {
				String course = entry.getKey();
				int grade = entry.getValue();

				// 创建一个新的StudentGradeRecord对象
				StudentGradeRecord record = new StudentGradeRecord(serialNumber, course, grade);

				// 将记录添加到列表中
				records.add(record);

				// 递增序号
				serialNumber++;
			}
		}
		return records;
	}

	public Long getScoreByStudentNumber(Long studentNumber) {
		return scoreTable.get(studentNumber);
	}

	public void updateGrades(String course, Long studentNumber, int newGrade) {
		Long score = scoreTable.get(studentNumber);
		if (score != null) {
			score.updateGrade(course, newGrade);
		}
	}

	public void deleteGrades(String course, String string) {
		Score score = scoreTable.get(string);
		if (score != null) {
			score.deleteGrade(course);
		}
	}

	public void addScore(String studentNumber, int score) {
		scoreTable.put(studentNumber, score);
	}

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
		User user = usersMap.get(String.valueOf(studentNumber));
		if (user instanceof Student) {
			return (Student) user;
		} else {
			return null;
		}
	}

	public void addGrades(Scanner input) {
		System.out.print("请输入学生ID: ");
		String studentID = input.next();

		System.out.print("请输入学生姓名: ");
		String studentName = input.next();

		System.out.print("请输入学生学号: ");
		long studentNumber = input.nextLong(); // 使用 nextLong() 获取 long 类型输入
		UserStorage userStorage;
		userStorage.addScore(studentNumber, score); // 添加学生成绩信息
		// 创建学生成绩信息或获取已有信息
		Score existingScore = scoreTable.get(studentNumber);
		if (existingScore == null) {
			existingScore = new Score(studentName, studentNumber); // 创建新的学生成绩信息
			scoreTable.put(studentNumber, existingScore); // 放入 scoreTable 中
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
				input.next(); // 清除输入缓冲区
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}

		// 将课程成绩信息存储到学生成绩信息中
		existingScore.addCourseGrade(course, grade);
		System.out.println("成绩添加成功！");
	}

	public void addScore(Score score) {
		Long studentNumber = score.getStudentNumber();
		scoreTable.put(studentNumber, score);
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
				Long studentNumber = input.nextLong();
				User newUser = new Student(regUsername, regPassword, regPersonID, regPhoneNumber, studentName,
						studentNumber);
				userStorage.registerUser(newUser);
				Score score = ((Student) newUser).getScore();
				userStorage.addScore(score); // 添加学生成绩信息
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

		} else {
			boolean exit = false;
			while (!exit) {
				System.out.println("1. 添加课程成绩记录");
				System.out.println("2. 修改课程成绩记录");
				System.out.println("3. 删除课程成绩记录");
				System.out.println("4. 查看所有课程成绩记录");
				System.out.println("0. 返回上一级菜单");
				System.out.print("请选择一个选项：");
				int choice = input.nextInt();
				switch (choice) {
				case 1:
					System.out.print("请输入课程名称：");
					String course = input.next();
					System.out.print("请输入成绩：");
					int grade = input.nextInt();

					break;
				case 2:
					System.out.print("请输入要修改的课程成绩记录的序号：");
					int serialNumber = input.nextInt();
					System.out.print("请输入新成绩：");
					int newGrade = input.nextInt();

					break;
				case 3:
					System.out.print("请输入要删除的课程成绩记录的序号：");
					int recordNumber = input.nextInt();

					break;
				case 4:

					break;
				case 0:
					exit = true;
					break;
				default:
					System.out.println("选项无效，请重新输入选项：");
				}
			}
		}
	}
}

class GradeManager {
	private Score score;
	private UserStorage userStorage;
	private List<StudentGradeRecord> studentGradeRecords;

	private static GradeManager instance;

	private GradeManager(Score score, UserStorage userStorage) {
		this.score = score;
		this.userStorage = userStorage;
		this.studentGradeRecords = new ArrayList<>();
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

					break;
				case 5:
					// 查找学生的课程成绩
					System.out.print("请输入学生学号：");

					break;
				case 6:
					// 统计课程成绩

					break;
				case 7:
					// 排序所有课程的成绩

					break;
				case 8:
					// 查找学生成绩
					System.out.print("请输入学生学号：");
					String studentIdToFind = input.next();

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
		viewAllGradeRecords();
	}

	public static GradeManager getInstance(Score score, UserStorage userStorage) {
		if (instance == null) {
			instance = new GradeManager(score, userStorage);
		}
		return instance;
	}

	// 用于添加课程成绩记录
	public void addGrades(Scanner input) {
		System.out.print("请输入学生ID: ");
		String studentID = input.next();

		System.out.print("请输入学生姓名: ");
		String studentName = input.next();

		System.out.print("请输入学生学号: ");
		String studentNumber;
		try {
			studentNumber = input.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("输入无效，请重新输入学生学号：");
			input.nextLine(); // 清除输入缓冲区
			return;
		}

		// 创建学生成绩信息或获取已有信息
		Score studentScore = getScoreByStudentNumber(String.valueOf(studentNumber));
		if (studentScore == null) {
			studentScore = new Score(String.valueOf(studentNumber), studentName, studentNumber);
			addScore(studentScore);
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

	private void addScore(Score studentScore) {
		// TODO Auto-generated method stub

	}

	private Score getScoreByStudentNumber(String valueOf) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addStudentGradeRecord(StudentGradeRecord record) {
		studentGradeRecords.add(record);
	}

	// 用于修改指定的课程成绩记录
	public void updateGradeRecord(int serialNumber, int newGrade) {
		if (serialNumber > 0 && serialNumber <= studentGradeRecords.size()) {
			StudentGradeRecord record = studentGradeRecords.get(serialNumber - 1);
			if (record.getStudentNumber() == score.getStudentNumber()) {
				String course = record.getCourseName();
				score.updateGrade(course, newGrade);
				userStorage.addScore(score);
				userStorage.updateGrades(course, String.valueOf(score.getStudentNumber()), newGrade);
				record.setGrade(newGrade);
				System.out.println("成绩更新成功！");
			} else {
				System.out.println("只能修改自己的成绩记录！");
			}
		} else {
			System.out.println("无效的序号！");
		}
	}

	// 用于删除指定的课程成绩记录
	public void deleteGradeRecord(int serialNumber) {
		if (serialNumber > 0 && serialNumber <= studentGradeRecords.size()) {
			StudentGradeRecord record = studentGradeRecords.get(serialNumber - 1);
			if (record.getStudentNumber() == score.getStudentNumber()) {
				String course = record.getCourseName();
				score.deleteGrade(course);
				userStorage.addScore(score);
				userStorage.deleteGrades(course, String.valueOf(score.getStudentNumber()));
				studentGradeRecords.remove(record);
				System.out.println("成绩删除成功！");
			} else {
				System.out.println("只能删除自己的成绩记录！");
			}
		} else {
			System.out.println("无效的序号！");
		}
	}

	// 用于查看所有的课程成绩记录
	public void viewAllGradeRecords() {
		if (studentGradeRecords.isEmpty()) {
			System.out.println("没有课程成绩记录！");
		} else {
			for (StudentGradeRecord record : studentGradeRecords) {
				System.out.println(record.getSerialNumber() + ". " + record.getStudentName() + " "
						+ record.getStudentNumber() + " " + record.getCourseName() + " " + record.getGrade());
			}
		}
	}
}
