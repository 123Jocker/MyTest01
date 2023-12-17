package shiyan01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 创建成绩管理系统对象
		GradeManagementSystem system = new GradeManagementSystem();

		System.out.println("欢迎使用成绩管理系统！");

		while (true) {
			System.out.println("请选择操作：");
			System.out.println("1. 注册");
			System.out.println("2. 登录");
			System.out.println("0. 退出");

			int choice = scanner.nextInt();
			scanner.nextLine(); // 读取换行符

			switch (choice) {
			case 1:
				system.register(); // 调用注册方法
				break;
			case 2:
				if (system.login()) { // 调用登录方法
					System.out.println("登录成功！");
					// 登录成功后进入成绩管理系统e
					enterGradeManagementSystem(system, scanner);
				} else {
					System.out.println("登录失败，请重新登录或注册！");
				}
				break;
			case 0:
				System.out.println("感谢使用成绩管理系统，再见！");
				return;
			default:
				System.out.println("输入无效，请重新输入！");
			}
		}

	}

	// 进入成绩管理系统
	private static void enterGradeManagementSystem(GradeManagementSystem system, Scanner scanner) {
		while (true) {
			System.out.println("请选择操作：");
			System.out.println("1. 添加成绩记录");
			System.out.println("2. 修改成绩记录");
			System.out.println("3. 删除成绩记录");
			System.out.println("4. 获取学生的成绩");
			System.out.println("5. 显示所有成绩记录");
			System.out.println("0. 退出");

			int choice = scanner.nextInt();
			scanner.nextLine(); // 读取换行符

			switch (choice) {
			case 1:
				System.out.println("请输入学生ID：");
				String studentId = scanner.nextLine();
				System.out.println("请输入课程名称：");
				String courseName = scanner.nextLine();
				System.out.println("请输入成绩：");
				int score = scanner.nextInt();
				scanner.nextLine(); // 读取换行符
				system.addScore(studentId, courseName, score);
				System.out.println("添加成功！");
				break;
			case 2:
				System.out.println("请输入学生ID：");
				studentId = scanner.nextLine();
				System.out.println("请输入课程名称：");
				courseName = scanner.nextLine();
				System.out.println("请输入新的成绩：");
				score = scanner.nextInt();
				scanner.nextLine(); // 读取换行符
				system.updateScore(studentId, courseName, score);
				System.out.println("修改成功！");
				break;
			case 3:
				System.out.println("请输入学生ID：");
				studentId = scanner.nextLine();
				System.out.println("请输入课程名称：");
				courseName = scanner.nextLine();
				system.deleteScore(studentId, courseName);
				System.out.println("删除成功！");
				break;
			case 4:
				System.out.println("请输入学生ID：");
				studentId = scanner.nextLine();
				System.out.println("请输入课程名称：");
				courseName = scanner.nextLine();
				score = system.getScore(studentId, courseName);
				if (score != -1) {
					System.out.println("学生 " + studentId + " 的 " + courseName + " 成绩为: " + score);
				} else {
					System.out.println("找不到该学生的成绩记录！");
				}
				break;

			case 5:
				System.out.println("所有成绩记录如下：");
				system.displayAllScores();
				break;
			case 0:
				System.out.println("感谢使用成绩管理系统，再见！");
				return;
			default:
				System.out.println("输入无效，请重新输入！");
			}
		}
	}
}