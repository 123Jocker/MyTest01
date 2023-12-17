package shiyan01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GradeManagementSystem {
	private Map<String, Map<String, Integer>> scores; // 存储学生成绩的映射表
	private Map<String, String> users; // 存储用户信息

	public GradeManagementSystem() {
		scores = new HashMap<>();
		users = new HashMap<>();
	}

	public void register() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = scanner.nextLine();
		System.out.println("请输入密码：");
		String password = scanner.nextLine();
		if (users.containsKey(username)) {
			System.out.println("该用户名已被注册！");
		} else {
			users.put(username, password);
			System.out.println("注册成功！");
		}
	}

	public boolean login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入用户名：");
		String username = scanner.nextLine();
		System.out.println("请输入密码：");
		String password = scanner.nextLine();
		if (users.containsKey(username) && users.get(username).equals(password)) {
			System.out.println("登录成功！");
			return true;
		} else {
			System.out.println("用户名或密码错误！");
			return false;
		}
	}

	public void addScore(String studentId, String courseName, int score) {
		Map<String, Integer> studentScores = scores.getOrDefault(studentId, new HashMap<>());
		studentScores.put(courseName, score);
		scores.put(studentId, studentScores);
	}

	public int getScore(String studentId, String courseName) {
		Map<String, Integer> studentScores = scores.get(studentId);
		if (studentScores != null) {
			Integer score = studentScores.get(courseName);
			if (score != null) {
				return score;
			}
		}
		return -1; // 表示找不到成绩记录
	}

	public void updateScore(String studentId, String courseName, int score) {
		if (scores.containsKey(studentId)) {
			Map<String, Integer> studentScores = scores.get(studentId);
			studentScores.put(courseName, score);
			scores.put(studentId, studentScores);
		}
	}

	public void deleteScore(String studentId, String courseName) {
		if (scores.containsKey(studentId)) {
			Map<String, Integer> studentScores = scores.get(studentId);
			studentScores.remove(courseName);
			scores.put(studentId, studentScores);
		}
	}

	public double getCourseAverageScore(String courseName) {
		int sum = 0;
		int count = 0;
		for (Map<String, Integer> courseScores : scores.values()) {
			if (courseScores.containsKey(courseName)) {
				sum += courseScores.get(courseName);
				count++;
			}
		}
		return count > 0 ? (double) sum / count : 0;
	}

	public int getCourseMaxScore(String courseName) {
		int maxScore = Integer.MIN_VALUE;
		for (Map<String, Integer> courseScores : scores.values()) {
			if (courseScores.containsKey(courseName)) {
				int score = courseScores.get(courseName);
				maxScore = Math.max(maxScore, score);
			}
		}
		return maxScore;
	}

	public int getCourseMinScore(String courseName) {
		int minScore = Integer.MAX_VALUE;
		for (Map<String, Integer> courseScores : scores.values()) {
			if (courseScores.containsKey(courseName)) {
				int score = courseScores.get(courseName);
				minScore = Math.min(minScore, score);
			}
		}
		return minScore;
	}

	public void displayStudentScore(String studentId) {
		if (scores.containsKey(studentId)) {
			Map<String, Integer> courseScores = scores.get(studentId);
			System.out.println("学生 " + studentId + " 的成绩：");
			for (String courseName : courseScores.keySet()) {
				int score = courseScores.get(courseName);
				System.out.println(courseName + ": " + score);
			}
		} else {
			System.out.println("找不到该学生的成绩记录！");
		}
	}

	public void displayAllScores() {
		for (String studentId : scores.keySet()) {
			Map<String, Integer> courseScores = scores.get(studentId);
			System.out.print("学生 " + studentId + " 的成绩：");
			for (String courseName : courseScores.keySet()) {
				int score = courseScores.get(courseName);
				System.out.print(courseName + ": " + score + ", ");
			}
			System.out.println();
		}
	}

	public void sortScoresDescending() {
		List<Map.Entry<String, Map<String, Integer>>> entryList = new ArrayList<>(scores.entrySet());
		Collections.sort(entryList, (e1, e2) -> {
			int totalScore1 = e1.getValue().values().stream().mapToInt(Integer::intValue).sum();
			int totalScore2 = e2.getValue().values().stream().mapToInt(Integer::intValue).sum();
			return Integer.compare(totalScore2, totalScore1);
		});

		System.out.println("按成绩从高往低排序结果：");
		for (Map.Entry<String, Map<String, Integer>> entry : entryList) {
			String studentId = entry.getKey();
			Map<String, Integer> courseScores = entry.getValue();
			System.out.print("学生 " + studentId + " 的成绩：");
			for (String courseName : courseScores.keySet()) {
				int score = courseScores.get(courseName);
				System.out.print(courseName + ": " + score + ", ");
			}
			System.out.println();
		}
	}
}
